package it.gov.aifa.invoice_processor.runner.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.Invoice1_1;
import it.gov.aifa.invoice_processor.runner.JsonToDbUploader;
import it.gov.aifa.invoice_processor.service.InvoiceMappingToEntityConverter;
import it.gov.aifa.invoice_processor.service.MappingObjectFactory;
import it.gov.aifa.invoice_processor.service.persistence.InvoiceRepository;

@Service
public class JsonToDbUploaderImpl extends AbstractFilesystemCrawler implements JsonToDbUploader{

	private static final Logger log = LoggerFactory.getLogger(JsonToDbUploaderImpl.class);

	private InvoiceMappingToEntityConverter<Invoice1_1, Invoice> invoiceMappingToEntityConverter;
	private InvoiceRepository invoiceRepository;
	private MappingObjectFactory<Invoice1_1> invoiceMappingFactory;

	public JsonToDbUploaderImpl(
			InvoiceMappingToEntityConverter<Invoice1_1, Invoice> invoiceMappingToEntityConverter,
			InvoiceRepository invoiceRepository,
			MappingObjectFactory<Invoice1_1> invoiceMappingFactory) {
		this.invoiceMappingToEntityConverter = invoiceMappingToEntityConverter;
		this.invoiceRepository = invoiceRepository;
		this.invoiceMappingFactory = invoiceMappingFactory;
	}

	@Override
	protected void actionOnFile(final Path file) {
		String filePath = file.toUri().getPath();
		log.info("Processing {}", filePath);
		
		String fileContents;
		try {
			fileContents = Files.lines(file).collect(Collectors.joining());
		} catch (IOException e) {
			StringBuilder message = new StringBuilder();
			message.append("Cannot load the contents of ");
			message.append(filePath);
			log.error(message.toString(), e);
			return;
		}
		
		Invoice1_1 invoiceMapping;
		try {
			invoiceMapping = invoiceMappingFactory.buildFromJson(fileContents, Invoice1_1.class);
		} catch (Exception e) {
			StringBuilder message = new StringBuilder();
			message.append("Error creating a mapping object for ");
			message.append(filePath);
			log.error(message.toString(), e);
			return;
		}

		String invoiceId;
		try {
			invoiceId = invoiceMapping.getId();
		} catch (NullPointerException e) {
			StringBuilder message = new StringBuilder();
			message.append("Error while searching the id of ");
			message.append(filePath);
			log.error(message.toString(), e);
			return;
		}

		Invoice invoice;
		try {
			invoice = invoiceMappingToEntityConverter.convert(invoiceMapping);
		} catch (Exception e) {
			StringBuilder message = new StringBuilder();
			message.append("Error while converting mapping object to entity. Path: ");
			message.append(filePath);
			log.error(message.toString(), e);
			return;
		}
		if(!invoiceRepository.exists(invoiceId)){
			try {
				invoiceRepository.save(invoice);
			} catch (Exception e) {
				StringBuilder message = new StringBuilder();
				message.append("Error while converting mapping object to entity. Path: ");
				message.append(filePath);
				log.error(message.toString(), e);
				return;
			}
			log.info("Completed processing of: {}", filePath);
		}else{
			log.info("Skipping {} because it was already processed", filePath);
		}
	}
}

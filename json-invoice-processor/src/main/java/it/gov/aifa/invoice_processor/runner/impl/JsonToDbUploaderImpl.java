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
		StringBuilder message = new StringBuilder();
		String fileContents;
		try {
			fileContents = Files.lines(file).collect(Collectors.joining());
		} catch (IOException e) {
			message.append(e.getMessage());
			message.append(" while loading contents of ");
			message.append(filePath);
			throw new RuntimeException(message.toString(), e);
		}
		Invoice1_1 invoiceMapping;
		try {
			invoiceMapping = invoiceMappingFactory.buildFromJson(fileContents, Invoice1_1.class);
		} catch (Exception e) {
			message.append(e.getMessage());
			message.append(" creating a mapping object for ");
			message.append(filePath);
			throw new RuntimeException(message.toString(), e);
		}
		
		String invoiceId;
		
		try {
			invoiceId = invoiceMapping.getId();
		} catch (NullPointerException e) {
			message.append(e.getMessage());
			message.append(" while search the id of ");
			message.append(filePath);
			throw new RuntimeException(message.toString(), e);
		}
		
		if(!invoiceRepository.exists(invoiceId)){
			message.append("Processing ");
			message.append(filePath);
			Invoice invoice = invoiceMappingToEntityConverter.convert(invoiceMapping);
			invoiceRepository.save(invoice);
		}else{
			message.append("Skipping ");
			message.append(filePath);
			message.append(" because it was already processed");
		}
		log.info(message.toString());
	}
}

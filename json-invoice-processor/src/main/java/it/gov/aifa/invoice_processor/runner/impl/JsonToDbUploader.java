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
import it.gov.aifa.invoice_processor.service.InvoiceMappingToEntityConverter;
import it.gov.aifa.invoice_processor.service.MappingObjectFactory;
import it.gov.aifa.invoice_processor.service.persistence.InvoiceRepository;

@Service
public class JsonToDbUploader extends AbstractFilesystemCrawler{

	private static final Logger log = LoggerFactory.getLogger(JsonToDbUploader.class);
	
	private InvoiceMappingToEntityConverter<Invoice1_1, it.gov.aifa.invoice_processor.entity.invoice.Invoice> invoiceMappingToEntityConverter;
	private InvoiceRepository invoiceRepository;
	private MappingObjectFactory<Invoice1_1> invoiceMappingFactory;
	
	public JsonToDbUploader(InvoiceMappingToEntityConverter<Invoice1_1, Invoice> invoiceMappingToEntityConverter,
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
		Invoice1_1 invoiceMapping = invoiceMappingFactory.buildFromJson(fileContents, Invoice1_1.class);
		
		String invoiceId;
		
		try {
			invoiceId = invoiceMapping.getHttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica().getFatturaElettronicaBody().getDatiGenerali().getDatiGeneraliDocumento().getNumero();
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
		}else{
			message.append("Skipping ");
			message.append(filePath);
			message.append(" because it was already crawled");
		}
		log.info(message.toString());
	}
}
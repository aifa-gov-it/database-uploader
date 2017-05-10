package it.gov.aifa.invoice_processor.runner.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.AbstractComponentIT;
import it.gov.aifa.invoice_processor.constant.CommandLineArgumentKey;
import it.gov.aifa.invoice_processor.constant.TestConstant;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.runner.JsonToDbUploader;
import it.gov.aifa.invoice_processor.service.persistence.InvoiceRepository;

// Overwrite the properties to avoid loading data using Liquibase
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest({})
public class JsonToDbUploaderIT extends AbstractComponentIT{
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private JsonToDbUploader jsonToDbUploader;
	
	@Override
	public Object getComponent() {
		return jsonToDbUploader;
	}
	
	@DirtiesContext
	@Test
	public void runTest(){
		Properties properties = new Properties();
		properties.setProperty(CommandLineArgumentKey.PATH, TestConstant.TEST_DIRECTORY_PATH.toString());
		jsonToDbUploader.setArguments(properties);
		assertThat(invoiceRepository.count()).isEqualTo(0L);
		jsonToDbUploader.run();
		assertThat(invoiceRepository.count()).isEqualTo(1L);
		Invoice invoice = invoiceRepository.findOne(TestConstant.BOOTSTRAP_INVOICE_ID);
		assertThat(invoice).isNotNull();
		assertThat(invoice.getCedentePrestatore()).isNotNull();
		assertThat(invoice.getCessionarioCommittente()).isNotNull();
		assertThat(invoice.getFinancialInstitution()).isNotNull();
		assertThat(invoice.getLinkedInvoices()).isNotEmpty();
		assertThat(invoice.getPurchaseLines()).isNotEmpty();
		assertThat(invoice.getPurchaseOrders()).isNotEmpty();
	}
}
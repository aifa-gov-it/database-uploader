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
import it.gov.aifa.invoice_processor.entity.invoice.LinkedInvoice;
import it.gov.aifa.invoice_processor.entity.invoice.PurchaseLine;
import it.gov.aifa.invoice_processor.entity.invoice.PurchaseOrder;
import it.gov.aifa.invoice_processor.runner.JsonToDbUploader;
import it.gov.aifa.invoice_processor.service.persistence.FinancialInstitutionRepository;
import it.gov.aifa.invoice_processor.service.persistence.InvoiceCedentePrestatoreRepository;
import it.gov.aifa.invoice_processor.service.persistence.InvoiceParticipantRepository;
import it.gov.aifa.invoice_processor.service.persistence.InvoiceRepository;
import it.gov.aifa.invoice_processor.service.persistence.LinkedInvoiceRepository;
import it.gov.aifa.invoice_processor.service.persistence.PurchaseLineRepository;
import it.gov.aifa.invoice_processor.service.persistence.PurchaseOrderRepository;

// Overwrite the properties to avoid loading data using Liquibase
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest({})
public class JsonToDbUploaderIT extends AbstractComponentIT{
	
	@Autowired
	private FinancialInstitutionRepository financialInstitutionRepository;
	
	@Autowired
	private InvoiceCedentePrestatoreRepository invoiceCedentePrestatoreRepository;
	
	@Autowired
	private InvoiceParticipantRepository invoiceParticipantRepository;
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private JsonToDbUploader jsonToDbUploader;
	
	@Autowired
	private LinkedInvoiceRepository linkedInvoiceRepository;
	
	@Autowired
	private PurchaseLineRepository purchaseLineRepository;
	
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
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
		assertThat(invoiceCedentePrestatoreRepository.findOne(invoice.getCedentePrestatore().getId())).isNotNull();
		assertThat(invoiceParticipantRepository.findOne(invoice.getCessionarioCommittente().getId())).isNotNull();
		assertThat(financialInstitutionRepository.findOne(invoice.getFinancialInstitution().getIban())).isNotNull();
		for(LinkedInvoice linkedInvoice : invoice.getLinkedInvoices())
			assertThat(linkedInvoiceRepository.findOne(linkedInvoice.getId())).isNotNull();
		for(PurchaseLine purchaseLine : invoice.getPurchaseLines())
			assertThat(purchaseLineRepository.findOne(purchaseLine.getId())).isNotNull();
		for(PurchaseOrder purchaseOrder : invoice.getPurchaseOrders())
			assertThat(purchaseOrderRepository.findOne(purchaseOrder.getId())).isNotNull();
	}
}
package it.gov.aifa.invoice_processor.service.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.AbstractComponentIT;
import it.gov.aifa.invoice_processor.constant.TestConstant;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.entity.invoice.PurchaseLine;

public class InvoiceRepositoryIT extends AbstractComponentIT{
	
	@Autowired
	private InvoiceRepository repository;
	
	@Override
	public Object getComponent() {
		return repository;
	}
	
	@Test
	public void findOneTest() {
		Invoice invoice = repository.findOne(TestConstant.BOOTSTRAP_INVOICE_ID);
		assertThat(invoice.getCedentePrestatore()).isNotNull();
		assertThat(invoice.getCessionarioCommittente()).isNotNull();
		assertThat(invoice.getCurrency()).isNotBlank();
		assertThat(invoice.getDate()).isNotNull();
		assertThat(invoice.getDescription()).isNotBlank();
		assertThat(invoice.getDiscountAmount()).isGreaterThan(0);
		assertThat(invoice.getDiscountType()).isNotBlank();
		assertThat(invoice.getDocumentTypeCode()).isNotBlank();
		assertThat(invoice.getFinancialInstitution()).isNotNull();
		assertThat(invoice.getInvoiceSenderCode()).isNotBlank();
		assertThat(invoice.getInvoiceSenderCountryCode()).isNotBlank();
		assertThat(invoice.getInvoiceSendingNumber()).isNotBlank();
		assertThat(invoice.getInvoiceRecipientCode()).isNotBlank();
		assertThat(invoice.getInvoiceSendingFormat()).isNotBlank();
		assertThat(invoice.getInvoiceTax()).isNotNull();
		assertThat(invoice.getInvoiceVersion().getVersion()).isEqualTo(TestConstant.BOOTSTRAP_INVOICE_VERSION);
		assertThat(invoice.getNumber()).isEqualTo(TestConstant.BOOTSTRAP_INVOICE_ID);
		assertThat(invoice.getPaymentAmount()).isGreaterThan(0);
		assertThat(invoice.getPaymentConditions()).isNotBlank();
		assertThat(invoice.getPaymentExpirationDate()).isNotNull();
		assertThat(invoice.getPaymentMode()).isNotBlank();
		assertThat(invoice.getPaymentTermDays()).isGreaterThan(0);
		assertThat(invoice.getPurchaseLines()).isNotEmpty();
		for(PurchaseLine purchaseLine : invoice.getPurchaseLines())
			assertThat(purchaseLine.getInvoice()).isEqualTo(invoice);
		assertThat(invoice.getSoggettoEmittente()).isNotBlank();
		assertThat(invoice.getSoggettoEmittenteName()).isNotBlank();
		assertThat(invoice.getStampAmount()).isGreaterThan(0);
		assertThat(invoice.getTaxableAmount()).isGreaterThan(0);
		assertThat(invoice.getTaxDue()).isNotBlank();
		assertThat(invoice.getTotalAmount()).isGreaterThan(0);
		assertThat(invoice.getTransportDocumentDate()).isNotNull();
		assertThat(invoice.getTransportDocumentId()).isNotBlank();
		assertThat(invoice.getVirtualStamp()).isNotNull();
	}
}
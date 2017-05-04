package it.gov.aifa.invoice_processor.service.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.AbstractComponentIT;
import it.gov.aifa.invoice_processor.constant.TestConstant;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;

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
		assertThat(invoice.getNumber()).isEqualTo(TestConstant.BOOTSTRAP_INVOICE_ID);
		assertThat(invoice.getInvoiceVersion().getVersion()).isEqualTo(TestConstant.BOOTSTRAP_INVOICE_VERSION);
	}
}
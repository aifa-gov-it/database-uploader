package it.gov.aifa.invoice_processor.service.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.AbstractComponentIT;
import it.gov.aifa.invoice_processor.constant.TestConstant;
import it.gov.aifa.invoice_processor.entity.invoice.LinkedInvoice;

public class LinkedInvoiceRepositoryIT extends AbstractComponentIT{
	
	@Autowired
	private LinkedInvoiceRepository repository;
	
	@Override
	public Object getComponent() {
		return repository;
	}
	
	@Test
	public void findOneTest() {
		LinkedInvoice linkedInvoice = repository.findOne(TestConstant.BOOTSTRAP_LINKED_INVOICE_ID);
		assertThat(linkedInvoice.getId()).isEqualTo(TestConstant.BOOTSTRAP_LINKED_INVOICE_ID);
		assertThat(linkedInvoice.getInvoice()).isNotNull();
	}
}
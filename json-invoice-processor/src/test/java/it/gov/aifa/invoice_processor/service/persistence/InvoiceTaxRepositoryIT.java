package it.gov.aifa.invoice_processor.service.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.AbstractComponentIT;
import it.gov.aifa.invoice_processor.constant.TestConstant;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceTax;

public class InvoiceTaxRepositoryIT extends AbstractComponentIT{
	
	@Autowired
	private InvoiceTaxRepository repository;
	
	@Override
	public Object getComponent() {
		return repository;
	}
	
	@Test
	public void findOneTest() {
		InvoiceTax invoiceTax = repository.findOne(TestConstant.BOOTSTRAP_INVOICE_TAX_ID);
		assertThat(invoiceTax.getId()).isEqualTo(TestConstant.BOOTSTRAP_INVOICE_TAX_ID);
	}
}
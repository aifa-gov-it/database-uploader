package it.gov.aifa.invoice_processor.service.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.AbstractComponentIT;
import it.gov.aifa.invoice_processor.constant.TestConstant;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceVersion;

public class InvoiceVersionRepositoryIT extends AbstractComponentIT{
	
	@Autowired
	private InvoiceVersionRepository repository;
	
	@Override
	public Object getComponent() {
		return repository;
	}
	
	@Test
	public void findOneTest() {
		InvoiceVersion invoiceVersion = repository.findOne(TestConstant.BOOTSTRAP_INVOICE_SHORT_VERSION);
		assertThat(invoiceVersion.getVersion()).isEqualTo(TestConstant.BOOTSTRAP_INVOICE_SHORT_VERSION);
	}

}
package it.gov.aifa.invoice_processor.service.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.AbstractComponentIT;
import it.gov.aifa.invoice_processor.constant.TestConstant;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceCedentePrestatore;

public class InvoiceCedentePrestatoreRepositoryIT extends AbstractComponentIT{
	
	@Autowired
	private InvoiceCedentePrestatoreRepository repository;
	
	@Override
	public Object getComponent() {
		return repository;
	}
	
	@Test
	public void findOneTest() {
		InvoiceCedentePrestatore invoiceCedentePrestatore = repository.findOne(TestConstant.BOOTSTRAP_INVOICE_PARTICIPANT_ID);
		assertThat(invoiceCedentePrestatore.getId()).isEqualTo(TestConstant.BOOTSTRAP_INVOICE_PARTICIPANT_ID);
	}
}
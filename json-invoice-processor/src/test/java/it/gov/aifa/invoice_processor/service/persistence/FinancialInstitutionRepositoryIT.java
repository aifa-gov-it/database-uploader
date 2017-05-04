package it.gov.aifa.invoice_processor.service.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.AbstractComponentIT;
import it.gov.aifa.invoice_processor.constant.TestConstant;
import it.gov.aifa.invoice_processor.entity.invoice.FinancialInstitution;

public class FinancialInstitutionRepositoryIT extends AbstractComponentIT{
	
	@Autowired
	private FinancialInstitutionRepository repository;
	
	@Override
	public Object getComponent() {
		return repository;
	}
	
	@Test
	public void findOneTest() {
		FinancialInstitution financialInstitution = repository.findOne(TestConstant.BOOTSTRAP_FINANCIAL_INSTITUTION_ID);
		assertThat(financialInstitution.getIban()).isEqualTo(TestConstant.BOOTSTRAP_FINANCIAL_INSTITUTION_ID);
	}
}
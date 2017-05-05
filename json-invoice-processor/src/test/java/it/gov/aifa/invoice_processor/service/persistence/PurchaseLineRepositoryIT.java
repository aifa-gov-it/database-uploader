package it.gov.aifa.invoice_processor.service.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.AbstractComponentIT;
import it.gov.aifa.invoice_processor.constant.TestConstant;
import it.gov.aifa.invoice_processor.entity.invoice.PurchaseLine;

public class PurchaseLineRepositoryIT extends AbstractComponentIT{
	
	@Autowired
	private PurchaseLineRepository repository;
	
	@Override
	public Object getComponent() {
		return repository;
	}
	
	@Test
	public void findOneTest() {
		PurchaseLine purchaseLine = repository.findOne(TestConstant.BOOTSTRAP_PURCHASE_LINE_ID);
		assertThat(purchaseLine.getId()).isEqualTo(TestConstant.BOOTSTRAP_PURCHASE_LINE_ID);
		assertThat(purchaseLine.getItem()).isNotNull();
		assertThat(purchaseLine.getQuantity()).isGreaterThan(0);
		assertThat(purchaseLine.getTax()).isNotNull();
		assertThat(purchaseLine.getTotalPrice()).isGreaterThan(0);
		assertThat(purchaseLine.getUnitOfMeasureDescription()).isNotBlank();
		assertThat(purchaseLine.getUnitPrice()).isGreaterThan(0);
	}
}
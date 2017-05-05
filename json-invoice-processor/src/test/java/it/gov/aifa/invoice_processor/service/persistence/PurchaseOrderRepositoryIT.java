package it.gov.aifa.invoice_processor.service.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.AbstractComponentIT;
import it.gov.aifa.invoice_processor.constant.TestConstant;
import it.gov.aifa.invoice_processor.entity.invoice.PurchaseOrder;

public class PurchaseOrderRepositoryIT extends AbstractComponentIT{
	
	@Autowired
	private PurchaseOrderRepository repository;
	
	@Override
	public Object getComponent() {
		return repository;
	}
	
	@Test
	public void findOneTest() {
		PurchaseOrder purchaseOrder = repository.findOne(TestConstant.BOOTSTRAP_PURCHASE_ORDER_ID);
		assertThat(purchaseOrder.getCigCode()).isNotBlank();
		assertThat(purchaseOrder.getId()).isEqualTo(TestConstant.BOOTSTRAP_PURCHASE_ORDER_ID);
		assertThat(purchaseOrder.getInvoice()).isNotNull();
		assertThat(purchaseOrder.getPurchaseLine()).isNotNull();
	}
}
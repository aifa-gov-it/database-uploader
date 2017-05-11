package it.gov.aifa.invoice_processor.service.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.AbstractComponentIT;
import it.gov.aifa.invoice_processor.constant.TestConstant;
import it.gov.aifa.invoice_processor.entity.movement.Movement;

public class MovementRepositoryIT extends AbstractComponentIT{
	
	@Autowired
	private MovementRepository repository;
	
	@Override
	public Object getComponent() {
		return repository;
	}
	
	@Test
	public void findOneTest() {
		Movement movement = repository.findOne(TestConstant.BOOTSTRAP_MOVEMENT_ID);
		assertThat(movement.getAccountHolderCode()).isNotBlank();
		assertThat(movement.getAccountHolderTypeCode()).isNotBlank();
		assertThat(movement.getAic()).isNotBlank();
		assertThat(movement.getCustomerCode()).isNotBlank();
		assertThat(movement.getCustomerTypeCode()).isNotBlank();
		assertThat(movement.getDocumentNumber()).isNotBlank();
		assertThat(movement.getDocumentTypeCode()).isNotBlank();
		assertThat(movement.getExpirationDate()).isNotNull();
		assertThat(movement.getId()).isNotNull();
		assertThat(movement.getLot()).isNotBlank();
		assertThat(movement.getMovementCode()).isNotBlank();
		assertThat(movement.getQuantity()).isGreaterThan(0);
		assertThat(movement.getRecipientCode()).isNotBlank();
		assertThat(movement.getRecipientTypeCode()).isNotBlank();
		assertThat(movement.getSenderCode()).isNotBlank();
		assertThat(movement.getSenderTypeCode()).isNotBlank();
		assertThat(movement.getTransmissionDateTime()).isNotNull();
		assertThat(movement.getValue()).isGreaterThan(0);
	}
}
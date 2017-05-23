package it.gov.aifa.invoice_processor.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.entity.movement.Movement;

public class MovementProcessorTest {
	@Test
	public void processTest() throws Exception {
		Movement movement = new Movement();
		String date = "2017-05-11";
		String time = "15:53:42";
		movement.setTransmissionDate(date);
		movement.setTransmissionTime(time);
		movement.setRawExpirationDate("2017-05-12");
		MovementProcessor movementProcessor = new MovementProcessor();
		Movement processedMovement = movementProcessor.process(movement);
		assertThat(processedMovement.getTransmissionDateTime().toString()).isEqualTo(date + "T" + time);
		assertThat(processedMovement.getExpirationDate().toString()).isEqualTo(processedMovement.getRawExpirationDate());
		for(String idValue : processedMovement.getIdValues()) {
			assertThat(processedMovement.getId()).contains(idValue);
		}
	}
}

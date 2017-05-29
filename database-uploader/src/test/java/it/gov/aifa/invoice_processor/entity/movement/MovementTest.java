package it.gov.aifa.invoice_processor.entity.movement;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.entity.AbstractEntityTest;

public class MovementTest extends AbstractEntityTest<Movement>{
	
	@Test
	public void movementExpirationDateTest() throws Exception {
		Movement movement = new Movement();
		movement.setRawExpirationDate("2017-05-12");
		assertThat(movement.getExpirationDate().toString()).isEqualTo(movement.getRawExpirationDate());
	}
	
	@Test
	public void movementTransmissionDateTimeTest() throws Exception {
		Movement movement = new Movement();
		String date = "2017-05-11";
		String time = "15:53:42";
		movement.setTransmissionDate(date);
		movement.setTransmissionTime(time);
		assertThat(movement.getTransmissionDateTime().toLocalDateTime().toLocalDate().toString()).isEqualTo(date);
		assertThat(movement.getTransmissionDateTime().toLocalDateTime().toLocalTime().toString()).isEqualTo(time);
	}

	@Override
	protected Movement buildEntityForIdTest() {
		return new Movement("aic", "documentNumber", "documentTypeCode", "lot", "2017-05-25", "08:55:45");
	}

	@Override
	protected int getExpectedIdValuesSize() {
		return 4;
	}
}

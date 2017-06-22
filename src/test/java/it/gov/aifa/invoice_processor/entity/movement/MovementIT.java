package it.gov.aifa.invoice_processor.entity.movement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.AbstractIT;
import it.gov.aifa.invoice_processor.service.persistence.MovementRepository;

public class MovementIT extends AbstractIT{
	
	@Autowired
	private MovementRepository movementRepository;
	
	@DirtiesContext
	@Test(expectedExceptions = { DataIntegrityViolationException.class })
	public void movementUniqueConstraintViolationTest() {
		Movement m = new Movement("aic", "documentNumber", "documentTypeCode", "lot", "2017-06-22", "11:33:34");
		m.setId("1");
		movementRepository.save(m);
		Movement m2 = new Movement("aic", "documentNumber", "documentTypeCode", "lot", "2017-06-22", "11:33:34");
		m2.setId("2");
		movementRepository.save(m2);
	}
}

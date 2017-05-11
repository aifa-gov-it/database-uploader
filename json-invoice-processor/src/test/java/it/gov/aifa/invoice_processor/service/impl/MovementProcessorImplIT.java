package it.gov.aifa.invoice_processor.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.AbstractIT;
import it.gov.aifa.invoice_processor.constant.CommandLineArgumentKey;
import it.gov.aifa.invoice_processor.constant.TestConstant;
import it.gov.aifa.invoice_processor.entity.movement.Movement;
import it.gov.aifa.invoice_processor.service.persistence.MovementRepository;

@TestPropertySource(properties = { CommandLineArgumentKey.IMPORT_MOV_CSV + "=", CommandLineArgumentKey.PATH + "=" + TestConstant.TEST_FILE_PATH_MOVEMENT_DSV })
public class MovementProcessorImplIT extends AbstractIT{
	
	@Autowired
	private MovementRepository movementRepository;
	
	@Test
	public void movementProcessTest() {
		Iterable<Movement> movements = movementRepository.findAll();
		List<Movement> movementList = new ArrayList<>();
		movements.forEach(m -> movementList.add(m));
		assertThat(movementList).hasSize(2);
	}
}

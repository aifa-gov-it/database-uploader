package it.gov.aifa.invoice_processor.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.gov.aifa.invoice_processor.entity.movement.Movement;
import it.gov.aifa.invoice_processor.service.MovementProcessor;

@Service
public class MovementProcessorImpl implements MovementProcessor {
	private static final Logger log = LoggerFactory.getLogger(MovementProcessorImpl.class);
	
	@Override
	public Movement process(final Movement movement) throws Exception {
		log.info("Processing movement: {}", movement);
		StringBuilder expirationDate = new StringBuilder(movement.getTransmissionDate().length() + movement.getTransmissionTime().length() + 1);
		expirationDate.append(movement.getTransmissionDate());
		expirationDate.append("T");
		expirationDate.append(movement.getTransmissionTime());
		movement.setTransmissionDateTime(LocalDateTime.parse(expirationDate));
		movement.setExpirationDate(LocalDate.parse(movement.getRawExpirationDate()));
		return movement;
	}

}

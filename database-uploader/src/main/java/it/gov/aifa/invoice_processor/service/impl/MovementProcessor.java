package it.gov.aifa.invoice_processor.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.gov.aifa.invoice_processor.entity.movement.Movement;

@Service
public class MovementProcessor
extends AbstractInvoiceProcessorEntityProcessor<Movement, String, Movement>{
	private static final Logger log = LoggerFactory.getLogger(MovementProcessor.class);
	
	@Override
	protected Movement processInternal(final Movement movement) {
		log.info("Processed movement: {}", movement.getId());
		return movement;
	}
}

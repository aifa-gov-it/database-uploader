package it.gov.aifa.invoice_processor.service.impl;

import org.springframework.stereotype.Service;

import it.gov.aifa.invoice_processor.entity.movement.Movement;

@Service
public class MovementProcessor
extends AbstractInvoiceProcessorEntityProcessor<Movement, Movement>{
	@Override
	protected Movement processInternal(final Movement movement) {
		return movement;
	}
}

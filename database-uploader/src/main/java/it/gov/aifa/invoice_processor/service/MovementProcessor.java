package it.gov.aifa.invoice_processor.service;

import org.springframework.batch.item.ItemProcessor;

import it.gov.aifa.invoice_processor.entity.movement.Movement;

public interface MovementProcessor extends ItemProcessor<Movement, Movement>{
	Movement process(Movement movement) throws Exception;
}
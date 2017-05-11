package it.gov.aifa.invoice_processor.service.persistence;

import org.springframework.data.repository.CrudRepository;

import it.gov.aifa.invoice_processor.entity.movement.Movement;

public interface MovementRepository extends CrudRepository<Movement, Long> {

}

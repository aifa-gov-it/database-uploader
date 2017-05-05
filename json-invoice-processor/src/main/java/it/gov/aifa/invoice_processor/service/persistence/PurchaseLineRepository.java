package it.gov.aifa.invoice_processor.service.persistence;

import org.springframework.data.repository.CrudRepository;

import it.gov.aifa.invoice_processor.entity.invoice.PurchaseLine;
import it.gov.aifa.invoice_processor.entity.invoice.PurchaseLinePrimaryKey;

public interface PurchaseLineRepository extends CrudRepository<PurchaseLine, PurchaseLinePrimaryKey> {

}

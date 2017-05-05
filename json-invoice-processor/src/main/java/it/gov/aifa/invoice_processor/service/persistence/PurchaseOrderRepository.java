package it.gov.aifa.invoice_processor.service.persistence;

import org.springframework.data.repository.CrudRepository;

import it.gov.aifa.invoice_processor.entity.invoice.DocumentIdDatePrimaryKey;
import it.gov.aifa.invoice_processor.entity.invoice.PurchaseOrder;

public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, DocumentIdDatePrimaryKey> {

}

package it.gov.aifa.invoice_processor.service.persistence;

import org.springframework.data.repository.CrudRepository;

import it.gov.aifa.invoice_processor.entity.invoice.InvoiceItem;

public interface InvoiceItemRepository extends CrudRepository<InvoiceItem, Long> {

}

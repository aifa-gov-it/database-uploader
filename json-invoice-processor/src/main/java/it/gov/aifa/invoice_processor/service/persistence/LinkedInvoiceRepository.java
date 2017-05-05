package it.gov.aifa.invoice_processor.service.persistence;

import org.springframework.data.repository.CrudRepository;

import it.gov.aifa.invoice_processor.entity.invoice.DocumentIdDatePrimaryKey;
import it.gov.aifa.invoice_processor.entity.invoice.LinkedInvoice;

public interface LinkedInvoiceRepository extends CrudRepository<LinkedInvoice, DocumentIdDatePrimaryKey> {

}

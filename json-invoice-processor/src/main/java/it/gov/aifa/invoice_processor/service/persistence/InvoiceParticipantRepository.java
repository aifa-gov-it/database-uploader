package it.gov.aifa.invoice_processor.service.persistence;
import org.springframework.data.repository.CrudRepository;

import it.gov.aifa.invoice_processor.entity.invoice.CountryAndCodePrimaryKey;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceParticipant;

public interface InvoiceParticipantRepository extends CrudRepository<InvoiceParticipant, CountryAndCodePrimaryKey> {
}
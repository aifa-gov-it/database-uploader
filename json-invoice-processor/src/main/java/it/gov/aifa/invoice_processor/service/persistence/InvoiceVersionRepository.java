package it.gov.aifa.invoice_processor.service.persistence;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.gov.aifa.invoice_processor.entity.invoice.InvoiceVersion;

public interface InvoiceVersionRepository extends PagingAndSortingRepository<InvoiceVersion, String> {
}
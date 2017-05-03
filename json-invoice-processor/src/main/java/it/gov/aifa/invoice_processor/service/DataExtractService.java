package it.gov.aifa.invoice_processor.service;

import org.hibernate.validator.constraints.NotBlank;

import it.gov.aifa.invoice_processor.mapping.Invoice;

public interface DataExtractService {
	<T extends Invoice> T buildInvoice(@NotBlank String json, Class<T> invoiceClass);
}

package it.gov.aifa.invoice_processor.service;

import org.springframework.batch.item.ItemProcessor;

import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.mapping.InvoiceMapping;

public interface InvoiceMappingProcessor<IM extends InvoiceMapping<String>, I extends Invoice> extends ItemProcessor<IM, I>{
	I process(IM invoiceMapping) throws Exception;
}
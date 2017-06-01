package it.gov.aifa.invoice_processor.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import it.gov.aifa.invoice_processor.entity.invoice.Invoice;

public interface InvoiceReferenceEntity<I extends Serializable> extends InvoiceProcessorEntity<I>{
	Invoice getInvoice();
	void setInvoice(@NotNull Invoice invoice);
}

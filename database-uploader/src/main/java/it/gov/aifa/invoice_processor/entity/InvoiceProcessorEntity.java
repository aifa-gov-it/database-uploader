package it.gov.aifa.invoice_processor.entity;

import java.io.Serializable;

public interface InvoiceProcessorEntity<I extends Serializable> {
	I getId();
	void setId(I id);
}

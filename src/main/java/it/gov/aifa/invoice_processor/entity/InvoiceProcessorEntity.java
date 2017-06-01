package it.gov.aifa.invoice_processor.entity;

import java.io.Serializable;
import java.util.List;

public interface InvoiceProcessorEntity<I extends Serializable> {
	I getId();
	List<String> getIdValues();
	void setId(I id);
	void updateId();
}

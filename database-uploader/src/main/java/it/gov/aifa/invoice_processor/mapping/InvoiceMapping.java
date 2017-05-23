package it.gov.aifa.invoice_processor.mapping;

import java.io.Serializable;

public interface InvoiceMapping <ID extends Serializable>{
	ID getId();
}

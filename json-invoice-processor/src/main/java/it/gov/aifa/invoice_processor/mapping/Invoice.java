package it.gov.aifa.invoice_processor.mapping;

import java.io.Serializable;

public interface Invoice <ID extends Serializable>{
	ID getId();
}

package it.gov.aifa.invoice_processor.service;

import org.springframework.core.convert.converter.Converter;

import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.mapping.InvoiceMapping;

public interface InvoiceMappingToEntityConverter<S extends InvoiceMapping<String>,T extends Invoice> extends Converter<S,T>{
	boolean canConvert(Class<?> clazz);
	String getInvoiceMappingVersion();
}

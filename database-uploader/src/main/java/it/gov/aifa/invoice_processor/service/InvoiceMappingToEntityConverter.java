package it.gov.aifa.invoice_processor.service;

import org.springframework.core.convert.converter.Converter;

import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.mapping.InvoiceMapping;

public interface InvoiceMappingToEntityConverter extends Converter<InvoiceMapping<String>, Invoice>{
	boolean canConvert(Class<?> clazz);
}

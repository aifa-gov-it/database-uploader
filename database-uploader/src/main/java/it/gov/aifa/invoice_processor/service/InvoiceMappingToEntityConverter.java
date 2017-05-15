package it.gov.aifa.invoice_processor.service;

import org.springframework.core.convert.converter.Converter;

public interface InvoiceMappingToEntityConverter
<
S extends it.gov.aifa.invoice_processor.mapping.Invoice<String>
,T extends it.gov.aifa.invoice_processor.entity.invoice.Invoice
> extends Converter<S,T>{

}

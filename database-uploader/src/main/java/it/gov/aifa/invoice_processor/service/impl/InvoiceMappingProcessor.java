package it.gov.aifa.invoice_processor.service.impl;

import java.util.Set;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.mapping.InvoiceMapping;
import it.gov.aifa.invoice_processor.service.InvoiceMappingToEntityConverter;

@Service
@Validated
public class InvoiceMappingProcessor
extends AbstractInvoiceProcessorEntityProcessor<String, InvoiceMapping<String>, String, Invoice> {
	Set<InvoiceMappingToEntityConverter<InvoiceMapping<String>, Invoice>> converters;

	public  InvoiceMappingProcessor(
			@NotEmpty Set<InvoiceMappingToEntityConverter<InvoiceMapping<String>, Invoice>> converters) {
		this.converters = converters;
	}

	@Override
	protected Invoice processInternal(final InvoiceMapping<String> item) {
		Invoice invoice = null;
		for(InvoiceMappingToEntityConverter<InvoiceMapping<String>, Invoice> converter : converters)
			if(converter.canConvert(item.getClass())) {
				invoice = converter.convert(item);
				break;
			}
		if(invoice == null)
			throw new RuntimeException("Cannot find a suitable converter for " + item.getClass().toGenericString());
		return invoice;
	}

}

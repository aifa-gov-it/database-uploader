package it.gov.aifa.invoice_processor.service.impl;

import java.util.Set;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.mapping.InvoiceMapping;
import it.gov.aifa.invoice_processor.service.InvoiceMappingProcessor;
import it.gov.aifa.invoice_processor.service.InvoiceMappingToEntityConverter;

@Service
@Validated
public class InvoiceMappingProcessorImpl implements InvoiceMappingProcessor<InvoiceMapping<String>, Invoice> {
	Set<InvoiceMappingToEntityConverter<InvoiceMapping<String>, Invoice>> converters;

	public  InvoiceMappingProcessorImpl(
			@NotEmpty Set<InvoiceMappingToEntityConverter<InvoiceMapping<String>, Invoice>> converters) {
		this.converters = converters;
	}

	@Override
	public Invoice process(InvoiceMapping<String> invoiceMapping) throws Exception {
		Invoice invoice = null;
		for(InvoiceMappingToEntityConverter<InvoiceMapping<String>, Invoice> converter : converters)
			if(converter.canConvert(invoiceMapping.getClass())) {
				invoice = converter.convert(invoiceMapping);
				break;
			}
		if(invoice == null) {
			throw new RuntimeException("Cannot find a suitable converter for " + invoiceMapping.getClass().toGenericString());
		}
		return invoice;
	}

}

package it.gov.aifa.invoice_processor.service.impl;

import java.util.Set;

import javax.xml.bind.JAXBElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.mapping.InvoiceMapping;
import it.gov.aifa.invoice_processor.service.InvoiceMappingToEntityConverter;

@Service
@Validated
public class InvoiceMappingProcessor extends AbstractInvoiceProcessorEntityProcessor<JAXBElement<InvoiceMapping<String>>, Invoice> {
	
	Set<InvoiceMappingToEntityConverter> converters;

	public InvoiceMappingProcessor(
			@NotEmpty Set<InvoiceMappingToEntityConverter> converters) {
		this.converters = converters;
	}

	@Override
	protected Invoice processInternal(final JAXBElement<InvoiceMapping<String>> item) {
		Invoice invoice = null;
		for(InvoiceMappingToEntityConverter converter : converters) {
			Class<?> objectClass;
			if(JAXBElement.class.isAssignableFrom(item.getClass())) {
				JAXBElement<?> jaxbElement = (JAXBElement<?>) item;
				objectClass = jaxbElement.getValue().getClass();
			}else
				objectClass = item.getClass();
			
			if(converter.canConvert(objectClass)) {
				invoice = converter.convert(item.getValue());
				break;
			}
		}
		if(invoice == null)
			throw new RuntimeException("Cannot find a suitable converter for " + item.getClass().toGenericString());
		return invoice;
	}

}

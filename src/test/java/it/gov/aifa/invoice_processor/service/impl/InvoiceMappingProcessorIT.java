package it.gov.aifa.invoice_processor.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import javax.xml.bind.JAXBElement;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.AbstractComponentIT;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.FatturaElettronicaType;
import it.gov.aifa.invoice_processor.service.InvoiceMappingToEntityConverter;

public class InvoiceMappingProcessorIT extends AbstractComponentIT {
	
	@Autowired
	private ItemProcessor<JAXBElement<FatturaElettronicaType>, Invoice> invoiceMappingProcessor;
	
	@Autowired
	private Set<InvoiceMappingToEntityConverter> converters;
	
	@Override
	public Object getComponent() {
		return invoiceMappingProcessor;
	}
	
	@Test
	public void convertersTest() {
		assertThat(converters).isNotEmpty();
	}
	
}

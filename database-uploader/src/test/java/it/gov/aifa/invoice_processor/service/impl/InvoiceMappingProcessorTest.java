package it.gov.aifa.invoice_processor.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.mapping.InvoiceMapping;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.FatturaElettronicaType;
import it.gov.aifa.invoice_processor.service.InvoiceMappingToEntityConverter;

public class InvoiceMappingProcessorTest {
	
	@Test
	public void processInvoice1_2() throws Exception {
		InvoiceMapping<String> invoiceMapping = new FatturaElettronicaType();
		Set<InvoiceMappingToEntityConverter<InvoiceMapping<String>, Invoice>> converters = new HashSet<>();
		@SuppressWarnings("unchecked")
		InvoiceMappingToEntityConverter<InvoiceMapping<String>, Invoice> converter = mock(InvoiceMappingToEntityConverter.class);
		Class<?> destinationType = FatturaElettronicaType.class;
		when(converter.canConvert(destinationType)).thenReturn(true);
		Invoice invoice = new Invoice("123456");
		when(converter.convert(invoiceMapping)).thenReturn(invoice);
		converters.add(converter);
		new InvoiceMappingProcessor(converters).process(invoiceMapping);
		for(String idValue : invoice.getIdValues()) {
			assertThat(invoice.getId()).contains(idValue);
		}
		verify(converter, times(1)).canConvert(destinationType);
		verify(converter, times(1)).convert(invoiceMapping);
	}
	
	@Test(expectedExceptions = RuntimeException.class)
	public void processNoSuitableConverter() throws Exception {
		Set<InvoiceMappingToEntityConverter<InvoiceMapping<String>, Invoice>> converters = new HashSet<>();
		@SuppressWarnings("unchecked")
		InvoiceMappingToEntityConverter<InvoiceMapping<String>, Invoice> converter = mock(InvoiceMappingToEntityConverter.class);
		Class<?> destinationType = FatturaElettronicaType.class;
		when(converter.canConvert(destinationType)).thenReturn(false);
		converters.add(converter);
		new InvoiceMappingProcessor(converters).process(null);
		verify(converter, times(1)).canConvert(destinationType);
		verify(converter, never()).convert(any());
	}
}

package it.gov.aifa.invoice_processor.service.impl;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.mapping.InvoiceMapping;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.FatturaElettronicaType;
import it.gov.aifa.invoice_processor.service.InvoiceMappingToEntityConverter;

public class InvoiceMappingProcessorTest {
	
	@SuppressWarnings("unchecked")
	@Test
	public void processInvoice1_2Test() throws Exception {
		InvoiceMapping<String> invoiceMapping = new FatturaElettronicaType();
		Set<InvoiceMappingToEntityConverter> converters = new HashSet<>();
		InvoiceMappingToEntityConverter converter = mock(InvoiceMappingToEntityConverter.class);
		Class<?> destinationType = FatturaElettronicaType.class;
		when(converter.canConvert(destinationType)).thenReturn(true);
		Invoice invoice = new Invoice("123456");
		when(converter.convert(invoiceMapping)).thenReturn(invoice);
		converters.add(converter);
		new InvoiceMappingProcessor(converters).process(
				new JAXBElement<InvoiceMapping<String>>(
						new QName("http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v1.2", "FatturaElettronica")
						, (Class<InvoiceMapping<String>>) invoiceMapping.getClass()
						, invoiceMapping)
				);
		verify(converter, times(1)).canConvert(destinationType);
		verify(converter, times(1)).convert(invoiceMapping);
	}
	
	@Test(expectedExceptions = RuntimeException.class)
	public void processNoSuitableConverter() throws Exception {
		Set<InvoiceMappingToEntityConverter> converters = new HashSet<>();
		InvoiceMappingToEntityConverter converter = mock(InvoiceMappingToEntityConverter.class);
		Class<?> destinationType = FatturaElettronicaType.class;
		when(converter.canConvert(destinationType)).thenReturn(false);
		converters.add(converter);
		new InvoiceMappingProcessor(converters).process(null);
		verify(converter, times(1)).canConvert(destinationType);
		verify(converter, never()).convert(any());
	}
}

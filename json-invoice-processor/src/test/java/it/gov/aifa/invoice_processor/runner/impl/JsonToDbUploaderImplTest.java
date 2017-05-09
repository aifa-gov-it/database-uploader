package it.gov.aifa.invoice_processor.runner.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Properties;

import org.mockito.ArgumentCaptor;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.constant.CommandLineArgumentKey;
import it.gov.aifa.invoice_processor.constant.TestConstant;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.Invoice1_1;
import it.gov.aifa.invoice_processor.runner.JsonToDbUploader;
import it.gov.aifa.invoice_processor.service.InvoiceMappingToEntityConverter;
import it.gov.aifa.invoice_processor.service.MappingObjectFactory;
import it.gov.aifa.invoice_processor.service.persistence.InvoiceRepository;

public class JsonToDbUploaderImplTest {
	
	@Test
	public void runTest(){
		genericRunTest(false, 1);
	}
	
	@Test
	public void runSkipTest(){
		genericRunTest(true, 0);
	}
	
	private void genericRunTest(boolean exists, int saveInvocations){
		InvoiceRepository repository = mock(InvoiceRepository.class);
		String entityId = TestConstant.BOOTSTRAP_INVOICE_ID;
		when(repository.exists(entityId)).thenReturn(exists);
		@SuppressWarnings("unchecked")
		MappingObjectFactory<Invoice1_1> invoiceMappingFactory = mock(MappingObjectFactory.class);
		Invoice1_1 invoiceMapping = mock(Invoice1_1.class);
		when(invoiceMapping.getId()).thenReturn(TestConstant.BOOTSTRAP_INVOICE_ID);
		when(invoiceMappingFactory.buildFromJson(TestConstant.INVOICE1_1_JSON, Invoice1_1.class)).thenReturn(invoiceMapping);
		@SuppressWarnings("unchecked")
		InvoiceMappingToEntityConverter<Invoice1_1, Invoice> invoiceMappingToEntityConverter = mock(InvoiceMappingToEntityConverter.class);
		Invoice invoiceEntity = mock(Invoice.class);
		when(invoiceMappingToEntityConverter.convert(invoiceMapping)).thenReturn(invoiceEntity);
		JsonToDbUploader jsonToDbUploader = new JsonToDbUploaderImpl(invoiceMappingToEntityConverter, repository, invoiceMappingFactory);
		Properties properties = new Properties();
		properties.setProperty(CommandLineArgumentKey.PATH, TestConstant.TEST_DIRECTORY_PATH.toString());
		jsonToDbUploader.setArguments(properties);
		jsonToDbUploader.run();
		verify(invoiceMappingFactory, times(1)).buildFromJson(TestConstant.INVOICE1_1_JSON, Invoice1_1.class);
		verify(invoiceMapping, times(1)).getId();
		verify(repository, times(1)).exists(entityId);
		ArgumentCaptor<Invoice> captor = ArgumentCaptor.forClass(Invoice.class);
		verify(repository, times(saveInvocations)).save(captor.capture());
	}
}
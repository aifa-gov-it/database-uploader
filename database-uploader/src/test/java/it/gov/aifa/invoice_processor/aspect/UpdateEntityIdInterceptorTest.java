package it.gov.aifa.invoice_processor.aspect;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.entity.InvoiceProcessorEntity;
import it.gov.aifa.invoice_processor.entity.InvoiceReferenceEntity;
import it.gov.aifa.invoice_processor.entity.invoice.Attachment;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;

public class UpdateEntityIdInterceptorTest {
	
	@Test
	public void updateEntityIdPointcutTest() {
		InvoiceReferenceEntity<String> target = new Attachment();
		AspectJProxyFactory factory = new AspectJProxyFactory((InvoiceReferenceEntity<String>) target);
		UpdateEntityIdInterceptor aspect = spy(new UpdateEntityIdInterceptor());
		factory.addAspect(aspect);
		InvoiceReferenceEntity<String> proxy = factory.getProxy();
		proxy.setInvoice(new Invoice("123456"));
		verify(aspect, times(1)).updateEntityId(target);
	}
	
	@Test
	public void updateEntityIdPointcutNoInteractionsTest() {
		Attachment target = new Attachment(new Invoice("123456"));
		AspectJProxyFactory factory = new AspectJProxyFactory((InvoiceProcessorEntity<String>) target);
		UpdateEntityIdInterceptor aspect = spy(new UpdateEntityIdInterceptor());
		factory.addAspect(aspect);
		InvoiceProcessorEntity<String> proxy = factory.getProxy();
		proxy.setId("1");
		verify(aspect, never()).updateEntityId(target);
	}
	
	@Test
	public void updateEntityIdTest() {
		UpdateEntityIdInterceptor updateEntityIdInterceptor = new UpdateEntityIdInterceptor();
		Attachment attachment = new Attachment(new Invoice("123456"));
		attachment.setName("name");
		updateEntityIdInterceptor.updateEntityId(attachment);
		for(String idValue : attachment.getIdValues()) {
			assertThat(attachment.getId()).contains(idValue);
		}
	}
}

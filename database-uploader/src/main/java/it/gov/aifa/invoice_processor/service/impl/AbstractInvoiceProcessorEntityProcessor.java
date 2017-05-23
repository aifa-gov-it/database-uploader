package it.gov.aifa.invoice_processor.service.impl;

import java.io.Serializable;

import org.springframework.batch.item.ItemProcessor;

import it.gov.aifa.invoice_processor.entity.InvoiceProcessorEntity;

public abstract class AbstractInvoiceProcessorEntityProcessor<
IID extends Serializable
,I
, OID extends Serializable
, O extends InvoiceProcessorEntity<OID>
> implements ItemProcessor<I, O> {

	@Override
	public final O process(final I item) throws Exception {
		O output = processInternal(item);
		output.updateId();
		return output;
	}
	
	protected abstract O processInternal(final I item);

}

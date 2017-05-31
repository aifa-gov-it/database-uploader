package it.gov.aifa.invoice_processor.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import it.gov.aifa.invoice_processor.entity.InvoiceProcessorEntity;

public abstract class AbstractInvoiceProcessorEntityProcessor<
I
, O extends InvoiceProcessorEntity<Long>
> implements ItemProcessor<I, O> {
	private static final Logger log = LoggerFactory.getLogger(AbstractInvoiceProcessorEntityProcessor.class);

	@Override
	public final O process(final I item) throws Exception {
		O output = processInternal(item);
		log.info("Processed entity {}: {}", output.getClass().toGenericString(), output.getId());
		return output;
	}
	
	protected abstract O processInternal(final I item);

}

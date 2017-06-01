package it.gov.aifa.invoice_processor.entity.listener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.gov.aifa.invoice_processor.entity.InvoiceProcessorEntity;

public class InvoiceProcessorEntityListener {
	private static final Logger log = LoggerFactory.getLogger(InvoiceProcessorEntityListener.class);
	
	@PrePersist
	@PreUpdate
	public void methodExecuteBeforeSave(final InvoiceProcessorEntity<String> invoiceProcessorEntity) {
		if(StringUtils.isBlank(invoiceProcessorEntity.getId())) {
			log.debug("Updating id for entity {}@{}: {}", invoiceProcessorEntity.getClass().getName(), System.identityHashCode(invoiceProcessorEntity), invoiceProcessorEntity.getId());
			invoiceProcessorEntity.updateId();
			log.debug("Updated id for entity {}@{}: {}", invoiceProcessorEntity.getClass().getName(), System.identityHashCode(invoiceProcessorEntity), invoiceProcessorEntity.getId());

		}else
			log.debug("Entity id not updated because it was already initialized for entity {}@{}: {}", invoiceProcessorEntity.getClass().getName(), System.identityHashCode(invoiceProcessorEntity), invoiceProcessorEntity.getId());
	}
}

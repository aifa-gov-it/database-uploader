package it.gov.aifa.invoice_processor.entity.impl;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.InvoiceReferenceEntity;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;

@MappedSuperclass
@Validated
public abstract class AbstractInvoiceReferenceEntity extends AbstractInvoiceProcessorEntity implements InvoiceReferenceEntity<Long>{

	private static final long serialVersionUID = 1904771980819257127L;
	
	@NotNull
	private Invoice invoice;

	public AbstractInvoiceReferenceEntity() {
		super();
	}

	public AbstractInvoiceReferenceEntity(Invoice invoice) {
		this();
		this.invoice = invoice;
	}

	@JoinColumn(name = "invoiceId", referencedColumnName = "id")
	@ManyToOne
	@Override
	public Invoice getInvoice() {
		return invoice;
	}

	@Override
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}

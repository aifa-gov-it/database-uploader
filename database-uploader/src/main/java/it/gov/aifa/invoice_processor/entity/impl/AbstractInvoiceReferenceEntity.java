package it.gov.aifa.invoice_processor.entity.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.InvoiceReferenceEntity;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;

@MappedSuperclass
@Validated
public abstract class AbstractInvoiceReferenceEntity extends AbstractInvoiceProcessorEntity implements InvoiceReferenceEntity<String>{

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
	
	@Override
	@Transient
	public List<String> getIdValues(){
		List<String> idValues = new ArrayList<>();
		idValues.add(invoice.getNumber());
		idValues.addAll(getAdditionalIdValues());
		return Collections.unmodifiableList(idValues);
	}
	
	@Transient
	protected abstract List<String> getAdditionalIdValues();

	@JoinColumn(name = "invoiceId", referencedColumnName = "number")
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

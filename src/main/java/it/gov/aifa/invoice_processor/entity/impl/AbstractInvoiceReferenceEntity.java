package it.gov.aifa.invoice_processor.entity.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.InvoiceReferenceEntity;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;

@MappedSuperclass
@Validated
public abstract class AbstractInvoiceReferenceEntity extends AbstractInvoiceProcessorEntity implements InvoiceReferenceEntity<String>{

	private static final long serialVersionUID = 1904771980819257127L;
	
	private Invoice invoice;

	public AbstractInvoiceReferenceEntity() {
		super();
	}

	public AbstractInvoiceReferenceEntity(@NotNull Invoice invoice) {
		super();
		this.invoice = invoice;
	}
	
	@Override
	@Transient
	public List<String> getIdValues(){
		if(CollectionUtils.isEmpty(getAdditionalIdValues()))
			throw new RuntimeException("Additional Id field list cannot be empty");
		List<String> idValues = new ArrayList<>();
		if(invoice == null)
			throw new RuntimeException("Invoice reference cannot be null");
		idValues.add(invoice.getInvoiceNumber());
		idValues.addAll(getAdditionalIdValues());
		return Collections.unmodifiableList(idValues);
	}
	
	@Transient
	protected abstract List<String> getAdditionalIdValues();

	@JoinColumn(name = "invoiceId", referencedColumnName = "id")
	@ManyToOne
	@Override
	public Invoice getInvoice() {
		return invoice;
	}

	@Override
	public void setInvoice(@NotNull Invoice invoice) {
		this.invoice = invoice;
	}
}

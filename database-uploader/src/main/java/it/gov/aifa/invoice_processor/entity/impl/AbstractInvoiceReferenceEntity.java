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
	@JoinColumn(name = "invoiceId", referencedColumnName = "number")
	@ManyToOne
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

	/* (non-Javadoc)
	 * @see it.gov.aifa.invoice_processor.entity.impl.InvoiceReferenceEntity#getInvoice()
	 */
	@Override
	public Invoice getInvoice() {
		return invoice;
	}

	/* (non-Javadoc)
	 * @see it.gov.aifa.invoice_processor.entity.impl.InvoiceReferenceEntity#setInvoice(it.gov.aifa.invoice_processor.entity.invoice.Invoice)
	 */
	@Override
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}

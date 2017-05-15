package it.gov.aifa.invoice_processor.entity.invoice;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.MapsId;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.validation.annotation.Validated;

@MappedSuperclass
@Validated
public abstract class AbstractInvoiceReferenceDocument {
	
	@JoinColumn(name = "invoiceId", referencedColumnName = "number")
    @ManyToOne
    @MapsId("invoiceId")
	@NotNull
	private Invoice invoice;

	public AbstractInvoiceReferenceDocument() {}
	
	public AbstractInvoiceReferenceDocument(Invoice invoice) {
		this();
		this.invoice = invoice;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof AbstractInvoiceReferenceDocument) == false) {
			return false;
		}
		AbstractInvoiceReferenceDocument rhs = ((AbstractInvoiceReferenceDocument) other);
		return new EqualsBuilder()
				.append(invoice, rhs.invoice)
				.isEquals();
	}
	
	public Invoice getInvoice() {
		return invoice;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(invoice)
				.toHashCode();
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

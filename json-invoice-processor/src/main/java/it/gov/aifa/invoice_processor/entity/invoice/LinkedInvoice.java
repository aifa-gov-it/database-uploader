package it.gov.aifa.invoice_processor.entity.invoice;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class LinkedInvoice {
	@EmbeddedId
	private DocumentIdDatePrimaryKey id;
	
	@JoinColumn(name = "invoiceId", referencedColumnName = "number")
    @ManyToOne
    @MapsId("invoiceId")
	private Invoice invoice;
	
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof LinkedInvoice) == false) {
			return false;
		}
		LinkedInvoice rhs = ((LinkedInvoice) other);
		return new EqualsBuilder()
				.append(id, rhs.id)
				.append(invoice, rhs.invoice)
				.isEquals();
	}

	public DocumentIdDatePrimaryKey getId() {
		return id;
	}
	public Invoice getInvoice() {
		return invoice;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.toHashCode();
	}

	public void setId(DocumentIdDatePrimaryKey id) {
		this.id = id;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

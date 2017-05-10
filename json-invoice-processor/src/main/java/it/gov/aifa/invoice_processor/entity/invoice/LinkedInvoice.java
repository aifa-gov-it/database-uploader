package it.gov.aifa.invoice_processor.entity.invoice;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class LinkedInvoice extends AbstractInvoiceReferenceDocument{
	@EmbeddedId
	@NotNull
	private LinkedInvoicePrimaryKey id;
	
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
				.isEquals();
	}

	public LinkedInvoicePrimaryKey getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.toHashCode();
	}

	public void setId(LinkedInvoicePrimaryKey id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

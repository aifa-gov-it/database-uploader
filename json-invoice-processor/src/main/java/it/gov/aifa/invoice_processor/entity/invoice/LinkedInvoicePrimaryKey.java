package it.gov.aifa.invoice_processor.entity.invoice;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Embeddable
@Validated
public class LinkedInvoicePrimaryKey implements Serializable{
	private static final long serialVersionUID = 7120951809313839861L;
	
	@NotNull
	private LocalDate date;

	@NotBlank
	private String id;
	
	@NotBlank
	private String invoiceId;
	
	public LinkedInvoicePrimaryKey() {
		super();
	}
	
	public LinkedInvoicePrimaryKey(LocalDate date, String id, String invoiceId) {
		this.date = date;
		this.id = id;
		this.invoiceId = invoiceId;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof LinkedInvoicePrimaryKey) == false) {
			return false;
		}
		LinkedInvoicePrimaryKey rhs = ((LinkedInvoicePrimaryKey) other);
		return new EqualsBuilder()
				.append(date, rhs.date)
				.append(id, rhs.id)
				.append(invoiceId, rhs.invoiceId)
				.isEquals();
	}

	public LocalDate getDate() {
		return date;
	}

	public String getId() {
		return id;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(date)
				.append(id)
				.append(invoiceId)
				.toHashCode();
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setInvoice(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

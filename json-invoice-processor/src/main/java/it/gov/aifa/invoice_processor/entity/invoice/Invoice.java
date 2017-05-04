package it.gov.aifa.invoice_processor.entity.invoice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class Invoice {
	
	@ManyToOne
    @JoinColumn(name = "version")
	@NotNull
	private InvoiceVersion invoiceVersion;

	@Id
	@NotBlank
	private String number;

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Invoice) == false) {
			return false;
		}
		Invoice rhs = ((Invoice) other);
		return new EqualsBuilder()
				.append(invoiceVersion, rhs.invoiceVersion)
				.append(number, rhs.number)
				.isEquals();
	}

	public InvoiceVersion getInvoiceVersion() {
		return invoiceVersion;
	}

	public String getNumber() {
		return number;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(invoiceVersion)
				.append(number)
				.toHashCode();
	}
	
	public void setInvoiceVersion(InvoiceVersion invoiceVersion) {
		this.invoiceVersion = invoiceVersion;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

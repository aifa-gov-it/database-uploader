package it.gov.aifa.invoice_processor.entity.invoice;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Embeddable
@Validated
public class PurchaseLinePrimaryKey implements Serializable{
	private static final long serialVersionUID = 4169358380087358121L;

	@NotNull
	private String invoiceId;
	
	@NotBlank
	private String number;
	
	
	public PurchaseLinePrimaryKey() {
	}

	public PurchaseLinePrimaryKey(String invoiceId, String number) {
		this();
		this.invoiceId = invoiceId;
		this.number = number;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof PurchaseLinePrimaryKey) == false) {
			return false;
		}
		PurchaseLinePrimaryKey rhs = ((PurchaseLinePrimaryKey) other);
		return new EqualsBuilder()
				.append(invoiceId, rhs.invoiceId)
				.append(number, rhs.number)
				.isEquals();
	}

	public String getInvoiceId() {
		return invoiceId;
	}
	
	public String getNumber() {
		return number;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(invoiceId)
				.append(number)
				.toHashCode();
	}

	public void setInvoice(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

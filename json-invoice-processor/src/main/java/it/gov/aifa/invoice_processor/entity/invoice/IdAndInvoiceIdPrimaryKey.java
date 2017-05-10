package it.gov.aifa.invoice_processor.entity.invoice;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Embeddable
@Validated
public class IdAndInvoiceIdPrimaryKey implements Serializable{
	private static final long serialVersionUID = 4169358380087358121L;

	@NotBlank
	private String invoiceId;
	
	@NotBlank
	private String id;
	
	
	public IdAndInvoiceIdPrimaryKey() {
	}

	public IdAndInvoiceIdPrimaryKey(String invoiceId, String id) {
		this();
		this.invoiceId = invoiceId;
		this.id = id;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof IdAndInvoiceIdPrimaryKey) == false) {
			return false;
		}
		IdAndInvoiceIdPrimaryKey rhs = ((IdAndInvoiceIdPrimaryKey) other);
		return new EqualsBuilder()
				.append(invoiceId, rhs.invoiceId)
				.append(id, rhs.id)
				.isEquals();
	}

	public String getInvoiceId() {
		return invoiceId;
	}
	
	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(invoiceId)
				.append(id)
				.toHashCode();
	}

	public void setInvoice(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

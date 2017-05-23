package it.gov.aifa.invoice_processor.entity.impl;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.InvoiceProcessorEntity;

@MappedSuperclass
@Validated
public abstract class AbstractInvoiceProcessorEntity implements InvoiceProcessorEntity<String> {

	@Id
	@NotBlank
	private String id;
	
	public AbstractInvoiceProcessorEntity() { }

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		
		if(other == null) {
			return false;
		}

		if (!this.getClass().isAssignableFrom(other.getClass())) {
			return false;
		}
		return EqualsBuilder.reflectionEquals(this, other, false);
	}
	
	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

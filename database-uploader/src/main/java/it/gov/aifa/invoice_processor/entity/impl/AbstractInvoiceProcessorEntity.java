package it.gov.aifa.invoice_processor.entity.impl;

import java.io.Serializable;

import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.InvoiceProcessorEntity;
import it.gov.aifa.invoice_processor.entity.listener.InvoiceProcessorEntityListener;

@EntityListeners(InvoiceProcessorEntityListener.class)
@MappedSuperclass
@Validated
public abstract class AbstractInvoiceProcessorEntity implements InvoiceProcessorEntity<String>, Serializable {

	private static final long serialVersionUID = 6746697384667711588L;
	
	@NotBlank
	private String id;
	
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
	
	@Id
	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		if(StringUtils.isBlank(id))
			updateId();
		return id.hashCode();
	}
	
	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public void updateId() {
		if(CollectionUtils.isEmpty(this.getIdValues()))
			throw new RuntimeException("Id field cannot be empty");
		StringBuilder builder = new StringBuilder();
		for(String idValue : this.getIdValues())
			if(StringUtils.isNotBlank(idValue)) {
				builder.append(idValue);
				builder.append("_");
			}
		
		// Remove the last _
		builder.setLength(builder.length() - 1);
		this.setId(builder.toString());
	}
}

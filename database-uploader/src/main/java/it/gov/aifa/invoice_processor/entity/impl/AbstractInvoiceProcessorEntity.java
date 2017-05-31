package it.gov.aifa.invoice_processor.entity.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.constant.IdGeneratorName;
import it.gov.aifa.invoice_processor.entity.InvoiceProcessorEntity;

@MappedSuperclass
@Validated
public abstract class AbstractInvoiceProcessorEntity implements InvoiceProcessorEntity<Long>, Serializable {

	private static final long serialVersionUID = 6746697384667711588L;
	
	private Long id;
	
	@NotNull
	private Timestamp importDate = Timestamp.valueOf(LocalDateTime.now());
	
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
	@GeneratedValue
	@SequenceGenerator(name = IdGeneratorName.SEQ_SPENDING_PHA, sequenceName = IdGeneratorName.SEQ_SPENDING_PHA)
	@Override
	public Long getId() {
		return id;
	}

	public Timestamp getImportDate() {
		return importDate;
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setImportDate(Timestamp importDate) {
		this.importDate = importDate;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

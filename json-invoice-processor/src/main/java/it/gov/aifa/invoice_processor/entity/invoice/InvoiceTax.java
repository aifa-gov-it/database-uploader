package it.gov.aifa.invoice_processor.entity.invoice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class InvoiceTax {
	@Id
	@GeneratedValue
	@NotNull
	private Long id;

	private String lawReference;

	private double rate;

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof InvoiceTax) == false) {
			return false;
		}
		InvoiceTax rhs = ((InvoiceTax) other);
		return new EqualsBuilder()
				.append(id, rhs.id)
				.append(rate, rhs.rate)
				.append(lawReference, rhs.lawReference)
				.isEquals();
	}

	public Long getId() {
		return id;
	}

	public String getLawReference() {
		return lawReference;
	}

	public double getRate() {
		return rate;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(rate)
				.append(lawReference)
				.toHashCode();
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setLawReference(String lawReference) {
		this.lawReference = lawReference;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

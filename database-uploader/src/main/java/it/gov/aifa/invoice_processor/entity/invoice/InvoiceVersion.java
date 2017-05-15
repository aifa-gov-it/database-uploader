package it.gov.aifa.invoice_processor.entity.invoice;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class InvoiceVersion {
	
	@Id
	@NotBlank
	private String version;
	
	private LocalDateTime validityEndDate;
	
	private LocalDateTime validityStartDate;
	
	public InvoiceVersion() { }
	
	public InvoiceVersion(String version, LocalDateTime validityEndDate,
			LocalDateTime validityStartDate) {
		this();
		this.version = version;
		this.validityEndDate = validityEndDate;
		this.validityStartDate = validityStartDate;
	}

	public String getVersion() {
		return version;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof InvoiceVersion) == false) {
			return false;
		}
		InvoiceVersion rhs = ((InvoiceVersion) other);
		return new EqualsBuilder()
				.append(version, rhs.version)
				.append(validityEndDate, rhs.validityEndDate)
				.append(validityStartDate, rhs.validityStartDate)
				.isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(version)
				.append(validityEndDate)
				.append(validityStartDate)
				.toHashCode();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

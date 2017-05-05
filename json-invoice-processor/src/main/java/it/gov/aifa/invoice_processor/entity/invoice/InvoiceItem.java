package it.gov.aifa.invoice_processor.entity.invoice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class InvoiceItem {
	@NotBlank
	private String code;
	
	@NotBlank
	private String codeType;
	
	@NotBlank
	private String description;
	
	@Id
	@GeneratedValue
	private Long id;

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof InvoiceItem) == false) {
			return false;
		}
		InvoiceItem rhs = ((InvoiceItem) other);
		return new EqualsBuilder()
				.append(id, rhs.id)
				.append(code, rhs.code)
				.append(codeType, rhs.codeType)
				.append(description, rhs.description)
				.isEquals();
	}

	public String getCode() {
		return code;
	}

	public String getCodeType() {
		return codeType;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(code)
				.append(codeType)
				.append(description)
				.toHashCode();
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

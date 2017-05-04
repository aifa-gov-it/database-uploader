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
public class CountryAndCodePrimaryKey implements Serializable {
	private static final long serialVersionUID = 7123032557279837002L;

	@NotBlank
	private String code;

	@NotBlank
	private String countryCode;

	public CountryAndCodePrimaryKey() {
	}

	public CountryAndCodePrimaryKey(String code, String countryCode) {
		this();
		this.code = code;
		this.countryCode = countryCode;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof CountryAndCodePrimaryKey) == false) {
			return false;
		}
		CountryAndCodePrimaryKey rhs = ((CountryAndCodePrimaryKey) other);
		return new EqualsBuilder()
				.append(code, rhs.code)
				.append(countryCode, rhs.countryCode)
				.isEquals();
	}

	public String getCode() {
		return code;
	}

	public String getCountryCode() {
		return countryCode;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(code)
				.append(countryCode)
				.toHashCode();
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

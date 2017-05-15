package it.gov.aifa.invoice_processor.entity.invoice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Validated
public class InvoiceParticipant {
	@NotBlank
	private String city;
	
	@NotBlank
	private String country;
	
	@NotBlank
	private String district;
	
	private String emailAddress;
	
	@NotBlank
	private String name;
	
	private String phoneNumber;
	
	@Id
	@NotBlank
	private String socialSecurityNumber;
	
	@NotBlank
	private String streetAddress;
	
	private String taxCode;

	private String taxCountryCode;
	
	@NotBlank
	private String zipCode;
	
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof InvoiceParticipant) == false) {
			return false;
		}
		InvoiceParticipant rhs = ((InvoiceParticipant) other);
		return new EqualsBuilder()
				.append(city, rhs.city)
				.append(country, rhs.country)
				.append(district, rhs.district)
				.append(emailAddress, rhs.emailAddress)
				.append(name, rhs.name)
				.append(phoneNumber, rhs.phoneNumber)
				.append(socialSecurityNumber, rhs.socialSecurityNumber)
				.append(streetAddress, rhs.streetAddress)
				.append(taxCode, rhs.taxCode)
				.append(taxCountryCode, rhs.taxCountryCode)
				.append(zipCode, rhs.zipCode)
				.isEquals();
	}
	
	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getDistrict() {
		return district;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public String getTaxCountryCode() {
		return taxCountryCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(city)
				.append(country)
				.append(district)
				.append(emailAddress)
				.append(name)
				.append(phoneNumber)
				.append(socialSecurityNumber)
				.append(streetAddress)
				.append(taxCode)
				.append(taxCountryCode)
				.append(zipCode)
				.toHashCode();
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public void setTaxCountryCode(String taxCountryCode) {
		this.taxCountryCode = taxCountryCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

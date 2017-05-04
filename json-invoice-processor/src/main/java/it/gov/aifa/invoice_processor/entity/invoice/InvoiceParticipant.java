package it.gov.aifa.invoice_processor.entity.invoice;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class InvoiceParticipant {
	@NotBlank
	private String city;
	
	@NotBlank
	private String country;
	
	@NotBlank
	private String district;
	
	@NotBlank
	private String emailAddress;
	
	@EmbeddedId
	@Id
	@NotNull
	private CountryAndCodePrimaryKey id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String phoneNumber;
	
	@NotBlank
	private String socialSecurityNumber;
	
	@NotBlank
	private String streetAddress;
	
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
				.append(id, rhs.id)
				.append(name, rhs.name)
				.append(phoneNumber, rhs.phoneNumber)
				.append(socialSecurityNumber, rhs.socialSecurityNumber)
				.append(streetAddress, rhs.streetAddress)
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

	public CountryAndCodePrimaryKey getId() {
		return id;
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
				.append(id)
				.append(name)
				.append(phoneNumber)
				.append(socialSecurityNumber)
				.append(streetAddress)
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

	public void setId(CountryAndCodePrimaryKey id) {
		this.id = id;
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

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

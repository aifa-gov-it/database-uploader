package it.gov.aifa.invoice_processor.entity.invoice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.impl.AbstractInvoiceProcessorEntity;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Validated
public class InvoiceParticipant extends AbstractInvoiceProcessorEntity{

	private static final long serialVersionUID = -1455533028195877041L;

	private String city;
	
	private String country;
	
	private String district;
	
	private String emailAddress;

	private String eoriCode;
	
	private String faxNumber;

	private String firstName;

	private String houseNumber;
	
	private String lastName;
	
	@NotBlank
	private String name;
	
	private String permanentEstablishmentCity;

	private String permanentEstablishmentCountry;

	private String permanentEstablishmentDistrict;
	
	private String permanentEstablishmentHouseNumber;
	
	private String permanentEstablishmentStreetAddress;
	
	private String permanentEstablishmentZipCode;

	private String phoneNumber;
	
	private String socialSecurityNumber;

	private String streetAddress;

	private String taxCode;
	
	private String taxCountryCode;

	private String taxRepresentativeCountryId;
	
	private String taxRepresentativeFirstName;
	
	private String taxRepresentativeIdCode;
	
	private String taxRepresentativeLastName;
	
	private String taxRepresentativeName;
	
	private String title;
	
	private String zipCode;

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
	
	public String getEoriCode() {
		return eoriCode;
	}
	
	public String getFaxNumber() {
		return faxNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getHouseNumber() {
		return houseNumber;
	}
	
	@Override
	@Transient
	public List<String> getIdValues() {
		List<String> additionalIdValues = new ArrayList<>();
		if(StringUtils.isNotBlank(socialSecurityNumber))
			additionalIdValues.add(socialSecurityNumber);
		if(StringUtils.isNotBlank(taxCountryCode))
			additionalIdValues.add(taxCountryCode);
		if(StringUtils.isNotBlank(taxCode))
			additionalIdValues.add(taxCode);
		return Collections.unmodifiableList(additionalIdValues);
	}
	
	public String getLastName() {
		return lastName;
	}
	public String getName() {
		return name;
	}

	public String getPermanentEstablishmentCity() {
		return permanentEstablishmentCity;
	}

	public String getPermanentEstablishmentCountry() {
		return permanentEstablishmentCountry;
	}

	public String getPermanentEstablishmentDistrict() {
		return permanentEstablishmentDistrict;
	}

	public String getPermanentEstablishmentHouseNumber() {
		return permanentEstablishmentHouseNumber;
	}

	public String getPermanentEstablishmentStreetAddress() {
		return permanentEstablishmentStreetAddress;
	}

	public String getPermanentEstablishmentZipCode() {
		return permanentEstablishmentZipCode;
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

	public String getTaxRepresentativeCountryId() {
		return taxRepresentativeCountryId;
	}

	public String getTaxRepresentativeFirstName() {
		return taxRepresentativeFirstName;
	}

	public String getTaxRepresentativeIdCode() {
		return taxRepresentativeIdCode;
	}

	public String getTaxRepresentativeLastName() {
		return taxRepresentativeLastName;
	}

	public String getTaxRepresentativeName() {
		return taxRepresentativeName;
	}

	public String getTitle() {
		return title;
	}
	
	public String getZipCode() {
		return zipCode;
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
	
	public void setEoriCode(String eoriCode) {
		this.eoriCode = eoriCode;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPermanentEstablishmentCity(String permanentEstablishmentCity) {
		this.permanentEstablishmentCity = permanentEstablishmentCity;
	}

	public void setPermanentEstablishmentCountry(String permanentEstablishmentCountry) {
		this.permanentEstablishmentCountry = permanentEstablishmentCountry;
	}

	public void setPermanentEstablishmentDistrict(String permanentEstablishmentDistrict) {
		this.permanentEstablishmentDistrict = permanentEstablishmentDistrict;
	}

	public void setPermanentEstablishmentHouseNumber(String permanentEstablishmentHouseNumber) {
		this.permanentEstablishmentHouseNumber = permanentEstablishmentHouseNumber;
	}

	public void setPermanentEstablishmentStreetAddress(String permanentEstablishmentStreetAddress) {
		this.permanentEstablishmentStreetAddress = permanentEstablishmentStreetAddress;
	}

	public void setPermanentEstablishmentZipCode(String permanentEstablishmentZipCode) {
		this.permanentEstablishmentZipCode = permanentEstablishmentZipCode;
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

	public void setTaxRepresentativeCountryId(String taxRepresentativeCountryId) {
		this.taxRepresentativeCountryId = taxRepresentativeCountryId;
	}

	public void setTaxRepresentativeFirstName(String taxRepresentativeFirstName) {
		this.taxRepresentativeFirstName = taxRepresentativeFirstName;
	}

	public void setTaxRepresentativeIdCode(String taxRepresentativeIdCode) {
		this.taxRepresentativeIdCode = taxRepresentativeIdCode;
	}

	public void setTaxRepresentativeLastName(String taxRepresentativeLastName) {
		this.taxRepresentativeLastName = taxRepresentativeLastName;
	}

	public void setTaxRepresentativeName(String taxRepresentativeName) {
		this.taxRepresentativeName = taxRepresentativeName;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}

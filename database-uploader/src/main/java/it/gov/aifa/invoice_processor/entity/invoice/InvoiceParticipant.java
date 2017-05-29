package it.gov.aifa.invoice_processor.entity.invoice;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.impl.AbstractInvoiceReferenceEntity;

@Entity
@Validated
public class InvoiceParticipant extends AbstractInvoiceReferenceEntity{

	private static final long serialVersionUID = -1455533028195877041L;
	
	private String administrativeReference;
	
	private String city;

	private String clearanceState;
	
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

	private String numeroLicenzaGuida;

	private String permanentEstablishmentCity;

	private String permanentEstablishmentCountry;

	private String permanentEstablishmentDistrict;

	private String permanentEstablishmentHouseNumber;

	private String permanentEstablishmentStreetAddress;

	private String permanentEstablishmentZipCode;

	private String phoneNumber;

	private String professionalRegister;

	private String professionalRegisterDistrict;

	private String professionalRegisterNumber;

	private Date professionalRegisterSubscriptionDate;

	private String reaNumber;

	private String reaOffice;

	private BigDecimal shareCapital;

	private String socialSecurityNumber;

	private String soleStakeholder;

	private String streetAddress;

	private String taxCode;

	private String taxCountryCode;

	private String taxRepresentativeCountryId;

	private String taxRepresentativeFirstName;

	private String taxRepresentativeIdCode;

	private String taxRepresentativeLastName;
	
	private String taxRepresentativeName;
	
	private String taxSystem;
	
	private String title;

	private String type;

	private String zipCode;
	
	public InvoiceParticipant() {
		this(null, null);
	}

	public InvoiceParticipant(Invoice invoice, String invoiceParticipantType) {
		super(invoice);
		this.type = invoiceParticipantType;
	}

	@Override
	@Transient
	public List<String> getAdditionalIdValues() {
		List<String> additionalIdValues = new ArrayList<>();
		if(StringUtils.isNotBlank(socialSecurityNumber))
			additionalIdValues.add(socialSecurityNumber);
		if(StringUtils.isNotBlank(name))
			additionalIdValues.add(Integer.toString(name.hashCode()));
		else {
			if(StringUtils.isNotBlank(lastName))
				additionalIdValues.add(Integer.toString(lastName.hashCode()));
			if(StringUtils.isNotBlank(firstName))
				additionalIdValues.add(Integer.toString(firstName.hashCode()));
		}
		if(StringUtils.isNotBlank(taxCountryCode))
			additionalIdValues.add(taxCountryCode);
		if(StringUtils.isNotBlank(taxCode))
			additionalIdValues.add(taxCode);
		return Collections.unmodifiableList(additionalIdValues);
	}

	public String getAdministrativeReference() {
		return administrativeReference;
	}

	public String getCity() {
		return city;
	}
	
	public String getClearanceState() {
		return clearanceState;
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
	
	public String getLastName() {
		return lastName;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNumeroLicenzaGuida() {
		return numeroLicenzaGuida;
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
	
	public String getProfessionalRegister() {
		return professionalRegister;
	}
	
	public String getProfessionalRegisterDistrict() {
		return professionalRegisterDistrict;
	}
	
	public String getProfessionalRegisterNumber() {
		return professionalRegisterNumber;
	}
	
	public Date getProfessionalRegisterSubscriptionDate() {
		return professionalRegisterSubscriptionDate;
	}
	
	public String getReaNumber() {
		return reaNumber;
	}

	public String getReaOffice() {
		return reaOffice;
	}

	public BigDecimal getShareCapital() {
		return shareCapital;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	
	public String getSoleStakeholder() {
		return soleStakeholder;
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

	public String getTaxSystem() {
		return taxSystem;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setAdministrativeReference(String administrativeReference) {
		this.administrativeReference = administrativeReference;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setClearanceState(String clearanceState) {
		this.clearanceState = clearanceState;
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
	
	public void setNumeroLicenzaGuida(String numeroLicenzaGuida) {
		this.numeroLicenzaGuida = numeroLicenzaGuida;
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

	public void setProfessionalRegister(String professionalRegister) {
		this.professionalRegister = professionalRegister;
	}

	public void setProfessionalRegisterDistrict(String professionalRegisterDistrict) {
		this.professionalRegisterDistrict = professionalRegisterDistrict;
	}

	public void setProfessionalRegisterNumber(String professionalRegisterNumber) {
		this.professionalRegisterNumber = professionalRegisterNumber;
	}

	public void setProfessionalRegisterSubscriptionDate(Date professionalRegisterSubscriptionDate) {
		this.professionalRegisterSubscriptionDate = professionalRegisterSubscriptionDate;
	}

	public void setReaNumber(String reaNumber) {
		this.reaNumber = reaNumber;
	}

	public void setReaOffice(String reaOffice) {
		this.reaOffice = reaOffice;
	}

	public void setShareCapital(BigDecimal shareCapital) {
		this.shareCapital = shareCapital;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public void setSoleStakeholder(String soleStakeholder) {
		this.soleStakeholder = soleStakeholder;
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

	public void setTaxSystem(String taxSystem) {
		this.taxSystem = taxSystem;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}

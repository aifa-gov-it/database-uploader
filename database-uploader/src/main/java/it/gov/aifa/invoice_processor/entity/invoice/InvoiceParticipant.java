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

	private String permEstCity;

	private String permEstCountry;

	private String permEstDistrict;

	private String permEstHouseNumber;

	private String permEstStreetAddress;

	private String permEstZipCode;

	private String phoneNumber;

	private String professionalReg;

	private String professionalRegDistrict;

	private String professionalRegNumber;

	private Date professionalRegSubscrDate;

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

	public String getPermEstCity() {
		return permEstCity;
	}
	
	public String getPermEstCountry() {
		return permEstCountry;
	}

	public String getPermEstDistrict() {
		return permEstDistrict;
	}

	public String getPermEstHouseNumber() {
		return permEstHouseNumber;
	}
	
	public String getPermEstStreetAddress() {
		return permEstStreetAddress;
	}

	public String getPermEstZipCode() {
		return permEstZipCode;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getProfessionalReg() {
		return professionalReg;
	}
	
	public String getProfessionalRegDistrict() {
		return professionalRegDistrict;
	}
	
	public String getProfessionalRegNumber() {
		return professionalRegNumber;
	}
	
	public Date getProfessionalRegSubscrDate() {
		return professionalRegSubscrDate;
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
	
	public void setPermEstCity(String permEstCity) {
		this.permEstCity = permEstCity;
	}

	public void setPermEstCountry(String permEstCountry) {
		this.permEstCountry = permEstCountry;
	}
	
	public void setPermEstDistrict(String permEstDistrict) {
		this.permEstDistrict = permEstDistrict;
	}
	
	public void setPermEstHouseNumber(String permEstHouseNumber) {
		this.permEstHouseNumber = permEstHouseNumber;
	}
	
	public void setPermEstStreetAddress(String permEstStreetAddress) {
		this.permEstStreetAddress = permEstStreetAddress;
	}

	public void setPermEstZipCode(String permEstZipCode) {
		this.permEstZipCode = permEstZipCode;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setProfessionalReg(String professionalReg) {
		this.professionalReg = professionalReg;
	}

	public void setProfessionalRegDistrict(String professionalRegDistrict) {
		this.professionalRegDistrict = professionalRegDistrict;
	}

	public void setProfessionalRegNumber(String professionalRegNumber) {
		this.professionalRegNumber = professionalRegNumber;
	}

	public void setProfessionalRegSubscrDate(Date professionalRegSubscrDate) {
		this.professionalRegSubscrDate = professionalRegSubscrDate;
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

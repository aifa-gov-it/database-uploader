package it.gov.aifa.invoice_processor.entity.invoice;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class InvoiceCedentePrestatore extends InvoiceParticipant {
	
	private static final long serialVersionUID = 9222197347456154658L;

	private String administrativeReference;
	
	private String clearanceState;

	private String professionalRegister;
	
	private String professionalRegisterDistrict;

	private String professionalRegisterNumber;
	
	private Date professionalRegisterSubscriptionDate;
	
	private String reaNumber;
	
	private String reaOffice;

	private BigDecimal shareCapital;

	private String soleStakeholder;

	@NotBlank
	private String taxSystem;

	public String getAdministrativeReference() {
		return administrativeReference;
	}

	public String getClearanceState() {
		return clearanceState;
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
	
	public String getSoleStakeholder() {
		return soleStakeholder;
	}
	
	public String getTaxSystem() {
		return taxSystem;
	}

	public void setAdministrativeReference(String administrativeReference) {
		this.administrativeReference = administrativeReference;
	}

	public void setClearanceState(String clearanceState) {
		this.clearanceState = clearanceState;
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

	public void setSoleStakeholder(String soleStakeholder) {
		this.soleStakeholder = soleStakeholder;
	}

	public void setTaxSystem(String taxSystem) {
		this.taxSystem = taxSystem;
	}
}

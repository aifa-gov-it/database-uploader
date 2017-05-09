package it.gov.aifa.invoice_processor.entity.invoice;

import javax.persistence.Entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class InvoiceCedentePrestatore extends InvoiceParticipant {
	
	@NotBlank
	private String clearanceState;
	
	@NotBlank
	private String reaNumber;
	
	@NotBlank
	private String reaOffice;
	
	@NotBlank
	private String shareCapital;
	
	@NotBlank
	private String soleStakeholder;
	
	@NotBlank
	private String taxSystem;
	
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof InvoiceCedentePrestatore) == false) {
			return false;
		}
		InvoiceCedentePrestatore rhs = ((InvoiceCedentePrestatore) other);
		return new EqualsBuilder()
				.append(clearanceState, rhs.clearanceState)
				.append(reaNumber, rhs.reaNumber)
				.append(reaOffice, rhs.reaOffice)
				.append(shareCapital, rhs.shareCapital)
				.append(soleStakeholder, rhs.soleStakeholder)
				.append(taxSystem, rhs.taxSystem)
				.appendSuper(super.equals(other))
				.isEquals();
	}
	
	public String getClearanceState() {
		return clearanceState;
	}

	public String getReaNumber() {
		return reaNumber;
	}

	public String getReaOffice() {
		return reaOffice;
	}

	public String getShareCapital() {
		return shareCapital;
	}

	public String getSoleStakeholder() {
		return soleStakeholder;
	}

	public String getTaxSystem() {
		return taxSystem;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(clearanceState)
				.append(reaNumber)
				.append(reaOffice)
				.append(shareCapital)
				.append(soleStakeholder)
				.append(taxSystem)
				.toHashCode();
	}

	public void setClearanceState(String clearanceState) {
		this.clearanceState = clearanceState;
	}

	public void setReaNumber(String reaNumber) {
		this.reaNumber = reaNumber;
	}

	public void setReaOffice(String reaOffice) {
		this.reaOffice = reaOffice;
	}

	public void setShareCapital(String shareCapital) {
		this.shareCapital = shareCapital;
	}

	public void setSoleStakeholder(String soleStakeholder) {
		this.soleStakeholder = soleStakeholder;
	}

	public void setTaxSystem(String taxSystem) {
		this.taxSystem = taxSystem;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

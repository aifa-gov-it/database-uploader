package it.gov.aifa.invoice_processor.entity.invoice;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class FinancialInstitution {
	
	@NotBlank
	private String abi;
	
	@NotBlank
	private String bic;
	
	@NotBlank
	private String cab;
	
	@Id
	@NotBlank
	private String iban;
	
	@NotBlank
	private String name;
	
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof FinancialInstitution) == false) {
			return false;
		}
		FinancialInstitution rhs = ((FinancialInstitution) other);
		return new EqualsBuilder()
				.append(abi, rhs.abi)
				.append(bic, rhs.bic)
				.append(cab, rhs.cab)
				.append(iban, rhs.iban)
				.append(name, rhs.name)
				.isEquals();
	}

	public String getAbi() {
		return abi;
	}

	public String getBic() {
		return bic;
	}

	public String getCab() {
		return cab;
	}

	public String getIban() {
		return iban;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(abi)
				.append(bic)
				.append(cab)
				.append(iban)
				.append(name)
				.toHashCode();
	}

	public void setAbi(String abi) {
		this.abi = abi;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public void setCab(String cab) {
		this.cab = cab;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

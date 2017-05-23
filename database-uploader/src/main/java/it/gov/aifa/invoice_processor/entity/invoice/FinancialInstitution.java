package it.gov.aifa.invoice_processor.entity.invoice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.impl.AbstractInvoiceProcessorEntity;

@Entity
@Validated
public class FinancialInstitution extends AbstractInvoiceProcessorEntity {
	
	@NotBlank
	private String abi;
	
	@NotBlank
	private String bic;
	
	@NotBlank
	private String cab;
	
	@NotBlank
	private String iban;
	
	@NotBlank
	private String name;


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

	@Override
	public List<String> getIdValues() {
		List<String> additionalIdValues = new ArrayList<>();
		additionalIdValues.add(iban);
		return Collections.unmodifiableList(additionalIdValues);
	}

	public String getName() {
		return name;
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
}

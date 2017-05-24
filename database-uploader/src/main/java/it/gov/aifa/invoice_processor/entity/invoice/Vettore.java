package it.gov.aifa.invoice_processor.entity.invoice;

import javax.persistence.Entity;

import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class Vettore extends InvoiceParticipant {

	private static final long serialVersionUID = 5614247303755620926L;
	
	private String numeroLicenzaGuida;

	public String getNumeroLicenzaGuida() {
		return numeroLicenzaGuida;
	}
	
	public void setNumeroLicenzaGuida(String numeroLicenzaGuida) {
		this.numeroLicenzaGuida = numeroLicenzaGuida;
	}
}

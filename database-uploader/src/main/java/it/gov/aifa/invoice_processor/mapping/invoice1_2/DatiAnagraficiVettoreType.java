package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiAnagraficiVettoreType", propOrder = { "idFiscaleIVA", "codiceFiscale", "anagrafica",
		"numeroLicenzaGuida" })
public class DatiAnagraficiVettoreType {

	@XmlElement(name = "IdFiscaleIVA", required = true)
	protected IdFiscaleType idFiscaleIVA;
	@XmlElement(name = "CodiceFiscale")
	protected String codiceFiscale;
	@XmlElement(name = "Anagrafica", required = true)
	protected AnagraficaType anagrafica;
	@XmlElement(name = "NumeroLicenzaGuida")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String numeroLicenzaGuida;

	public IdFiscaleType getIdFiscaleIVA() {
		return idFiscaleIVA;
	}

	public void setIdFiscaleIVA(IdFiscaleType value) {
		this.idFiscaleIVA = value;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String value) {
		this.codiceFiscale = value;
	}

	public AnagraficaType getAnagrafica() {
		return anagrafica;
	}

	public void setAnagrafica(AnagraficaType value) {
		this.anagrafica = value;
	}

	public String getNumeroLicenzaGuida() {
		return numeroLicenzaGuida;
	}

	public void setNumeroLicenzaGuida(String value) {
		this.numeroLicenzaGuida = value;
	}

}

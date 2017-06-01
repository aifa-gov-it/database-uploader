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

	@XmlElement(name = "Anagrafica", required = true)
	protected AnagraficaType anagrafica;

	@XmlElement(name = "CodiceFiscale")
	protected String codiceFiscale;

	@XmlElement(name = "IdFiscaleIVA", required = true)
	protected IdFiscaleType idFiscaleIVA;
	@XmlElement(name = "NumeroLicenzaGuida")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String numeroLicenzaGuida;
	public DatiAnagraficiVettoreType() {
	}
	public DatiAnagraficiVettoreType(AnagraficaType anagrafica, String codiceFiscale, IdFiscaleType idFiscaleIVA,
			String numeroLicenzaGuida) {
		this.anagrafica = anagrafica;
		this.codiceFiscale = codiceFiscale;
		this.idFiscaleIVA = idFiscaleIVA;
		this.numeroLicenzaGuida = numeroLicenzaGuida;
	}

	public AnagraficaType getAnagrafica() {
		return anagrafica;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public IdFiscaleType getIdFiscaleIVA() {
		return idFiscaleIVA;
	}

	public String getNumeroLicenzaGuida() {
		return numeroLicenzaGuida;
	}

	public void setAnagrafica(AnagraficaType value) {
		this.anagrafica = value;
	}

	public void setCodiceFiscale(String value) {
		this.codiceFiscale = value;
	}

	public void setIdFiscaleIVA(IdFiscaleType value) {
		this.idFiscaleIVA = value;
	}

	public void setNumeroLicenzaGuida(String value) {
		this.numeroLicenzaGuida = value;
	}

}

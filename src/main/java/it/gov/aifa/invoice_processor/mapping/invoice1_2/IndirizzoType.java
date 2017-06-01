package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndirizzoType", propOrder = { "indirizzo", "numeroCivico", "cap", "comune", "provincia", "nazione" })
public class IndirizzoType {

	@XmlElement(name = "CAP", required = true)
	protected String cap;

	@XmlElement(name = "Comune", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String comune;

	@XmlElement(name = "Indirizzo", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String indirizzo;
	@XmlElement(name = "Nazione", required = true, defaultValue = "IT")
	protected String nazione;
	@XmlElement(name = "NumeroCivico")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String numeroCivico;
	@XmlElement(name = "Provincia")
	protected String provincia;
	public IndirizzoType() {
	}
	public IndirizzoType(String cap, String comune, String indirizzo, String nazione, String numeroCivico,
			String provincia) {
		this.cap = cap;
		this.comune = comune;
		this.indirizzo = indirizzo;
		this.nazione = nazione;
		this.numeroCivico = numeroCivico;
		this.provincia = provincia;
	}

	public String getCAP() {
		return cap;
	}

	public String getComune() {
		return comune;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getNazione() {
		return nazione;
	}

	public String getNumeroCivico() {
		return numeroCivico;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setCAP(String value) {
		this.cap = value;
	}

	public void setComune(String value) {
		this.comune = value;
	}

	public void setIndirizzo(String value) {
		this.indirizzo = value;
	}

	public void setNazione(String value) {
		this.nazione = value;
	}

	public void setNumeroCivico(String value) {
		this.numeroCivico = value;
	}

	public void setProvincia(String value) {
		this.provincia = value;
	}

}

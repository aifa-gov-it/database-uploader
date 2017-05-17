package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiAnagraficiCedenteType", propOrder = { "idFiscaleIVA", "codiceFiscale", "anagrafica",
		"alboProfessionale", "provinciaAlbo", "numeroIscrizioneAlbo", "dataIscrizioneAlbo", "regimeFiscale" })
public class DatiAnagraficiCedenteType {

	@XmlElement(name = "IdFiscaleIVA", required = true)
	protected IdFiscaleType idFiscaleIVA;
	@XmlElement(name = "CodiceFiscale")
	protected String codiceFiscale;
	@XmlElement(name = "Anagrafica", required = true)
	protected AnagraficaType anagrafica;
	@XmlElement(name = "AlboProfessionale")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String alboProfessionale;
	@XmlElement(name = "ProvinciaAlbo")
	protected String provinciaAlbo;
	@XmlElement(name = "NumeroIscrizioneAlbo")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String numeroIscrizioneAlbo;
	@XmlElement(name = "DataIscrizioneAlbo")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dataIscrizioneAlbo;
	@XmlElement(name = "RegimeFiscale", required = true)
	@XmlSchemaType(name = "string")
	protected RegimeFiscaleType regimeFiscale;

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

	public String getAlboProfessionale() {
		return alboProfessionale;
	}

	public void setAlboProfessionale(String value) {
		this.alboProfessionale = value;
	}

	public String getProvinciaAlbo() {
		return provinciaAlbo;
	}

	public void setProvinciaAlbo(String value) {
		this.provinciaAlbo = value;
	}

	public String getNumeroIscrizioneAlbo() {
		return numeroIscrizioneAlbo;
	}

	public void setNumeroIscrizioneAlbo(String value) {
		this.numeroIscrizioneAlbo = value;
	}

	public XMLGregorianCalendar getDataIscrizioneAlbo() {
		return dataIscrizioneAlbo;
	}

	public void setDataIscrizioneAlbo(XMLGregorianCalendar value) {
		this.dataIscrizioneAlbo = value;
	}

	public RegimeFiscaleType getRegimeFiscale() {
		return regimeFiscale;
	}

	public void setRegimeFiscale(RegimeFiscaleType value) {
		this.regimeFiscale = value;
	}

}

package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CedentePrestatoreType", propOrder = { "datiAnagrafici", "sede", "stabileOrganizzazione",
		"iscrizioneREA", "contatti", "riferimentoAmministrazione" })
public class CedentePrestatoreType {

	@XmlElement(name = "DatiAnagrafici", required = true)
	protected DatiAnagraficiCedenteType datiAnagrafici;
	@XmlElement(name = "Sede", required = true)
	protected IndirizzoType sede;
	@XmlElement(name = "StabileOrganizzazione")
	protected IndirizzoType stabileOrganizzazione;
	@XmlElement(name = "IscrizioneREA")
	protected IscrizioneREAType iscrizioneREA;
	@XmlElement(name = "Contatti")
	protected ContattiType contatti;
	@XmlElement(name = "RiferimentoAmministrazione")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String riferimentoAmministrazione;

	public DatiAnagraficiCedenteType getDatiAnagrafici() {
		return datiAnagrafici;
	}

	public void setDatiAnagrafici(DatiAnagraficiCedenteType value) {
		this.datiAnagrafici = value;
	}

	public IndirizzoType getSede() {
		return sede;
	}

	public void setSede(IndirizzoType value) {
		this.sede = value;
	}

	public IndirizzoType getStabileOrganizzazione() {
		return stabileOrganizzazione;
	}

	public void setStabileOrganizzazione(IndirizzoType value) {
		this.stabileOrganizzazione = value;
	}

	public IscrizioneREAType getIscrizioneREA() {
		return iscrizioneREA;
	}

	public void setIscrizioneREA(IscrizioneREAType value) {
		this.iscrizioneREA = value;
	}

	public ContattiType getContatti() {
		return contatti;
	}

	public void setContatti(ContattiType value) {
		this.contatti = value;
	}

	public String getRiferimentoAmministrazione() {
		return riferimentoAmministrazione;
	}

	public void setRiferimentoAmministrazione(String value) {
		this.riferimentoAmministrazione = value;
	}

}

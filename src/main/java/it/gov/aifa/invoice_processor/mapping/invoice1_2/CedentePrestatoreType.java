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

	@XmlElement(name = "Contatti")
	protected ContattiType contatti;

	@XmlElement(name = "DatiAnagrafici", required = true)
	protected DatiAnagraficiCedenteType datiAnagrafici;

	@XmlElement(name = "IscrizioneREA")
	protected IscrizioneREAType iscrizioneREA;
	@XmlElement(name = "RiferimentoAmministrazione")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String riferimentoAmministrazione;
	@XmlElement(name = "Sede", required = true)
	protected IndirizzoType sede;
	@XmlElement(name = "StabileOrganizzazione")
	protected IndirizzoType stabileOrganizzazione;
	public CedentePrestatoreType() {
	}
	public CedentePrestatoreType(ContattiType contatti, DatiAnagraficiCedenteType datiAnagrafici,
			IscrizioneREAType iscrizioneREA, String riferimentoAmministrazione, IndirizzoType sede,
			IndirizzoType stabileOrganizzazione) {
		this.contatti = contatti;
		this.datiAnagrafici = datiAnagrafici;
		this.iscrizioneREA = iscrizioneREA;
		this.riferimentoAmministrazione = riferimentoAmministrazione;
		this.sede = sede;
		this.stabileOrganizzazione = stabileOrganizzazione;
	}

	public ContattiType getContatti() {
		return contatti;
	}

	public DatiAnagraficiCedenteType getDatiAnagrafici() {
		return datiAnagrafici;
	}

	public IscrizioneREAType getIscrizioneREA() {
		return iscrizioneREA;
	}

	public String getRiferimentoAmministrazione() {
		return riferimentoAmministrazione;
	}

	public IndirizzoType getSede() {
		return sede;
	}

	public IndirizzoType getStabileOrganizzazione() {
		return stabileOrganizzazione;
	}

	public void setContatti(ContattiType value) {
		this.contatti = value;
	}

	public void setDatiAnagrafici(DatiAnagraficiCedenteType value) {
		this.datiAnagrafici = value;
	}

	public void setIscrizioneREA(IscrizioneREAType value) {
		this.iscrizioneREA = value;
	}

	public void setRiferimentoAmministrazione(String value) {
		this.riferimentoAmministrazione = value;
	}

	public void setSede(IndirizzoType value) {
		this.sede = value;
	}

	public void setStabileOrganizzazione(IndirizzoType value) {
		this.stabileOrganizzazione = value;
	}

}

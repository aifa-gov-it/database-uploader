package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CessionarioCommittenteType", propOrder = { "datiAnagrafici", "sede", "stabileOrganizzazione",
		"rappresentanteFiscale" })
public class CessionarioCommittenteType {

	@XmlElement(name = "DatiAnagrafici", required = true)
	protected DatiAnagraficiCessionarioType datiAnagrafici;

	@XmlElement(name = "RappresentanteFiscale")
	protected RappresentanteFiscaleCessionarioType rappresentanteFiscale;

	@XmlElement(name = "Sede", required = true)
	protected IndirizzoType sede;
	@XmlElement(name = "StabileOrganizzazione")
	protected IndirizzoType stabileOrganizzazione;
	public CessionarioCommittenteType() {
	}
	public CessionarioCommittenteType(DatiAnagraficiCessionarioType datiAnagrafici,
			RappresentanteFiscaleCessionarioType rappresentanteFiscale, IndirizzoType sede,
			IndirizzoType stabileOrganizzazione) {
		this.datiAnagrafici = datiAnagrafici;
		this.rappresentanteFiscale = rappresentanteFiscale;
		this.sede = sede;
		this.stabileOrganizzazione = stabileOrganizzazione;
	}

	public DatiAnagraficiCessionarioType getDatiAnagrafici() {
		return datiAnagrafici;
	}

	public RappresentanteFiscaleCessionarioType getRappresentanteFiscale() {
		return rappresentanteFiscale;
	}

	public IndirizzoType getSede() {
		return sede;
	}

	public IndirizzoType getStabileOrganizzazione() {
		return stabileOrganizzazione;
	}

	public void setDatiAnagrafici(DatiAnagraficiCessionarioType value) {
		this.datiAnagrafici = value;
	}

	public void setRappresentanteFiscale(RappresentanteFiscaleCessionarioType value) {
		this.rappresentanteFiscale = value;
	}

	public void setSede(IndirizzoType value) {
		this.sede = value;
	}

	public void setStabileOrganizzazione(IndirizzoType value) {
		this.stabileOrganizzazione = value;
	}

}

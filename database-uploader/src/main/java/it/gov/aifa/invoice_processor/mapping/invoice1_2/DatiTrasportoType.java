package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiTrasportoType", propOrder = { "datiAnagraficiVettore", "mezzoTrasporto", "causaleTrasporto",
		"numeroColli", "descrizione", "unitaMisuraPeso", "pesoLordo", "pesoNetto", "dataOraRitiro",
		"dataInizioTrasporto", "tipoResa", "indirizzoResa", "dataOraConsegna" })
public class DatiTrasportoType {

	@XmlElement(name = "CausaleTrasporto")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String causaleTrasporto;

	@XmlElement(name = "DataInizioTrasporto")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dataInizioTrasporto;

	@XmlElement(name = "DataOraConsegna")
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar dataOraConsegna;
	@XmlElement(name = "DataOraRitiro")
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar dataOraRitiro;
	@XmlElement(name = "DatiAnagraficiVettore")
	protected DatiAnagraficiVettoreType datiAnagraficiVettore;
	@XmlElement(name = "Descrizione")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String descrizione;
	@XmlElement(name = "IndirizzoResa")
	protected IndirizzoType indirizzoResa;
	@XmlElement(name = "MezzoTrasporto")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String mezzoTrasporto;
	@XmlElement(name = "NumeroColli")
	@XmlSchemaType(name = "integer")
	protected Integer numeroColli;
	@XmlElement(name = "PesoLordo")
	protected BigDecimal pesoLordo;
	@XmlElement(name = "PesoNetto")
	protected BigDecimal pesoNetto;
	@XmlElement(name = "TipoResa")
	protected String tipoResa;
	@XmlElement(name = "UnitaMisuraPeso")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String unitaMisuraPeso;
	public DatiTrasportoType() {
	}
	public DatiTrasportoType(String causaleTrasporto, XMLGregorianCalendar dataInizioTrasporto,
			XMLGregorianCalendar dataOraConsegna, XMLGregorianCalendar dataOraRitiro,
			DatiAnagraficiVettoreType datiAnagraficiVettore, String descrizione, IndirizzoType indirizzoResa,
			String mezzoTrasporto, Integer numeroColli, BigDecimal pesoLordo, BigDecimal pesoNetto, String tipoResa,
			String unitaMisuraPeso) {
		this.causaleTrasporto = causaleTrasporto;
		this.dataInizioTrasporto = dataInizioTrasporto;
		this.dataOraConsegna = dataOraConsegna;
		this.dataOraRitiro = dataOraRitiro;
		this.datiAnagraficiVettore = datiAnagraficiVettore;
		this.descrizione = descrizione;
		this.indirizzoResa = indirizzoResa;
		this.mezzoTrasporto = mezzoTrasporto;
		this.numeroColli = numeroColli;
		this.pesoLordo = pesoLordo;
		this.pesoNetto = pesoNetto;
		this.tipoResa = tipoResa;
		this.unitaMisuraPeso = unitaMisuraPeso;
	}

	public String getCausaleTrasporto() {
		return causaleTrasporto;
	}

	public XMLGregorianCalendar getDataInizioTrasporto() {
		return dataInizioTrasporto;
	}

	public XMLGregorianCalendar getDataOraConsegna() {
		return dataOraConsegna;
	}

	public XMLGregorianCalendar getDataOraRitiro() {
		return dataOraRitiro;
	}

	public DatiAnagraficiVettoreType getDatiAnagraficiVettore() {
		return datiAnagraficiVettore;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public IndirizzoType getIndirizzoResa() {
		return indirizzoResa;
	}

	public String getMezzoTrasporto() {
		return mezzoTrasporto;
	}

	public Integer getNumeroColli() {
		return numeroColli;
	}

	public BigDecimal getPesoLordo() {
		return pesoLordo;
	}

	public BigDecimal getPesoNetto() {
		return pesoNetto;
	}

	public String getTipoResa() {
		return tipoResa;
	}

	public String getUnitaMisuraPeso() {
		return unitaMisuraPeso;
	}

	public void setCausaleTrasporto(String value) {
		this.causaleTrasporto = value;
	}

	public void setDataInizioTrasporto(XMLGregorianCalendar value) {
		this.dataInizioTrasporto = value;
	}

	public void setDataOraConsegna(XMLGregorianCalendar value) {
		this.dataOraConsegna = value;
	}

	public void setDataOraRitiro(XMLGregorianCalendar value) {
		this.dataOraRitiro = value;
	}

	public void setDatiAnagraficiVettore(DatiAnagraficiVettoreType value) {
		this.datiAnagraficiVettore = value;
	}

	public void setDescrizione(String value) {
		this.descrizione = value;
	}

	public void setIndirizzoResa(IndirizzoType value) {
		this.indirizzoResa = value;
	}

	public void setMezzoTrasporto(String value) {
		this.mezzoTrasporto = value;
	}

	public void setNumeroColli(Integer value) {
		this.numeroColli = value;
	}

	public void setPesoLordo(BigDecimal value) {
		this.pesoLordo = value;
	}

	public void setPesoNetto(BigDecimal value) {
		this.pesoNetto = value;
	}

	public void setTipoResa(String value) {
		this.tipoResa = value;
	}

	public void setUnitaMisuraPeso(String value) {
		this.unitaMisuraPeso = value;
	}

}

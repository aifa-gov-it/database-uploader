package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DettaglioLineeType", propOrder = { "numeroLinea", "tipoCessionePrestazione", "codiceArticolo",
		"descrizione", "quantita", "unitaMisura", "dataInizioPeriodo", "dataFinePeriodo", "prezzoUnitario",
		"scontoMaggiorazione", "prezzoTotale", "aliquotaIVA", "ritenuta", "natura", "riferimentoAmministrazione",
		"altriDatiGestionali" })
public class DettaglioLineeType {

	@XmlElement(name = "AliquotaIVA", required = true)
	protected BigDecimal aliquotaIVA;

	@XmlElement(name = "AltriDatiGestionali")
	protected List<AltriDatiGestionaliType> altriDatiGestionali;

	@XmlElement(name = "CodiceArticolo")
	protected List<CodiceArticoloType> codiceArticolo;
	@XmlElement(name = "DataFinePeriodo")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dataFinePeriodo;
	@XmlElement(name = "DataInizioPeriodo")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dataInizioPeriodo;
	@XmlElement(name = "Descrizione", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String descrizione;
	@XmlElement(name = "Natura")
	@XmlSchemaType(name = "string")
	protected NaturaType natura;
	@XmlElement(name = "NumeroLinea")
	@XmlSchemaType(name = "integer")
	protected int numeroLinea;
	@XmlElement(name = "PrezzoTotale", required = true)
	protected BigDecimal prezzoTotale;
	@XmlElement(name = "PrezzoUnitario", required = true)
	protected BigDecimal prezzoUnitario;
	@XmlElement(name = "Quantita")
	protected BigDecimal quantita;
	@XmlElement(name = "RiferimentoAmministrazione")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String riferimentoAmministrazione;
	@XmlElement(name = "Ritenuta")
	@XmlSchemaType(name = "string")
	protected RitenutaType ritenuta;
	@XmlElement(name = "ScontoMaggiorazione")
	protected List<ScontoMaggiorazioneType> scontoMaggiorazione;
	@XmlElement(name = "TipoCessionePrestazione")
	@XmlSchemaType(name = "string")
	protected TipoCessionePrestazioneType tipoCessionePrestazione;
	@XmlElement(name = "UnitaMisura")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String unitaMisura;
	public DettaglioLineeType() {
	}
	public DettaglioLineeType(BigDecimal aliquotaIVA, List<AltriDatiGestionaliType> altriDatiGestionali,
			List<CodiceArticoloType> codiceArticolo, XMLGregorianCalendar dataFinePeriodo,
			XMLGregorianCalendar dataInizioPeriodo, String descrizione, NaturaType natura, int numeroLinea,
			BigDecimal prezzoTotale, BigDecimal prezzoUnitario, BigDecimal quantita, String riferimentoAmministrazione,
			RitenutaType ritenuta, List<ScontoMaggiorazioneType> scontoMaggiorazione,
			TipoCessionePrestazioneType tipoCessionePrestazione, String unitaMisura) {
		this.aliquotaIVA = aliquotaIVA;
		this.altriDatiGestionali = altriDatiGestionali;
		this.codiceArticolo = codiceArticolo;
		this.dataFinePeriodo = dataFinePeriodo;
		this.dataInizioPeriodo = dataInizioPeriodo;
		this.descrizione = descrizione;
		this.natura = natura;
		this.numeroLinea = numeroLinea;
		this.prezzoTotale = prezzoTotale;
		this.prezzoUnitario = prezzoUnitario;
		this.quantita = quantita;
		this.riferimentoAmministrazione = riferimentoAmministrazione;
		this.ritenuta = ritenuta;
		this.scontoMaggiorazione = scontoMaggiorazione;
		this.tipoCessionePrestazione = tipoCessionePrestazione;
		this.unitaMisura = unitaMisura;
	}

	public BigDecimal getAliquotaIVA() {
		return aliquotaIVA;
	}

	public List<AltriDatiGestionaliType> getAltriDatiGestionali() {
		if (altriDatiGestionali == null) {
			altriDatiGestionali = new ArrayList<AltriDatiGestionaliType>();
		}
		return this.altriDatiGestionali;
	}

	public List<CodiceArticoloType> getCodiceArticolo() {
		if (codiceArticolo == null) {
			codiceArticolo = new ArrayList<CodiceArticoloType>();
		}
		return this.codiceArticolo;
	}

	public XMLGregorianCalendar getDataFinePeriodo() {
		return dataFinePeriodo;
	}

	public XMLGregorianCalendar getDataInizioPeriodo() {
		return dataInizioPeriodo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public NaturaType getNatura() {
		return natura;
	}

	public int getNumeroLinea() {
		return numeroLinea;
	}

	public BigDecimal getPrezzoTotale() {
		return prezzoTotale;
	}

	public BigDecimal getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public BigDecimal getQuantita() {
		return quantita;
	}

	public String getRiferimentoAmministrazione() {
		return riferimentoAmministrazione;
	}

	public RitenutaType getRitenuta() {
		return ritenuta;
	}

	public List<ScontoMaggiorazioneType> getScontoMaggiorazione() {
		if (scontoMaggiorazione == null) {
			scontoMaggiorazione = new ArrayList<ScontoMaggiorazioneType>();
		}
		return this.scontoMaggiorazione;
	}

	public TipoCessionePrestazioneType getTipoCessionePrestazione() {
		return tipoCessionePrestazione;
	}

	public String getUnitaMisura() {
		return unitaMisura;
	}

	public void setAliquotaIVA(BigDecimal value) {
		this.aliquotaIVA = value;
	}

	public void setDataFinePeriodo(XMLGregorianCalendar value) {
		this.dataFinePeriodo = value;
	}

	public void setDataInizioPeriodo(XMLGregorianCalendar value) {
		this.dataInizioPeriodo = value;
	}

	public void setDescrizione(String value) {
		this.descrizione = value;
	}

	public void setNatura(NaturaType value) {
		this.natura = value;
	}

	public void setNumeroLinea(int value) {
		this.numeroLinea = value;
	}

	public void setPrezzoTotale(BigDecimal value) {
		this.prezzoTotale = value;
	}

	public void setPrezzoUnitario(BigDecimal value) {
		this.prezzoUnitario = value;
	}

	public void setQuantita(BigDecimal value) {
		this.quantita = value;
	}

	public void setRiferimentoAmministrazione(String value) {
		this.riferimentoAmministrazione = value;
	}

	public void setRitenuta(RitenutaType value) {
		this.ritenuta = value;
	}

	public void setTipoCessionePrestazione(TipoCessionePrestazioneType value) {
		this.tipoCessionePrestazione = value;
	}

	public void setUnitaMisura(String value) {
		this.unitaMisura = value;
	}

}

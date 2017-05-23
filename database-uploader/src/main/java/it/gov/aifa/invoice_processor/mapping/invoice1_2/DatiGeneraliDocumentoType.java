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
@XmlType(name = "DatiGeneraliDocumentoType", propOrder = { "tipoDocumento", "divisa", "data", "numero", "datiRitenuta",
		"datiBollo", "datiCassaPrevidenziale", "scontoMaggiorazione", "importoTotaleDocumento", "arrotondamento",
		"causale", "art73" })
public class DatiGeneraliDocumentoType {

	@XmlElement(name = "Arrotondamento")
	protected BigDecimal arrotondamento;

	@XmlElement(name = "Art73")
	@XmlSchemaType(name = "string")
	protected Art73Type art73;

	@XmlElement(name = "Causale")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected List<String> causale;
	@XmlElement(name = "Data", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar data;
	@XmlElement(name = "DatiBollo")
	protected DatiBolloType datiBollo;
	@XmlElement(name = "DatiCassaPrevidenziale")
	protected List<DatiCassaPrevidenzialeType> datiCassaPrevidenziale;
	@XmlElement(name = "DatiRitenuta")
	protected DatiRitenutaType datiRitenuta;
	@XmlElement(name = "Divisa", required = true)
	protected String divisa;
	@XmlElement(name = "ImportoTotaleDocumento")
	protected BigDecimal importoTotaleDocumento;
	@XmlElement(name = "Numero", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String numero;
	@XmlElement(name = "ScontoMaggiorazione")
	protected List<ScontoMaggiorazioneType> scontoMaggiorazione;
	@XmlElement(name = "TipoDocumento", required = true)
	@XmlSchemaType(name = "string")
	protected TipoDocumentoType tipoDocumento;
	public DatiGeneraliDocumentoType() {
	}
	public DatiGeneraliDocumentoType(BigDecimal arrotondamento, Art73Type art73, List<String> causale,
			XMLGregorianCalendar data, DatiBolloType datiBollo, List<DatiCassaPrevidenzialeType> datiCassaPrevidenziale,
			DatiRitenutaType datiRitenuta, String divisa, BigDecimal importoTotaleDocumento, String numero,
			List<ScontoMaggiorazioneType> scontoMaggiorazione, TipoDocumentoType tipoDocumento) {
		this.arrotondamento = arrotondamento;
		this.art73 = art73;
		this.causale = causale;
		this.data = data;
		this.datiBollo = datiBollo;
		this.datiCassaPrevidenziale = datiCassaPrevidenziale;
		this.datiRitenuta = datiRitenuta;
		this.divisa = divisa;
		this.importoTotaleDocumento = importoTotaleDocumento;
		this.numero = numero;
		this.scontoMaggiorazione = scontoMaggiorazione;
		this.tipoDocumento = tipoDocumento;
	}

	public BigDecimal getArrotondamento() {
		return arrotondamento;
	}

	public Art73Type getArt73() {
		return art73;
	}

	public List<String> getCausale() {
		if (causale == null) {
			causale = new ArrayList<String>();
		}
		return this.causale;
	}

	public XMLGregorianCalendar getData() {
		return data;
	}

	public DatiBolloType getDatiBollo() {
		return datiBollo;
	}

	public List<DatiCassaPrevidenzialeType> getDatiCassaPrevidenziale() {
		if (datiCassaPrevidenziale == null) {
			datiCassaPrevidenziale = new ArrayList<DatiCassaPrevidenzialeType>();
		}
		return this.datiCassaPrevidenziale;
	}

	public DatiRitenutaType getDatiRitenuta() {
		return datiRitenuta;
	}

	public String getDivisa() {
		return divisa;
	}

	public BigDecimal getImportoTotaleDocumento() {
		return importoTotaleDocumento;
	}

	public String getNumero() {
		return numero;
	}

	public List<ScontoMaggiorazioneType> getScontoMaggiorazione() {
		if (scontoMaggiorazione == null) {
			scontoMaggiorazione = new ArrayList<ScontoMaggiorazioneType>();
		}
		return this.scontoMaggiorazione;
	}

	public TipoDocumentoType getTipoDocumento() {
		return tipoDocumento;
	}

	public void setArrotondamento(BigDecimal value) {
		this.arrotondamento = value;
	}

	public void setArt73(Art73Type value) {
		this.art73 = value;
	}

	public void setData(XMLGregorianCalendar value) {
		this.data = value;
	}

	public void setDatiBollo(DatiBolloType value) {
		this.datiBollo = value;
	}

	public void setDatiRitenuta(DatiRitenutaType value) {
		this.datiRitenuta = value;
	}

	public void setDivisa(String value) {
		this.divisa = value;
	}

	public void setImportoTotaleDocumento(BigDecimal value) {
		this.importoTotaleDocumento = value;
	}

	public void setNumero(String value) {
		this.numero = value;
	}

	public void setTipoDocumento(TipoDocumentoType value) {
		this.tipoDocumento = value;
	}

}

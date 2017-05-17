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

	@XmlElement(name = "TipoDocumento", required = true)
	@XmlSchemaType(name = "string")
	protected TipoDocumentoType tipoDocumento;
	@XmlElement(name = "Divisa", required = true)
	protected String divisa;
	@XmlElement(name = "Data", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar data;
	@XmlElement(name = "Numero", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String numero;
	@XmlElement(name = "DatiRitenuta")
	protected DatiRitenutaType datiRitenuta;
	@XmlElement(name = "DatiBollo")
	protected DatiBolloType datiBollo;
	@XmlElement(name = "DatiCassaPrevidenziale")
	protected List<DatiCassaPrevidenzialeType> datiCassaPrevidenziale;
	@XmlElement(name = "ScontoMaggiorazione")
	protected List<ScontoMaggiorazioneType> scontoMaggiorazione;
	@XmlElement(name = "ImportoTotaleDocumento")
	protected BigDecimal importoTotaleDocumento;
	@XmlElement(name = "Arrotondamento")
	protected BigDecimal arrotondamento;
	@XmlElement(name = "Causale")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected List<String> causale;
	@XmlElement(name = "Art73")
	@XmlSchemaType(name = "string")
	protected Art73Type art73;

	public TipoDocumentoType getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoType value) {
		this.tipoDocumento = value;
	}

	public String getDivisa() {
		return divisa;
	}

	public void setDivisa(String value) {
		this.divisa = value;
	}

	public XMLGregorianCalendar getData() {
		return data;
	}

	public void setData(XMLGregorianCalendar value) {
		this.data = value;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String value) {
		this.numero = value;
	}

	public DatiRitenutaType getDatiRitenuta() {
		return datiRitenuta;
	}

	public void setDatiRitenuta(DatiRitenutaType value) {
		this.datiRitenuta = value;
	}

	public DatiBolloType getDatiBollo() {
		return datiBollo;
	}

	public void setDatiBollo(DatiBolloType value) {
		this.datiBollo = value;
	}

	public List<DatiCassaPrevidenzialeType> getDatiCassaPrevidenziale() {
		if (datiCassaPrevidenziale == null) {
			datiCassaPrevidenziale = new ArrayList<DatiCassaPrevidenzialeType>();
		}
		return this.datiCassaPrevidenziale;
	}

	public List<ScontoMaggiorazioneType> getScontoMaggiorazione() {
		if (scontoMaggiorazione == null) {
			scontoMaggiorazione = new ArrayList<ScontoMaggiorazioneType>();
		}
		return this.scontoMaggiorazione;
	}

	public BigDecimal getImportoTotaleDocumento() {
		return importoTotaleDocumento;
	}

	public void setImportoTotaleDocumento(BigDecimal value) {
		this.importoTotaleDocumento = value;
	}

	public BigDecimal getArrotondamento() {
		return arrotondamento;
	}

	public void setArrotondamento(BigDecimal value) {
		this.arrotondamento = value;
	}

	public List<String> getCausale() {
		if (causale == null) {
			causale = new ArrayList<String>();
		}
		return this.causale;
	}

	public Art73Type getArt73() {
		return art73;
	}

	public void setArt73(Art73Type value) {
		this.art73 = value;
	}

}

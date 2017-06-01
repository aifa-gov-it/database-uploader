package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiRitenutaType", propOrder = { "tipoRitenuta", "importoRitenuta", "aliquotaRitenuta",
		"causalePagamento" })
public class DatiRitenutaType {

	@XmlElement(name = "AliquotaRitenuta", required = true)
	protected BigDecimal aliquotaRitenuta;

	@XmlElement(name = "CausalePagamento", required = true)
	@XmlSchemaType(name = "string")
	protected CausalePagamentoType causalePagamento;

	@XmlElement(name = "ImportoRitenuta", required = true)
	protected BigDecimal importoRitenuta;
	@XmlElement(name = "TipoRitenuta", required = true)
	@XmlSchemaType(name = "string")
	protected TipoRitenutaType tipoRitenuta;
	public DatiRitenutaType() {
	}
	public DatiRitenutaType(BigDecimal aliquotaRitenuta, CausalePagamentoType causalePagamento,
			BigDecimal importoRitenuta, TipoRitenutaType tipoRitenuta) {
		this.aliquotaRitenuta = aliquotaRitenuta;
		this.causalePagamento = causalePagamento;
		this.importoRitenuta = importoRitenuta;
		this.tipoRitenuta = tipoRitenuta;
	}

	public BigDecimal getAliquotaRitenuta() {
		return aliquotaRitenuta;
	}

	public CausalePagamentoType getCausalePagamento() {
		return causalePagamento;
	}

	public BigDecimal getImportoRitenuta() {
		return importoRitenuta;
	}

	public TipoRitenutaType getTipoRitenuta() {
		return tipoRitenuta;
	}

	public void setAliquotaRitenuta(BigDecimal value) {
		this.aliquotaRitenuta = value;
	}

	public void setCausalePagamento(CausalePagamentoType value) {
		this.causalePagamento = value;
	}

	public void setImportoRitenuta(BigDecimal value) {
		this.importoRitenuta = value;
	}

	public void setTipoRitenuta(TipoRitenutaType value) {
		this.tipoRitenuta = value;
	}

}

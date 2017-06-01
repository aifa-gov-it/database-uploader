package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiRiepilogoType", propOrder = { "aliquotaIVA", "natura", "speseAccessorie", "arrotondamento",
		"imponibileImporto", "imposta", "esigibilitaIVA", "riferimentoNormativo" })
public class DatiRiepilogoType {

	@XmlElement(name = "AliquotaIVA", required = true)
	protected BigDecimal aliquotaIVA;

	@XmlElement(name = "Arrotondamento")
	protected BigDecimal arrotondamento;

	@XmlElement(name = "EsigibilitaIVA")
	@XmlSchemaType(name = "string")
	protected EsigibilitaIVAType esigibilitaIVA;
	@XmlElement(name = "ImponibileImporto", required = true)
	protected BigDecimal imponibileImporto;
	@XmlElement(name = "Imposta", required = true)
	protected BigDecimal imposta;
	@XmlElement(name = "Natura")
	@XmlSchemaType(name = "string")
	protected NaturaType natura;
	@XmlElement(name = "RiferimentoNormativo")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String riferimentoNormativo;
	@XmlElement(name = "SpeseAccessorie")
	protected BigDecimal speseAccessorie;
	public DatiRiepilogoType() {
	}
	public DatiRiepilogoType(BigDecimal aliquotaIVA, BigDecimal arrotondamento, EsigibilitaIVAType esigibilitaIVA,
			BigDecimal imponibileImporto, BigDecimal imposta, NaturaType natura, String riferimentoNormativo,
			BigDecimal speseAccessorie) {
		this.aliquotaIVA = aliquotaIVA;
		this.arrotondamento = arrotondamento;
		this.esigibilitaIVA = esigibilitaIVA;
		this.imponibileImporto = imponibileImporto;
		this.imposta = imposta;
		this.natura = natura;
		this.riferimentoNormativo = riferimentoNormativo;
		this.speseAccessorie = speseAccessorie;
	}

	public BigDecimal getAliquotaIVA() {
		return aliquotaIVA;
	}

	public BigDecimal getArrotondamento() {
		return arrotondamento;
	}

	public EsigibilitaIVAType getEsigibilitaIVA() {
		return esigibilitaIVA;
	}

	public BigDecimal getImponibileImporto() {
		return imponibileImporto;
	}

	public BigDecimal getImposta() {
		return imposta;
	}

	public NaturaType getNatura() {
		return natura;
	}

	public String getRiferimentoNormativo() {
		return riferimentoNormativo;
	}

	public BigDecimal getSpeseAccessorie() {
		return speseAccessorie;
	}

	public void setAliquotaIVA(BigDecimal value) {
		this.aliquotaIVA = value;
	}

	public void setArrotondamento(BigDecimal value) {
		this.arrotondamento = value;
	}

	public void setEsigibilitaIVA(EsigibilitaIVAType value) {
		this.esigibilitaIVA = value;
	}

	public void setImponibileImporto(BigDecimal value) {
		this.imponibileImporto = value;
	}

	public void setImposta(BigDecimal value) {
		this.imposta = value;
	}

	public void setNatura(NaturaType value) {
		this.natura = value;
	}

	public void setRiferimentoNormativo(String value) {
		this.riferimentoNormativo = value;
	}

	public void setSpeseAccessorie(BigDecimal value) {
		this.speseAccessorie = value;
	}

}

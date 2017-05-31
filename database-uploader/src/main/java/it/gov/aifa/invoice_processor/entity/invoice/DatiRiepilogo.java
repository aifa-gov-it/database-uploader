package it.gov.aifa.invoice_processor.entity.invoice;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.impl.AbstractInvoiceReferenceEntity;

@Entity
@Validated
public class DatiRiepilogo extends AbstractInvoiceReferenceEntity {
	private static final long serialVersionUID = -2915903776609151751L;

	@NotNull
	private BigDecimal aliquotaIVA;

	private BigDecimal arrotondamento;

	private String esigibilitaIVA;

	@NotNull
	private BigDecimal imponibileImporto;

	@NotNull
	private BigDecimal imposta;

	private String natura;
	
	private String riferimentoNormativo;

	private BigDecimal speseAccessorie;

	public DatiRiepilogo() {
		super();
	}
	
	public DatiRiepilogo(
			BigDecimal aliquotaIVA
			, BigDecimal arrotondamento
			, String esigibilitaIVA
			, BigDecimal imponibileImporto
			, BigDecimal imposta
			, Invoice invoice
			, String natura
			, String riferimentoNormativo
			, BigDecimal speseAccessorie) {
		super(invoice);
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
	
	public String getEsigibilitaIVA() {
		return esigibilitaIVA;
	}
	
	public BigDecimal getImponibileImporto() {
		return imponibileImporto;
	}
	
	public BigDecimal getImposta() {
		return imposta;
	}
	
	public String getNatura() {
		return natura;
	}

	public String getRiferimentoNormativo() {
		return riferimentoNormativo;
	}

	public BigDecimal getSpeseAccessorie() {
		return speseAccessorie;
	}

	public void setAliquotaIVA(BigDecimal aliquotaIVA) {
		this.aliquotaIVA = aliquotaIVA;
	}

	public void setArrotondamento(BigDecimal arrotondamento) {
		this.arrotondamento = arrotondamento;
	}

	public void setEsigibilitaIVA(String esigibilitaIVA) {
		this.esigibilitaIVA = esigibilitaIVA;
	}

	public void setImponibileImporto(BigDecimal imponibileImporto) {
		this.imponibileImporto = imponibileImporto;
	}

	public void setImposta(BigDecimal imposta) {
		this.imposta = imposta;
	}

	public void setNatura(String natura) {
		this.natura = natura;
	}

	public void setRiferimentoNormativo(String riferimentoNormativo) {
		this.riferimentoNormativo = riferimentoNormativo;
	}

	public void setSpeseAccessorie(BigDecimal speseAccessorie) {
		this.speseAccessorie = speseAccessorie;
	}
}

package it.gov.aifa.invoice_processor.service.impl;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.mapping.InvoiceMapping;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.AllegatiType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.CedentePrestatoreType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.CessionarioCommittenteType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiBeniServiziType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiGeneraliType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiPagamentoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiTrasmissioneType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiVeicoliType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DettaglioPagamentoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.RappresentanteFiscaleType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.SoggettoEmittenteType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.TerzoIntermediarioSoggettoEmittenteType;
import it.gov.aifa.invoice_processor.service.InvoiceMappingToEntityConverter;

public abstract class AbstractInvoiceMappingToEntityConverter
<S extends InvoiceMapping<String>,T extends Invoice>
implements InvoiceMappingToEntityConverter<S, T> {
	
	protected abstract void buildAttachments(
			@NotNull List<AllegatiType> allegati
			, @NotNull Invoice invoice);

	protected abstract void buildCedentePrestatore(
			@NotNull CedentePrestatoreType cedentePrestatore
			, @NotNull Invoice invoice);

	protected abstract void buildCessionarioCommittente(
			@NotNull CessionarioCommittenteType cessionarioCommittente
			, @NotNull Invoice invoice);

	protected abstract void buildDatiGenerali(
			@NotNull DatiGeneraliType datiGenerali
			, @NotNull Invoice invoice);

	protected abstract void buildDatiPagamento(
			@NotEmpty List<DatiPagamentoType> datiPagamento
			, @NotNull Invoice invoice);

	protected abstract void buildDatiVeicoli(DatiVeicoliType datiVeicoli, @NotNull Invoice invoice);

	protected abstract void buildFinancialInstitution(
			@NotNull DettaglioPagamentoType dettaglioPagamentoType
			, @NotNull Invoice invoice);

	protected abstract void buildInvoiceItems(
			@NotNull DatiBeniServiziType datiBeniServizi
			, @NotNull Invoice invoice);

	protected abstract void buildInvoiceSending(
			@NotNull DatiTrasmissioneType datiTrasmissione
			, @NotNull Invoice invoice);

	protected abstract void buildRappresentanteFiscale(RappresentanteFiscaleType rappresentanteFiscale, @NotNull Invoice invoice);

	protected abstract void buildSoggettoEmittente(
			@NotNull SoggettoEmittenteType soggettoEmittente
			, @NotNull TerzoIntermediarioSoggettoEmittenteType terzoIntermediarioSoggettoEmittenteType
			, @NotNull Invoice invoice);
}

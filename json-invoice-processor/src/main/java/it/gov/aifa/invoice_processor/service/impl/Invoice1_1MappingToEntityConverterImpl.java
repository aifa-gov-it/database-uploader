package it.gov.aifa.invoice_processor.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.invoice.CountryAndCodePrimaryKey;
import it.gov.aifa.invoice_processor.entity.invoice.FinancialInstitution;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceCedentePrestatore;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceParticipant;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.CedentePrestatore;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.CessionarioCommittente;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiBollo;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiGenerali;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiGeneraliDocumento;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiPagamento;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiTrasmissione;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DettaglioPagamento;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.FatturaElettronicaBody;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.FatturaElettronicaHeader;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.Invoice1_1;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.ScontoMaggiorazione;
import it.gov.aifa.invoice_processor.service.InvoiceMappingToEntityConverter;

@Service
@Validated
public class Invoice1_1MappingToEntityConverterImpl implements InvoiceMappingToEntityConverter<Invoice1_1, Invoice> {
	
	@Override
	public Invoice convert(Invoice1_1 source) {
		Invoice invoice = new Invoice();
		HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica fatturaElettronica = source.getHttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica();
		FatturaElettronicaHeader header = fatturaElettronica.getFatturaElettronicaHeader();
		
		invoice.setCedentePrestatore(buildCedentePrestatore(header.getCedentePrestatore()));
		invoice.setCessionarioCommittente(buildCessionarioCommittente(header.getCessionarioCommittente()));
		
		FatturaElettronicaBody body = fatturaElettronica.getFatturaElettronicaBody();
		DatiGenerali datiGenerali = body.getDatiGenerali();
		DatiGeneraliDocumento datiGeneraliDocumento = datiGenerali.getDatiGeneraliDocumento();
		
		invoice.setCurrency(datiGeneraliDocumento.getDivisa());
		
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		formatter = formatter.withLocale(Locale.ITALIAN);
		LocalDate invoiceDate = LocalDate.parse(datiGeneraliDocumento.getData(), formatter);
		invoice.setDate(invoiceDate);
		
		invoice.setDescription(String.join("", datiGeneraliDocumento.getCausale()));
		
		ScontoMaggiorazione discount = datiGeneraliDocumento.getScontoMaggiorazione();
		if(discount != null) {
			invoice.setDiscountAmount(
					discount.getImporto() != null ? Double.parseDouble(discount.getImporto()) : null);
			invoice.setDiscountType(discount.getTipo());
		}
		
		DatiBollo datiBollo = datiGeneraliDocumento.getDatiBollo();
		if(datiBollo != null) {
			invoice.setStampAmount(Double.parseDouble(datiBollo.getImportoBollo()));
			invoice.setVirtualStamp(
					datiBollo.getBolloVirtuale() == null ? null :
							datiBollo.getBolloVirtuale().equals("SI") ? true : false);
		}
		
		invoice.setDocumentTypeCode(datiGenerali.getDatiGeneraliDocumento().getTipoDocumento());
		
		DatiPagamento datiPagamento = body.getDatiPagamento();
		DettaglioPagamento dettaglioPagamento = datiPagamento.getDettaglioPagamento();
		invoice.setFinancialInstitution(buildFinancialInstitution(dettaglioPagamento));
		
		DatiTrasmissione datiTrasmissione = header.getDatiTrasmissione();
		invoice.setInvoiceRecipientCode(datiTrasmissione.getCodiceDestinatario());
		invoice.setInvoiceSenderCode(datiTrasmissione.getIdTrasmittente().getIdCodice());
		invoice.setInvoiceSenderCountryCode(datiTrasmissione.getIdTrasmittente().getIdPaese());
		invoice.setInvoiceSenderEmailAddress(datiTrasmissione.getContattiTrasmittente().getEmail());
		invoice.setInvoiceSendingFormat(datiTrasmissione.getFormatoTrasmissione());
		invoice.setInvoiceSendingNumber(datiTrasmissione.getProgressivoInvio());
		
		return invoice;
	}
	
	private InvoiceCedentePrestatore buildCedentePrestatore(@NotNull CedentePrestatore cedentePrestatore) {
		InvoiceCedentePrestatore invoiceCedentePrestatore = new InvoiceCedentePrestatore();
		invoiceCedentePrestatore.setCity(cedentePrestatore.getSede().getComune());
		invoiceCedentePrestatore.setClearanceState(cedentePrestatore.getIscrizioneREA().getStatoLiquidazione());
		invoiceCedentePrestatore.setCountry(cedentePrestatore.getSede().getNazione());
		invoiceCedentePrestatore.setDistrict(cedentePrestatore.getSede().getProvincia());
		invoiceCedentePrestatore.setEmailAddress(null);
		invoiceCedentePrestatore.setId(new CountryAndCodePrimaryKey(
				cedentePrestatore.getDatiAnagrafici().getIdFiscaleIVA().getIdCodice()
				, cedentePrestatore.getDatiAnagrafici().getIdFiscaleIVA().getIdPaese()));
		invoiceCedentePrestatore.setName(cedentePrestatore.getDatiAnagrafici().getAnagrafica().getDenominazione());
		invoiceCedentePrestatore.setPhoneNumber(cedentePrestatore.getContatti().getTelefono());
		invoiceCedentePrestatore.setReaNumber(cedentePrestatore.getIscrizioneREA().getNumeroREA());
		invoiceCedentePrestatore.setReaOffice(cedentePrestatore.getIscrizioneREA().getUfficio());
		invoiceCedentePrestatore.setShareCapital(cedentePrestatore.getIscrizioneREA().getCapitaleSociale());
		invoiceCedentePrestatore.setSocialSecurityNumber(cedentePrestatore.getDatiAnagrafici().getCodiceFiscale());
		invoiceCedentePrestatore.setSoleStakeholder(cedentePrestatore.getIscrizioneREA().getSocioUnico());
		invoiceCedentePrestatore.setStreetAddress(cedentePrestatore.getSede().getIndirizzo());
		invoiceCedentePrestatore.setTaxSystem(cedentePrestatore.getDatiAnagrafici().getRegimeFiscale());
		invoiceCedentePrestatore.setZipCode(cedentePrestatore.getSede().getCap());
		return invoiceCedentePrestatore;
	}
	
	private InvoiceParticipant buildCessionarioCommittente(@NotNull CessionarioCommittente cessionarioCommittente) {
		InvoiceParticipant invoiceParticipant = new InvoiceParticipant();
		invoiceParticipant.setCity(cessionarioCommittente.getSede().getComune());
		invoiceParticipant.setCountry(cessionarioCommittente.getSede().getNazione());
		invoiceParticipant.setDistrict(cessionarioCommittente.getSede().getProvincia());
		invoiceParticipant.setId(new CountryAndCodePrimaryKey(
				cessionarioCommittente.getDatiAnagrafici().getIdFiscaleIVA().getIdCodice()
				, cessionarioCommittente.getDatiAnagrafici().getIdFiscaleIVA().getIdPaese()));
		invoiceParticipant.setName(cessionarioCommittente.getDatiAnagrafici().getAnagrafica().getDenominazione());
		invoiceParticipant.setSocialSecurityNumber(cessionarioCommittente.getDatiAnagrafici().getCodiceFiscale());
		invoiceParticipant.setStreetAddress(cessionarioCommittente.getSede().getIndirizzo());
		invoiceParticipant.setZipCode(cessionarioCommittente.getSede().getCap());
		return invoiceParticipant;
	}
	
	private FinancialInstitution buildFinancialInstitution(DettaglioPagamento dettaglioPagamento) {
		FinancialInstitution financialInstitution = new FinancialInstitution();
		financialInstitution.setAbi(dettaglioPagamento.getABI());
		financialInstitution.setBic(dettaglioPagamento.getBIC());
		financialInstitution.setCab(dettaglioPagamento.getCAB());
		financialInstitution.setIban(dettaglioPagamento.getIBAN());
		financialInstitution.setName(dettaglioPagamento.getIstitutoFinanziario());
		return financialInstitution;
	}

}

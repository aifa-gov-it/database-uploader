package it.gov.aifa.invoice_processor.service.impl;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.invoice.CountryAndCodePrimaryKey;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceCedentePrestatore;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceParticipant;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.CedentePrestatore;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.CessionarioCommittente;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.FatturaElettronicaHeader;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.Invoice1_1;
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

}

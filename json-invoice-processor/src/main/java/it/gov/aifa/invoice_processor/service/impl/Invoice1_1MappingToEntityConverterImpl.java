package it.gov.aifa.invoice_processor.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.invoice.CountryAndCodePrimaryKey;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceCedentePrestatore;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.CedentePrestatore;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.Invoice1_1;
import it.gov.aifa.invoice_processor.service.InvoiceMappingToEntityConverter;

@Service
@Validated
public class Invoice1_1MappingToEntityConverterImpl implements InvoiceMappingToEntityConverter<Invoice1_1, Invoice> {
	
	@Override
	public Invoice convert(Invoice1_1 source) {
		Invoice invoice = new Invoice();
		invoice.setCedentePrestatore(buildCedentePrestatore(source));
		return invoice;
	}
	
	private InvoiceCedentePrestatore buildCedentePrestatore(Invoice1_1 source) {
		CedentePrestatore cedentePrestatore = source.getHttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica().getFatturaElettronicaHeader().getCedentePrestatore();
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

}

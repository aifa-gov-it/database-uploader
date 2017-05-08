package it.gov.aifa.invoice_processor.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceCedentePrestatore;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceParticipant;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.Anagrafica;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.CedentePrestatore;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.CessionarioCommittente;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.Contatti;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiAnagrafici;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiGenerali;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiGeneraliDocumento;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.FatturaElettronicaBody;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.FatturaElettronicaHeader;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.IdFiscaleIVA;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.Invoice1_1;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.IscrizioneREA;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.Sede;
import it.gov.aifa.invoice_processor.service.InvoiceMappingToEntityConverter;

public class Invoice1_1MappingToEntityConverterImplTest{

	@Test
	public void convertInvoice1_1Test() {
		Invoice1_1 source = new Invoice1_1();
		String codeId = "codeId";
		String city = "city";
		String clearanceState = "clearanceState";
		String country = "country";
		String countryId = "countryId";
		String currency = "currency";
		String district = "district";
		String name = "name";
		String phoneNumber = "phoneNumber";
		String reaNumber = "reaNumber";
		String reaOffice = "reaOffice";
		String shareCapital = "shareCapital";
		String soleStakeholder = "soleStakeholder";
		String ssn = "456";
		String streetAddress = "Route 1";
		String taxSystem = "taxSystem";
		String zipCode = "123456";
		CedentePrestatore cedentePrestatore = new CedentePrestatore(
				new DatiAnagrafici(
						new IdFiscaleIVA(countryId, codeId)
						, ssn
						, new Anagrafica(name)
						, taxSystem)
				, new Sede(streetAddress, zipCode, city, district, country)
				, new IscrizioneREA(reaOffice, reaNumber, shareCapital, soleStakeholder, clearanceState)
				, new Contatti(phoneNumber));
		CessionarioCommittente cessionarioCommittente = new CessionarioCommittente(
				new DatiAnagrafici(
						new IdFiscaleIVA(countryId, codeId)
						, ssn
						, new Anagrafica(name)
						, taxSystem)
				, new Sede(streetAddress, zipCode, city, district, country));
		
		source.setHttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica(
				new HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica(
						null
						, new FatturaElettronicaHeader(
								null
								, cedentePrestatore
								, cessionarioCommittente
								, null
								, null)
						, new FatturaElettronicaBody(
								new DatiGenerali(
										new DatiGeneraliDocumento(null, currency, null, null, null, null)
										, null
										, null
										, null)
								, null
								, null)));
		InvoiceMappingToEntityConverter<Invoice1_1, Invoice> converter = new Invoice1_1MappingToEntityConverterImpl();
		Invoice invoice = converter.convert(source);
		assertThat(invoice).isNotNull();
		InvoiceCedentePrestatore invoiceCedentePrestatore = invoice.getCedentePrestatore();
		assertThat(invoiceCedentePrestatore).isNotNull();
		assertThat(invoiceCedentePrestatore.getCity()).isEqualTo(city);
		assertThat(invoiceCedentePrestatore.getClearanceState()).isEqualTo(clearanceState);
		assertThat(invoiceCedentePrestatore.getCountry()).isEqualTo(country);
		assertThat(invoiceCedentePrestatore.getDistrict()).isEqualTo(district);
		assertThat(invoiceCedentePrestatore.getId().getCountryCode()).isEqualTo(countryId);
		assertThat(invoiceCedentePrestatore.getId().getCode()).isEqualTo(codeId);
		assertThat(invoiceCedentePrestatore.getName()).isEqualTo(name);
		assertThat(invoiceCedentePrestatore.getPhoneNumber()).isEqualTo(phoneNumber);
		assertThat(invoiceCedentePrestatore.getReaNumber()).isEqualTo(reaNumber);
		assertThat(invoiceCedentePrestatore.getReaOffice()).isEqualTo(reaOffice);
		assertThat(invoiceCedentePrestatore.getShareCapital()).isEqualTo(shareCapital);
		assertThat(invoiceCedentePrestatore.getSoleStakeholder()).isEqualTo(soleStakeholder);
		assertThat(invoiceCedentePrestatore.getStreetAddress()).isEqualTo(streetAddress);
		assertThat(invoiceCedentePrestatore.getTaxSystem()).isEqualTo(taxSystem);
		assertThat(invoiceCedentePrestatore.getZipCode()).isEqualTo(zipCode);
		
		InvoiceParticipant invoiceCessionarioCommittente = invoice.getCessionarioCommittente();
		assertThat(invoiceCessionarioCommittente).isNotNull();
		assertThat(invoiceCessionarioCommittente.getCity()).isEqualTo(city);
		assertThat(invoiceCessionarioCommittente.getCountry()).isEqualTo(country);
		assertThat(invoiceCessionarioCommittente.getDistrict()).isEqualTo(district);
		assertThat(invoiceCessionarioCommittente.getEmailAddress()).isNull();
		assertThat(invoiceCessionarioCommittente.getId().getCountryCode()).isEqualTo(countryId);
		assertThat(invoiceCessionarioCommittente.getId().getCode()).isEqualTo(codeId);
		assertThat(invoiceCessionarioCommittente.getName()).isEqualTo(name);
		assertThat(invoiceCessionarioCommittente.getPhoneNumber()).isNull();
		assertThat(invoiceCessionarioCommittente.getSocialSecurityNumber()).isEqualTo(ssn);
		assertThat(invoiceCessionarioCommittente.getStreetAddress()).isEqualTo(streetAddress);
		assertThat(invoiceCessionarioCommittente.getZipCode()).isEqualTo(zipCode);
		
		assertThat(invoice.getCurrency()).isEqualTo(currency);
	}
}

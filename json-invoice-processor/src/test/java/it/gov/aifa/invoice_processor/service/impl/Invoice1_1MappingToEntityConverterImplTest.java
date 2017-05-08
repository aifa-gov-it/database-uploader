package it.gov.aifa.invoice_processor.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.entity.invoice.FinancialInstitution;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceCedentePrestatore;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceParticipant;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceTax;
import it.gov.aifa.invoice_processor.entity.invoice.LinkedInvoice;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.Anagrafica;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.CedentePrestatore;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.CessionarioCommittente;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.Contatti;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.ContattiTrasmittente;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiAnagrafici;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiBeniServizi;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiBollo;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiFattureCollegate;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiGenerali;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiGeneraliDocumento;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiPagamento;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiRiepilogo;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiTrasmissione;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DettaglioPagamento;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.FatturaElettronicaBody;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.FatturaElettronicaHeader;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.IdFiscaleIVA;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.IdTrasmittente;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.Invoice1_1;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.IscrizioneREA;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.ScontoMaggiorazione;
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
		LocalDate date = LocalDate.now();
		List<String> description = new ArrayList<>();
		description.add("First line ");
		description.add("Second line.");
		String discountAmount = "2.00";
		String discountType = "discountType";
		String district = "district";
		String documentTypeCode = "documentTypeCode";
		String invoiceRecipientCode = "invoiceRecipientCode";
		String invoiceSenderCode = "invoiceSenderCode";
		String invoiceSenderCountryCode = "invoiceSenderCountryCode";
		String invoiceSenderEmailAddress = "invoiceSenderEmailAddress";
		String invoiceSendingFormat = "invoiceSendingFormat";
		String invoiceSendingNumber = "invoiceSendingNumber";
		String name = "name";
		String phoneNumber = "phoneNumber";
		String reaNumber = "reaNumber";
		String reaOffice = "reaOffice";
		String shareCapital = "shareCapital";
		String soleStakeholder = "soleStakeholder";
		String ssn = "456";
		String stampAmount = "2.00";
		String streetAddress = "Route 1";
		String taxSystem = "taxSystem";
		String virtualStamp = "SI";
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
		List<DatiFattureCollegate> datiFattureCollegate = new ArrayList<>();
		datiFattureCollegate.add(new DatiFattureCollegate("id", "2017-05-08"));
		
		source.setHttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica(
				new HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica(
						"1.1"
						, new FatturaElettronicaHeader(
								new DatiTrasmissione(
										new IdTrasmittente(invoiceSenderCountryCode, invoiceSenderCode)
										, invoiceSendingNumber
										, invoiceSendingFormat
										, invoiceRecipientCode
										, new ContattiTrasmittente(invoiceSenderEmailAddress))
								, cedentePrestatore
								, cessionarioCommittente
								, null
								, null)
						, new FatturaElettronicaBody(
								new DatiGenerali(
										new DatiGeneraliDocumento(
												documentTypeCode
												, currency
												, date.toString()
												, "number"
												, "123.456"
												, new DatiBollo(virtualStamp, stampAmount)
												, new ScontoMaggiorazione(discountType, discountAmount)
												, description)
										, null
										, datiFattureCollegate
										, null)
								, new DatiBeniServizi(null, new DatiRiepilogo("10.0", null, null, null, "lawReference"))
								, new DatiPagamento(
										null
										, new DettaglioPagamento(
												"paymentMode"
												, "10"
												, "2017-05-08"
												, "123.456"
												, "financialInstitutionName"
												, "financialInstitutionIban"
												, "financialInstitutionAbi"
												, "financialInstitutionCab"
												, "financialInstitutionBic")))));
		InvoiceMappingToEntityConverter<Invoice1_1, Invoice> converter = new Invoice1_1MappingToEntityConverterImpl();
		Invoice invoice = converter.convert(source);
		assertThat(invoice).isNotNull();
		
		HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica fatturaElettronica = source.getHttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica();
		FatturaElettronicaBody fatturaElettronicaBody = fatturaElettronica.getFatturaElettronicaBody();
		
		DatiGenerali datiGenerali = fatturaElettronicaBody.getDatiGenerali();
		DatiGeneraliDocumento datiGeneraliDocumento = datiGenerali.getDatiGeneraliDocumento();
		
		DatiPagamento datiPagamento = fatturaElettronicaBody.getDatiPagamento();
		DettaglioPagamento dettaglioPagamento = datiPagamento.getDettaglioPagamento();
		
		DatiBeniServizi datiBeniServizi = fatturaElettronicaBody.getDatiBeniServizi();
		DatiRiepilogo datiRiepilogo = datiBeniServizi.getDatiRiepilogo();
		
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
		assertThat(invoice.getDate()).isEqualTo(date);
		assertThat(invoice.getDescription()).isEqualTo(String.join("", description));
		assertThat(invoice.getDiscountAmount()).isEqualTo(Double.parseDouble(discountAmount));
		assertThat(invoice.getDiscountType()).isEqualTo(discountType);
		assertThat(invoice.getDocumentTypeCode()).isEqualTo(documentTypeCode);
		
		FinancialInstitution financialInstitution = invoice.getFinancialInstitution();
		assertThat(financialInstitution).isNotNull();
		assertThat(financialInstitution.getAbi()).isEqualTo(dettaglioPagamento.getABI());
		assertThat(financialInstitution.getBic()).isEqualTo(dettaglioPagamento.getBIC());
		assertThat(financialInstitution.getCab()).isEqualTo(dettaglioPagamento.getCAB());
		assertThat(financialInstitution.getIban()).isEqualTo(dettaglioPagamento.getIBAN());
		assertThat(financialInstitution.getName()).isEqualTo(dettaglioPagamento.getIstitutoFinanziario());
		
		assertThat(invoice.getStampAmount()).isEqualTo(Double.parseDouble(stampAmount));
		assertThat(invoice.getVirtualStamp()).isEqualTo(true);
		
		assertThat(invoice.getInvoiceRecipientCode()).isEqualTo(invoiceRecipientCode);
		assertThat(invoice.getInvoiceSenderCode()).isEqualTo(invoiceSenderCode);
		assertThat(invoice.getInvoiceSenderCountryCode()).isEqualTo(invoiceSenderCountryCode);
		assertThat(invoice.getInvoiceSenderEmailAddress()).isEqualTo(invoiceSenderEmailAddress);
		assertThat(invoice.getInvoiceSendingFormat()).isEqualTo(invoiceSendingFormat);
		assertThat(invoice.getInvoiceSendingNumber()).isEqualTo(invoiceSendingNumber);
		
		InvoiceTax invoiceTax = invoice.getInvoiceTax();
		assertThat(invoiceTax).isNotNull();
		assertThat(invoiceTax.getLawReference()).isEqualTo(datiRiepilogo.getRiferimentoNormativo());
		assertThat(invoiceTax.getRate()).isEqualTo(Double.parseDouble(datiRiepilogo.getAliquotaIVA()));
		
		assertThat(invoice.getInvoiceVersion()).isNotNull();
		assertThat(invoice.getInvoiceVersion().getVersion()).isEqualTo(fatturaElettronica.getVersione());
		
		assertThat(invoice.getNumber()).isEqualTo(datiGeneraliDocumento.getNumero());
		
		assertThat(invoice.getLinkedInvoices()).isNotEmpty();
		assertThat(invoice.getLinkedInvoices()).hasSize(datiFattureCollegate.size());
		for(LinkedInvoice linkedInvoice : invoice.getLinkedInvoices()) {
			assertThat(linkedInvoice.getId().getId()).isEqualTo(datiFattureCollegate.get(0).getIdDocumento());
			assertThat(linkedInvoice.getId().getDate().toString()).isEqualTo(datiFattureCollegate.get(0).getData());
			assertThat(linkedInvoice.getId().getInvoiceId()).isEqualTo(invoice.getNumber());
			assertThat(linkedInvoice.getInvoice()).isSameAs(invoice);
		}
		
		assertThat(invoice.getPaymentAmount()).isEqualTo(Double.parseDouble(datiGeneraliDocumento.getImportoTotaleDocumento()));
		assertThat(invoice.getPaymentConditions()).isEqualTo(datiPagamento.getCondizioniPagamento());
		assertThat(invoice.getPaymentExpirationDate().toString()).isEqualTo(dettaglioPagamento.getDataScadenzaPagamento());
		assertThat(invoice.getPaymentMode()).isEqualTo(dettaglioPagamento.getModalitaPagamento());
		assertThat(Integer.toString(invoice.getPaymentTermDays())).isEqualTo(dettaglioPagamento.getGiorniTerminiPagamento());
	}
}

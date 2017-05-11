package it.gov.aifa.invoice_processor.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.invoice.FinancialInstitution;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceCedentePrestatore;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceParticipant;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceVersion;
import it.gov.aifa.invoice_processor.entity.invoice.LinkedInvoice;
import it.gov.aifa.invoice_processor.entity.invoice.LinkedInvoicePrimaryKey;
import it.gov.aifa.invoice_processor.entity.invoice.PurchaseLine;
import it.gov.aifa.invoice_processor.entity.invoice.IdAndInvoiceIdPrimaryKey;
import it.gov.aifa.invoice_processor.entity.invoice.PurchaseOrder;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.Anagrafica;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.CedentePrestatore;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.CessionarioCommittente;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.Contatti;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiAnagrafici;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiBeniServizi;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiBollo;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiDDT;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiFattureCollegate;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiGenerali;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiGeneraliDocumento;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiOrdineAcquisto;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiPagamento;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiRiepilogo;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiTrasmissione;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DettaglioLinee;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DettaglioPagamento;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.FatturaElettronicaBody;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.FatturaElettronicaHeader;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.IdFiscaleIVA;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.Invoice1_1;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.IscrizioneREA;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.ScontoMaggiorazione;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.Sede;
import it.gov.aifa.invoice_processor.service.InvoiceMappingToEntityConverter;

@Service
@Validated
public class Invoice1_1MappingToEntityConverterImpl implements InvoiceMappingToEntityConverter<Invoice1_1, Invoice> {

	private DateTimeFormatter dateTimeFormatter;

	public Invoice1_1MappingToEntityConverterImpl() {
		dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
		dateTimeFormatter = dateTimeFormatter.withLocale(Locale.ITALIAN);
	}

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

		invoice.setDate(LocalDate.parse(datiGeneraliDocumento.getData(), dateTimeFormatter));

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

		DatiBeniServizi datiBeniServizi = body.getDatiBeniServizi();
		DatiRiepilogo datiRiepilogo = datiBeniServizi.getDatiRiepilogo();
		invoice.setTaxLawReference(datiRiepilogo.getRiferimentoNormativo());
		invoice.setTaxRate(Double.parseDouble(datiRiepilogo.getAliquotaIVA()));

		invoice.setInvoiceVersion(buildInvoiceVersion(fatturaElettronica.getVersione()));

		invoice.setNumber(datiGeneraliDocumento.getNumero());

		List<DatiFattureCollegate> datiFattureCollegate = datiGenerali.getDatiFattureCollegate();
		if(datiFattureCollegate != null)
			invoice.setLinkedInvoices(buildLinkedInvoices(datiFattureCollegate, invoice));

		invoice.setPaymentAmount(Double.parseDouble(dettaglioPagamento.getImportoPagamento()));
		invoice.setPaymentConditions(datiPagamento.getCondizioniPagamento());
		invoice.setPaymentExpirationDate(LocalDate.parse(dettaglioPagamento.getDataScadenzaPagamento(), dateTimeFormatter));
		invoice.setPaymentMode(dettaglioPagamento.getModalitaPagamento());
		invoice.setPaymentTermDays(Integer.parseInt(dettaglioPagamento.getGiorniTerminiPagamento()));
		
		if(datiBeniServizi.getDettaglioLinee() != null)
			invoice.setPurchaseLines(buildPurchaseLines(datiBeniServizi.getDettaglioLinee(), invoice));
		
		if(datiGenerali.getDatiOrdineAcquisto() != null)
			invoice.setPurchaseOrders(buildPurchaseOrders(datiGenerali.getDatiOrdineAcquisto(), invoice));
		
		invoice.setSoggettoEmittente(header.getSoggettoEmittente());
		invoice.setSoggettoEmittenteName(header.getTerzoIntermediarioOSoggettoEmittente().getDatiAnagrafici().getAnagrafica().getDenominazione());
		invoice.setTaxableAmount(Double.parseDouble(datiRiepilogo.getImponibileImporto()));
		invoice.setTaxDue(datiRiepilogo.getEsigibilitaIVA());
		invoice.setTotalAmount(Double.parseDouble(datiGeneraliDocumento.getImportoTotaleDocumento()));
		
		DatiDDT datiDDT = datiGenerali.getDatiDDT();
		invoice.setTransportDocumentDate(LocalDate.parse(datiDDT.getDataDDT(), dateTimeFormatter));
		invoice.setTransportDocumentId(datiDDT.getNumeroDDT());

		return invoice;
	}
	
	private Set<PurchaseOrder> buildPurchaseOrders(List<DatiOrdineAcquisto> datiOrdiniAcquisto, Invoice parentInvoice) {
		Set<PurchaseOrder> purchaseOrders = new HashSet<>(datiOrdiniAcquisto.size());
		for(DatiOrdineAcquisto datiOrdineAcquisto : datiOrdiniAcquisto) {
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCigCode(datiOrdineAcquisto.getCodiceCIG());
			purchaseOrder.setDate(LocalDate.parse(datiOrdineAcquisto.getData(), dateTimeFormatter));
			purchaseOrder.setDocumentId(datiOrdineAcquisto.getIdDocumento());
			purchaseOrder.setInvoice(parentInvoice);
			List<PurchaseLine> relatedPurchaseLines = parentInvoice.getPurchaseLines().stream()
					.filter(c -> c.getId().getInvoiceId().equals(parentInvoice.getNumber())
							&& c.getId().getId().equals(datiOrdineAcquisto.getRiferimentoNumeroLinea()))
					.collect(Collectors.toList());
			if(relatedPurchaseLines != null) {
				if(relatedPurchaseLines.size() > 1)
					throw new RuntimeException("Search returned more than one related purchase line for the same purchase order");
				if(!relatedPurchaseLines.isEmpty()) {
					if(purchaseOrder.getPurchaseLine() == null)
						purchaseOrder.setPurchaseLine(relatedPurchaseLines.get(0));
					else if(purchaseOrder.getPurchaseLine() != null
							&& !purchaseOrder.getPurchaseLine().equals(relatedPurchaseLines.get(0)))
						throw new RuntimeException("Cannot set two different purchase lines for the same purchase order");
				}
			}
			
			purchaseOrders.add(purchaseOrder);
		}
		return purchaseOrders;
	}

	private Set<PurchaseLine> buildPurchaseLines(List<DettaglioLinee> dettaglioLinee, Invoice parentInvoice) {
		Set<PurchaseLine> purchaseLines = new HashSet<>(dettaglioLinee.size());
		for(DettaglioLinee dettaglioLinea : dettaglioLinee) {
			PurchaseLine purchaseLine = new PurchaseLine();
			purchaseLine.setId(new IdAndInvoiceIdPrimaryKey(parentInvoice.getNumber(), dettaglioLinea.getNumeroLinea()));
			purchaseLine.setInvoice(parentInvoice);
			purchaseLine.setItemCode(dettaglioLinea.getCodiceArticolo().getCodiceValore());
			purchaseLine.setItemCodeType(dettaglioLinea.getCodiceArticolo().getCodiceTipo());
			purchaseLine.setItemDescription(dettaglioLinea.getDescrizione());
			purchaseLine.setQuantity(Double.parseDouble(dettaglioLinea.getQuantita()));
			purchaseLine.setTaxRate(Double.parseDouble(dettaglioLinea.getAliquotaIVA()));
			purchaseLine.setTotalPrice(Double.parseDouble(dettaglioLinea.getPrezzoTotale()));
			purchaseLine.setUnitOfMeasureDescription(dettaglioLinea.getUnitaMisura());
			purchaseLine.setUnitPrice(Double.parseDouble(dettaglioLinea.getPrezzoUnitario()));
			purchaseLines.add(purchaseLine);
		}
		return purchaseLines;
	}

	// This method has something in common with buildCessionarioCommittente.
	// It's necessary because the automatically generated CedentePrestatore 
	// and CessionarioCommittente classes don't have any relation.
	// If there was a common superclass it would be trivially easy to avoid
	// repetitions. Also I prefer not to edit the automatically generated classes
	// too much.
	private InvoiceCedentePrestatore buildCedentePrestatore(@NotNull CedentePrestatore cedentePrestatore) {
		InvoiceCedentePrestatore invoiceCedentePrestatore = new InvoiceCedentePrestatore();
		
		Sede office = cedentePrestatore.getSede();
		if(office != null) {
			invoiceCedentePrestatore.setCity(office.getComune());
			invoiceCedentePrestatore.setCountry(office.getNazione());
			invoiceCedentePrestatore.setDistrict(office.getProvincia());
			invoiceCedentePrestatore.setStreetAddress(office.getIndirizzo());
			invoiceCedentePrestatore.setZipCode(office.getCap());
		}
		
		IscrizioneREA reaRegistration = cedentePrestatore.getIscrizioneREA();
		if(reaRegistration != null) {
			invoiceCedentePrestatore.setClearanceState(reaRegistration.getStatoLiquidazione());
			invoiceCedentePrestatore.setReaNumber(reaRegistration.getNumeroREA());
			invoiceCedentePrestatore.setReaOffice(reaRegistration.getUfficio());
			invoiceCedentePrestatore.setShareCapital(reaRegistration.getCapitaleSociale());
			invoiceCedentePrestatore.setSoleStakeholder(reaRegistration.getSocioUnico());
		}
		
		DatiAnagrafici biographicalData = cedentePrestatore.getDatiAnagrafici();
		if(biographicalData != null) {
			String ssn = biographicalData.getCodiceFiscale();
			if(StringUtils.isBlank(ssn))
				throw new RuntimeException("Error while converting CedentePrestatore instance to InvoiceCedentePrestatore: ID (ssn) is null");
			invoiceCedentePrestatore.setSocialSecurityNumber(biographicalData.getCodiceFiscale());
			Anagrafica biographicalDataDetails = biographicalData.getAnagrafica();
			if(biographicalDataDetails != null)
				invoiceCedentePrestatore.setName(biographicalDataDetails.getDenominazione());
			IdFiscaleIVA taxId = biographicalData.getIdFiscaleIVA();
			if(taxId != null) {
				invoiceCedentePrestatore.setTaxCode(taxId.getIdCodice());
				invoiceCedentePrestatore.setTaxCountryCode(taxId.getIdPaese());
			}
			invoiceCedentePrestatore.setTaxSystem(biographicalData.getRegimeFiscale());
		}
		
		invoiceCedentePrestatore.setEmailAddress(null);
		
		Contatti contacts = cedentePrestatore.getContatti();
		if(contacts != null)
			invoiceCedentePrestatore.setPhoneNumber(contacts.getTelefono());
		
		return invoiceCedentePrestatore;
	}
	
	private InvoiceParticipant buildCessionarioCommittente(@NotNull CessionarioCommittente cessionarioCommittente) {
		InvoiceParticipant invoiceParticipant = new InvoiceParticipant();
		
		Sede office = cessionarioCommittente.getSede();
		if(office != null) {
			invoiceParticipant.setCity(office.getComune());
			invoiceParticipant.setCountry(office.getNazione());
			invoiceParticipant.setDistrict(office.getProvincia());
			invoiceParticipant.setStreetAddress(office.getIndirizzo());
			invoiceParticipant.setZipCode(office.getCap());
		}
		
		DatiAnagrafici biographicalData = cessionarioCommittente.getDatiAnagrafici();
		if(biographicalData != null) {
			String ssn = biographicalData.getCodiceFiscale();
			if(StringUtils.isBlank(ssn))
				throw new RuntimeException("Error while converting CedentePrestatore instance to InvoiceCedentePrestatore: ID (ssn) is null");
			invoiceParticipant.setSocialSecurityNumber(biographicalData.getCodiceFiscale());
			Anagrafica biographicalDataDetails = biographicalData.getAnagrafica();
			if(biographicalDataDetails != null)
				invoiceParticipant.setName(biographicalDataDetails.getDenominazione());
			IdFiscaleIVA taxId = biographicalData.getIdFiscaleIVA();
			if(taxId != null) {
				invoiceParticipant.setTaxCode(taxId.getIdCodice());
				invoiceParticipant.setTaxCountryCode(taxId.getIdPaese());
			}
		}
		
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

	private InvoiceVersion buildInvoiceVersion(String versione) {
		return new InvoiceVersion(versione, null, null);
	}

	private Set<LinkedInvoice> buildLinkedInvoices(List<DatiFattureCollegate> datiFattureCollegate, Invoice parentInvoice) {
		Set<LinkedInvoice> linkedInvoices = new HashSet<>(datiFattureCollegate.size());
		for(DatiFattureCollegate fatturaCollegata : datiFattureCollegate) {
			LinkedInvoice linkedInvoice = new LinkedInvoice();
			linkedInvoice.setId(new LinkedInvoicePrimaryKey(LocalDate.parse(fatturaCollegata.getData(), dateTimeFormatter), fatturaCollegata.getIdDocumento(), parentInvoice.getNumber()));
			linkedInvoice.setInvoice(parentInvoice);
			linkedInvoices.add(linkedInvoice);
		}
		return linkedInvoices;
	}

}

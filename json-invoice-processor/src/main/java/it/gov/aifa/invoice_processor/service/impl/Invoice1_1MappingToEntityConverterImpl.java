package it.gov.aifa.invoice_processor.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.invoice.CountryAndCodePrimaryKey;
import it.gov.aifa.invoice_processor.entity.invoice.DocumentIdDatePrimaryKey;
import it.gov.aifa.invoice_processor.entity.invoice.FinancialInstitution;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceCedentePrestatore;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceItem;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceParticipant;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceTax;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceVersion;
import it.gov.aifa.invoice_processor.entity.invoice.LinkedInvoice;
import it.gov.aifa.invoice_processor.entity.invoice.PurchaseLine;
import it.gov.aifa.invoice_processor.entity.invoice.PurchaseLinePrimaryKey;
import it.gov.aifa.invoice_processor.entity.invoice.PurchaseOrder;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.CedentePrestatore;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.CessionarioCommittente;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiBeniServizi;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.DatiBollo;
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
import it.gov.aifa.invoice_processor.mapping.invoice1_1.Invoice1_1;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.ScontoMaggiorazione;
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
		invoice.setInvoiceTax(buildInvoiceTax(datiRiepilogo));

		invoice.setInvoiceVersion(buildInvoiceVersion(fatturaElettronica.getVersione()));

		invoice.setNumber(datiGeneraliDocumento.getNumero());

		List<DatiFattureCollegate> datiFattureCollegate = datiGenerali.getDatiFattureCollegate();
		invoice.setLinkedInvoices(buildLinkedInvoices(datiFattureCollegate, invoice));

		invoice.setPaymentAmount(Double.parseDouble(datiGeneraliDocumento.getImportoTotaleDocumento()));
		invoice.setPaymentConditions(datiPagamento.getCondizioniPagamento());
		invoice.setPaymentExpirationDate(LocalDate.parse(dettaglioPagamento.getDataScadenzaPagamento(), dateTimeFormatter));
		invoice.setPaymentMode(dettaglioPagamento.getModalitaPagamento());
		invoice.setPaymentTermDays(Integer.parseInt(dettaglioPagamento.getGiorniTerminiPagamento()));

		invoice.setPurchaseLines(buildPurchaseLines(datiBeniServizi.getDettaglioLinee(), invoice));

		invoice.setPurchaseOrders(buildPurchaseOrders(datiGenerali.getDatiOrdineAcquisto(), invoice));

		return invoice;
	}

	private Set<PurchaseOrder> buildPurchaseOrders(List<DatiOrdineAcquisto> datiOrdiniAcquisto, Invoice parentInvoice) {
		Set<PurchaseOrder> purchaseOrders = new HashSet<>(datiOrdiniAcquisto.size());
		for(DatiOrdineAcquisto datiOrdineAcquisto : datiOrdiniAcquisto) {
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setCigCode(datiOrdineAcquisto.getCodiceCIG());
			purchaseOrder.setId(new DocumentIdDatePrimaryKey(
					LocalDate.parse(datiOrdineAcquisto.getData(), dateTimeFormatter)
					, datiOrdineAcquisto.getIdDocumento()
					, parentInvoice.getNumber()));
			purchaseOrder.setInvoice(parentInvoice);
			List<PurchaseLine> relatedPurchaseLines = parentInvoice.getPurchaseLines().stream()
					.filter(c -> c.getId().getInvoiceId().equals(parentInvoice.getNumber()))
					.filter(c -> c.getId().getNumber().equals(datiOrdineAcquisto.getRiferimentoNumeroLinea()))
					.collect(Collectors.toList());
			if(relatedPurchaseLines != null) {
				if(relatedPurchaseLines.size() > 1)
					throw new RuntimeException("Search returned more than one related purchase line");
				if(!relatedPurchaseLines.isEmpty())
					purchaseOrder.setPurchaseLine(relatedPurchaseLines.get(0));
			}
			
			purchaseOrders.add(purchaseOrder);
		}
		return purchaseOrders;
	}

	private Set<PurchaseLine> buildPurchaseLines(List<DettaglioLinee> dettaglioLinee, Invoice parentInvoice) {
		Set<PurchaseLine> purchaseLines = new HashSet<>(dettaglioLinee.size());
		for(DettaglioLinee dettaglioLinea : dettaglioLinee) {
			PurchaseLine purchaseLine = new PurchaseLine();
			purchaseLine.setId(new PurchaseLinePrimaryKey(parentInvoice.getNumber(), dettaglioLinea.getNumeroLinea()));
			purchaseLine.setInvoice(parentInvoice);
			InvoiceItem invoiceItem = new InvoiceItem();
			invoiceItem.setCode(dettaglioLinea.getCodiceArticolo().getCodiceValore());
			invoiceItem.setCodeType(dettaglioLinea.getCodiceArticolo().getCodiceTipo());
			invoiceItem.setDescription(dettaglioLinea.getDescrizione());
			purchaseLine.setItem(invoiceItem);
			purchaseLine.setQuantity(Double.parseDouble(dettaglioLinea.getQuantita()));
			InvoiceTax invoiceTax = new InvoiceTax();
			invoiceTax.setRate(Double.parseDouble(dettaglioLinea.getAliquotaIVA()));
			purchaseLine.setTax(invoiceTax);
			purchaseLine.setTotalPrice(Double.parseDouble(dettaglioLinea.getPrezzoTotale()));
			purchaseLine.setUnitOfMeasureDescription(dettaglioLinea.getUnitaMisura());
			purchaseLine.setUnitPrice(Double.parseDouble(dettaglioLinea.getPrezzoUnitario()));
			purchaseLines.add(purchaseLine);
		}
		return purchaseLines;
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

	private InvoiceTax buildInvoiceTax(DatiRiepilogo datiRiepilogo) {
		InvoiceTax invoiceTax = new InvoiceTax();
		invoiceTax.setLawReference(datiRiepilogo.getRiferimentoNormativo());
		invoiceTax.setRate(Double.parseDouble(datiRiepilogo.getAliquotaIVA()));
		return invoiceTax;
	}

	private InvoiceVersion buildInvoiceVersion(String versione) {
		return new InvoiceVersion(versione, null, null);
	}

	private Set<LinkedInvoice> buildLinkedInvoices(List<DatiFattureCollegate> datiFattureCollegate, Invoice parentInvoice) {
		Set<LinkedInvoice> linkedInvoices = new HashSet<>(datiFattureCollegate.size());
		for(DatiFattureCollegate fatturaCollegata : datiFattureCollegate) {
			LinkedInvoice linkedInvoice = new LinkedInvoice();
			linkedInvoice.setId(new DocumentIdDatePrimaryKey(LocalDate.parse(fatturaCollegata.getData(), dateTimeFormatter), fatturaCollegata.getIdDocumento(), parentInvoice.getNumber()));
			linkedInvoice.setInvoice(parentInvoice);
			linkedInvoices.add(linkedInvoice);
		}
		return linkedInvoices;
	}

}

package it.gov.aifa.invoice_processor.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.invoice.Attachment;
import it.gov.aifa.invoice_processor.entity.invoice.DatiRiepilogo;
import it.gov.aifa.invoice_processor.entity.invoice.DocumentoCorrelato;
import it.gov.aifa.invoice_processor.entity.invoice.FinancialInstitution;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceCedentePrestatore;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceParticipant;
import it.gov.aifa.invoice_processor.entity.invoice.PurchaseLine;
import it.gov.aifa.invoice_processor.entity.invoice.Vettore;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.AllegatiType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.AltriDatiGestionaliType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.AnagraficaType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.CedentePrestatoreType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.CessionarioCommittenteType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.CodiceArticoloType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.ContattiType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiAnagraficiCedenteType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiAnagraficiCessionarioType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiBeniServiziType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiBolloType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiCassaPrevidenzialeType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiDDTType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiDocumentiCorrelatiType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiGeneraliDocumentoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiGeneraliType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiPagamentoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiRiepilogoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiSALType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiTrasmissioneType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiTrasportoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiVeicoliType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DettaglioLineeType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DettaglioPagamentoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.FatturaElettronicaBodyType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.FatturaElettronicaHeaderType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.FatturaElettronicaType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.IdFiscaleType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.IndirizzoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.IscrizioneREAType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.RappresentanteFiscaleCessionarioType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.RappresentanteFiscaleType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.ScontoMaggiorazioneType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.SoggettoEmittenteType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.TerzoIntermediarioSoggettoEmittenteType;

@Service
@Validated
public class Invoice1_2MappingToEntityConverterImpl extends AbstractInvoiceMappingToEntityConverter<FatturaElettronicaType, Invoice> {

	@Override
	protected void buildAttachments(
			@NotNull List<AllegatiType> allegati
			, @NotNull Invoice invoice) {
		if(allegati != null && !allegati.isEmpty()) {
			List<Attachment> attachments = new ArrayList<>(allegati.size());
			for(AllegatiType allegatiType : allegati) {
				Attachment attachment = new Attachment();
				attachment.setCompressionAlgorithm(allegatiType.getAlgoritmoCompressione());
				attachment.setData(allegatiType.getAttachment());
				attachment.setDescription(allegatiType.getDescrizioneAttachment());
				attachment.setFormat(allegatiType.getFormatoAttachment());
				attachment.setInvoice(invoice);
				attachment.setName(allegatiType.getNomeAttachment());
				attachments.add(attachment);
			}
			invoice.setAttachments(attachments);
		}
	}

	@Override
	protected void buildCedentePrestatore(
			@NotNull CedentePrestatoreType cedentePrestatore
			, @NotNull Invoice invoice) {
		InvoiceCedentePrestatore invoiceCedentePrestatore = new InvoiceCedentePrestatore();

		ContattiType contacts = cedentePrestatore.getContatti();
		if(contacts != null) {
			invoiceCedentePrestatore.setEmailAddress(contacts.getEmail());
			invoiceCedentePrestatore.setFaxNumber(contacts.getFax());
			invoiceCedentePrestatore.setPhoneNumber(contacts.getTelefono());
		}

		DatiAnagraficiCedenteType biographicalData = cedentePrestatore.getDatiAnagrafici();
		if(biographicalData != null) {
			mapAnagraficaTypeToInvoiceParticipant(biographicalData.getAnagrafica(), invoiceCedentePrestatore);
			mapCodiceFiscaleToInvoiceParticipant(biographicalData.getCodiceFiscale(), invoiceCedentePrestatore);
			mapIdFiscaleTypeToInvoiceParticipant(biographicalData.getIdFiscaleIVA(), invoiceCedentePrestatore);
			invoiceCedentePrestatore.setProfessionalRegister(biographicalData.getAlboProfessionale());
			invoiceCedentePrestatore.setProfessionalRegisterNumber(biographicalData.getNumeroIscrizioneAlbo());
			invoiceCedentePrestatore.setProfessionalRegisterDistrict(biographicalData.getProvinciaAlbo());
			invoiceCedentePrestatore.setProfessionalRegisterSubscriptionDate(xmlGregorianCalendarToLocalDate(biographicalData.getDataIscrizioneAlbo()));

			invoiceCedentePrestatore.setTaxSystem(biographicalData.getRegimeFiscale().toString());
		}

		IscrizioneREAType reaRegistration = cedentePrestatore.getIscrizioneREA();
		if(reaRegistration != null) {
			invoiceCedentePrestatore.setShareCapital(reaRegistration.getCapitaleSociale());
			invoiceCedentePrestatore.setReaNumber(reaRegistration.getNumeroREA());
			invoiceCedentePrestatore.setSoleStakeholder(reaRegistration.getSocioUnico().toString());
			invoiceCedentePrestatore.setClearanceState(reaRegistration.getStatoLiquidazione().toString());
			invoiceCedentePrestatore.setReaOffice(reaRegistration.getUfficio());
		}

		invoiceCedentePrestatore.setAdministrativeReference(cedentePrestatore.getRiferimentoAmministrazione());

		mapIndirizzoTypeToInvoiceParticipant(cedentePrestatore.getSede(), invoiceCedentePrestatore);

		IndirizzoType stabileOrganizzazione = cedentePrestatore.getStabileOrganizzazione();
		if(stabileOrganizzazione != null) {
			invoiceCedentePrestatore.setPermanentEstablishmentZipCode(stabileOrganizzazione.getCAP());
			invoiceCedentePrestatore.setPermanentEstablishmentCity(stabileOrganizzazione.getComune());
			invoiceCedentePrestatore.setPermanentEstablishmentStreetAddress(stabileOrganizzazione.getIndirizzo());
			invoiceCedentePrestatore.setPermanentEstablishmentCountry(stabileOrganizzazione.getNazione());
			invoiceCedentePrestatore.setPermanentEstablishmentHouseNumber(stabileOrganizzazione.getNumeroCivico());
			invoiceCedentePrestatore.setPermanentEstablishmentDistrict(stabileOrganizzazione.getProvincia());
		}

		invoice.setCedentePrestatore(invoiceCedentePrestatore);
	}

	@Override
	protected void buildCessionarioCommittente(
			@NotNull CessionarioCommittenteType cessionarioCommittente
			, @NotNull Invoice invoice
			) {
		InvoiceParticipant invoiceCessionarioCommittente = new InvoiceParticipant();

		DatiAnagraficiCessionarioType biographicalData = cessionarioCommittente.getDatiAnagrafici();
		if(biographicalData != null) {
			mapAnagraficaTypeToInvoiceParticipant(biographicalData.getAnagrafica(), invoiceCessionarioCommittente);
			mapCodiceFiscaleToInvoiceParticipant(biographicalData.getCodiceFiscale(), invoiceCessionarioCommittente);
			mapIdFiscaleTypeToInvoiceParticipant(biographicalData.getIdFiscaleIVA(), invoiceCessionarioCommittente);
		}

		RappresentanteFiscaleCessionarioType rappresentanteFiscaleCessionarioType = cessionarioCommittente.getRappresentanteFiscale();
		invoiceCessionarioCommittente.setTaxRepresentativeCountryId(rappresentanteFiscaleCessionarioType.getIdFiscaleIVA().getIdPaese());
		invoiceCessionarioCommittente.setTaxRepresentativeFirstName(rappresentanteFiscaleCessionarioType.getNome());
		invoiceCessionarioCommittente.setTaxRepresentativeIdCode(rappresentanteFiscaleCessionarioType.getIdFiscaleIVA().getIdCodice());
		invoiceCessionarioCommittente.setTaxRepresentativeLastName(rappresentanteFiscaleCessionarioType.getCognome());
		invoiceCessionarioCommittente.setTaxRepresentativeName(rappresentanteFiscaleCessionarioType.getDenominazione());

		mapIndirizzoTypeToInvoiceParticipant(cessionarioCommittente.getSede(), invoiceCessionarioCommittente);

		IndirizzoType stabileOrganizzazioneType = cessionarioCommittente.getStabileOrganizzazione();
		if(stabileOrganizzazioneType != null) {
			invoiceCessionarioCommittente.setPermanentEstablishmentCity(stabileOrganizzazioneType.getComune());
			invoiceCessionarioCommittente.setPermanentEstablishmentCountry(stabileOrganizzazioneType.getNazione());
			invoiceCessionarioCommittente.setPermanentEstablishmentDistrict(stabileOrganizzazioneType.getProvincia());
			invoiceCessionarioCommittente.setPermanentEstablishmentHouseNumber(stabileOrganizzazioneType.getNumeroCivico());
			invoiceCessionarioCommittente.setPermanentEstablishmentStreetAddress(stabileOrganizzazioneType.getIndirizzo());
			invoiceCessionarioCommittente.setPermanentEstablishmentZipCode(stabileOrganizzazioneType.getCAP());
		}

		invoice.setCessionarioCommittente(invoiceCessionarioCommittente);
	}

	@Override
	protected void buildDatiGenerali(DatiGeneraliType datiGenerali, Invoice invoice) {
		List<DatiDDTType> datiDDTTypes = datiGenerali.getDatiDDT();
		if(datiDDTTypes != null) {
			Set<DocumentoCorrelato> invoiceDatiDdt = new HashSet<>(datiDDTTypes.size());
			for(DatiDDTType datiDDTType : datiDDTTypes) {
				DocumentoCorrelato documentoCorrelato = new DocumentoCorrelato(
						xmlGregorianCalendarToLocalDate(datiDDTType.getDataDDT())
						, datiDDTType.getNumeroDDT()
						, invoice
						, getRelatedPurchaseLines(invoice, datiDDTType.getRiferimentoNumeroLinea()));
				invoiceDatiDdt.add(documentoCorrelato);
			}
			invoice.setDatiDdt(invoiceDatiDdt);
		}
		
		invoice.setDatiContratto(buildDocumentiCorrelati(datiGenerali.getDatiContratto(), invoice));
		invoice.setDatiConvenzione(buildDocumentiCorrelati(datiGenerali.getDatiConvenzione(), invoice));
		invoice.setLinkedInvoices(buildDocumentiCorrelati(datiGenerali.getDatiFattureCollegate(), invoice));
		invoice.setPurchaseOrders(buildDocumentiCorrelati(datiGenerali.getDatiOrdineAcquisto(), invoice));
		invoice.setDatiRicezione(buildDocumentiCorrelati(datiGenerali.getDatiRicezione(), invoice));

		if(datiGenerali.getDatiSAL() != null) {
			checkSingleElementCollection(datiGenerali.getDatiSAL(), DatiSALType.class);
			invoice.setRiferimentoFase(datiGenerali.getDatiSAL().get(0).getRiferimentoFase());
		}

		DatiTrasportoType datiTrasportoType = datiGenerali.getDatiTrasporto();
		if(datiTrasportoType != null) {
			invoice.setCausaleTrasporto(datiTrasportoType.getCausaleTrasporto());
			invoice.setDataInizioTrasporto(xmlGregorianCalendarToLocalDate(datiTrasportoType.getDataInizioTrasporto()));
			invoice.setDataOraConsegna(xmlGregorianCalendarToLocalDate(datiTrasportoType.getDataOraConsegna()));
			invoice.setDataOraRitiro(xmlGregorianCalendarToLocalDate(datiTrasportoType.getDataOraRitiro()));

			if(datiTrasportoType.getDatiAnagraficiVettore() != null) {
				Vettore vettore = new Vettore();
				mapAnagraficaTypeToInvoiceParticipant(datiTrasportoType.getDatiAnagraficiVettore().getAnagrafica(), vettore);
				vettore.setSocialSecurityNumber(datiTrasportoType.getDatiAnagraficiVettore().getCodiceFiscale());
				if(datiTrasportoType.getDatiAnagraficiVettore().getIdFiscaleIVA() != null) {
					vettore.setTaxCode(datiTrasportoType.getDatiAnagraficiVettore().getIdFiscaleIVA().getIdCodice());
					vettore.setTaxCountryCode(datiTrasportoType.getDatiAnagraficiVettore().getIdFiscaleIVA().getIdPaese());
				}
				vettore.setNumeroLicenzaGuida(datiTrasportoType.getDatiAnagraficiVettore().getNumeroLicenzaGuida());
				invoice.setVettore(vettore);
			}

			invoice.setDescrizioneTrasporto(datiTrasportoType.getDescrizione());
			invoice.setCapResa(datiTrasportoType.getIndirizzoResa().getCAP());
			invoice.setComuneResa(datiTrasportoType.getIndirizzoResa().getComune());
			invoice.setIndirizzoResa(datiTrasportoType.getIndirizzoResa().getIndirizzo());
			invoice.setNazioneResa(datiTrasportoType.getIndirizzoResa().getNazione());
			invoice.setNumeroCivicoResa(datiTrasportoType.getIndirizzoResa().getNumeroCivico());
			invoice.setProvinciaResa(datiTrasportoType.getIndirizzoResa().getProvincia());

			invoice.setMezzoTrasporto(datiTrasportoType.getMezzoTrasporto());
			invoice.setNumeroColli(datiTrasportoType.getNumeroColli());
			invoice.setPesoLordo(datiTrasportoType.getPesoLordo());
			invoice.setPesoNetto(datiTrasportoType.getPesoNetto());
			invoice.setTipoResa(datiTrasportoType.getTipoResa());
			invoice.setUnitaMisuraPeso(datiTrasportoType.getUnitaMisuraPeso());
		}

		DatiGeneraliDocumentoType datiGeneraliDocumentoType = datiGenerali.getDatiGeneraliDocumento();

		if(datiGeneraliDocumentoType.getDatiCassaPrevidenziale() != null) {
			checkSingleElementCollection(datiGeneraliDocumentoType.getDatiCassaPrevidenziale(), DatiCassaPrevidenzialeType.class);
			DatiCassaPrevidenzialeType datiCassaPrevidenziale = datiGeneraliDocumentoType.getDatiCassaPrevidenziale().get(0);
			invoice.setAlCassa(datiCassaPrevidenziale.getAlCassa());
			invoice.setAliquotaIvaCassa(datiCassaPrevidenziale.getAliquotaIVA());
			invoice.setImponibileCassa(datiCassaPrevidenziale.getImponibileCassa());
			invoice.setImportoContributoCassa(datiCassaPrevidenziale.getImportoContributoCassa());
			invoice.setNaturaCassa(datiCassaPrevidenziale.getNatura());
			invoice.setRiferimentoAmministrazioneCassa(datiCassaPrevidenziale.getRiferimentoAmministrazione());
			invoice.setRitenutaCassa(datiCassaPrevidenziale.getRitenuta());
			invoice.setTipoCassa(datiCassaPrevidenziale.getTipoCassa());
		}

		if(datiGeneraliDocumentoType.getDatiRitenuta() != null) {
			invoice.setAliquotaRitenuta(datiGeneraliDocumentoType.getDatiRitenuta().getAliquotaRitenuta());
			invoice.setCausalePagamentoRitenuta(datiGeneraliDocumentoType.getDatiRitenuta().getCausalePagamento().toString());
			invoice.setImportoRitenuta(datiGeneraliDocumentoType.getDatiRitenuta().getImportoRitenuta());
			invoice.setTipoRitenuta(datiGeneraliDocumentoType.getDatiRitenuta().getTipoRitenuta().toString());
		}

		if(datiGenerali.getFatturaPrincipale() != null) {
			invoice.setMainInvoiceDate(xmlGregorianCalendarToLocalDate(datiGenerali.getFatturaPrincipale().getDataFatturaPrincipale()));
			invoice.setMainInvoiceNumber(datiGenerali.getFatturaPrincipale().getNumeroFatturaPrincipale());
		}

		if(datiGeneraliDocumentoType.getArt73() != null)
			invoice.setArt73(datiGeneraliDocumentoType.getArt73().toString());

		DatiBolloType datiBollo = datiGeneraliDocumentoType.getDatiBollo();
		if(datiBollo != null) {
			invoice.setStampAmount(datiBollo.getImportoBollo());
			invoice.setVirtualStamp(datiBollo.getBolloVirtuale() == null ? null : datiBollo.getBolloVirtuale().toString());
		}

		if(datiGeneraliDocumentoType.getCausale() != null)
			invoice.setDescription(String.join("", datiGeneraliDocumentoType.getCausale()));

		List<ScontoMaggiorazioneType> discount = datiGeneraliDocumentoType.getScontoMaggiorazione();
		checkSingleElementCollection(discount, ScontoMaggiorazioneType.class);
		if(discount != null) {
			invoice.setDiscountAmount(discount.get(0).getImporto());
			invoice.setDiscountPercentage(discount.get(0).getPercentuale());
			invoice.setDiscountType(discount.get(0).getTipo().toString());
		}

		invoice.setCurrency(datiGeneraliDocumentoType.getDivisa());
		invoice.setDate(xmlGregorianCalendarToLocalDate(datiGeneraliDocumentoType.getData()));
		invoice.setDocumentTypeCode(datiGeneraliDocumentoType.getTipoDocumento().toString());
		invoice.setRounding(datiGeneraliDocumentoType.getArrotondamento());
		invoice.setTotalAmount(datiGeneraliDocumentoType.getImportoTotaleDocumento());
		invoice.setVersion(getInvoiceMappingVersion());
	}

	@Override
	protected void buildDatiPagamento(
			@NotEmpty List<DatiPagamentoType> datiPagamento
			, @NotNull Invoice invoice) {
		checkSingleElementCollection(datiPagamento, DatiPagamentoType.class);
		DatiPagamentoType datiPagamentoType = datiPagamento.get(0);
		
		invoice.setPaymentConditions(datiPagamentoType.getCondizioniPagamento().toString());
		
		checkSingleElementCollection(datiPagamentoType.getDettaglioPagamento(), DettaglioPagamentoType.class);
		DettaglioPagamentoType dettaglioPagamentoType = datiPagamentoType.getDettaglioPagamento().get(0);
		buildFinancialInstitution(dettaglioPagamentoType, invoice);
		invoice.setPaymentAmount(dettaglioPagamentoType.getImportoPagamento());
		invoice.setPaymentExpirationDate(xmlGregorianCalendarToLocalDate(dettaglioPagamentoType.getDataScadenzaPagamento()));
		invoice.setPaymentMode(dettaglioPagamentoType.getModalitaPagamento().toString());
		invoice.setPaymentTermDays(dettaglioPagamentoType.getGiorniTerminiPagamento());
		
		invoice.setBeneficiarioPagamento(dettaglioPagamentoType.getBeneficiario());
		invoice.setCfQuietanzantePagamento(dettaglioPagamentoType.getCFQuietanzante());
		invoice.setCodicePagamento(dettaglioPagamentoType.getCodicePagamento());
		invoice.setCodUfficioPostalePagamento(dettaglioPagamentoType.getCodUfficioPostale());
		invoice.setCognomeQuietanzantePagamento(dettaglioPagamentoType.getCognomeQuietanzante());
		invoice.setDataDecorrenzaPenalePagamento(xmlGregorianCalendarToLocalDate(dettaglioPagamentoType.getDataDecorrenzaPenale()));
		invoice.setDataLimitePagamentoAnticipatoPagamento(xmlGregorianCalendarToLocalDate(dettaglioPagamentoType.getDataLimitePagamentoAnticipato()));
		invoice.setDataRiferimentoTerminiPagamento(xmlGregorianCalendarToLocalDate(dettaglioPagamentoType.getDataRiferimentoTerminiPagamento()));
		invoice.setNomeQuietanzantePagamento(dettaglioPagamentoType.getNomeQuietanzante());
		invoice.setPenalitaPagamentiRitardatiPagamento(dettaglioPagamentoType.getPenalitaPagamentiRitardati());
		invoice.setScontoPagamentoAnticipatoPagamento(dettaglioPagamentoType.getScontoPagamentoAnticipato());
		invoice.setTitoloQuietanzantePagamento(dettaglioPagamentoType.getTitoloQuietanzante());
	}

	@Override
	protected void buildDatiVeicoli(
			DatiVeicoliType datiVeicoli
			, @NotNull Invoice invoice) {
		if(datiVeicoli != null) {
			invoice.setDataVeicoli(xmlGregorianCalendarToLocalDate(datiVeicoli.getData()));
			invoice.setTotalePercorsoVeicoli(datiVeicoli.getTotalePercorso());
		}
	}

	private Set<DocumentoCorrelato> buildDocumentiCorrelati(List<DatiDocumentiCorrelatiType> datiDocumentiCorrelati, Invoice invoice) {
		if(datiDocumentiCorrelati != null) {
			Set<DocumentoCorrelato> documentCorrelati = new HashSet<>(datiDocumentiCorrelati.size());
			for(DatiDocumentiCorrelatiType datiDocumentiCorrelatiType : datiDocumentiCorrelati) {
				documentCorrelati.add(new DocumentoCorrelato(
						datiDocumentiCorrelatiType.getCodiceCIG()
						, datiDocumentiCorrelatiType.getCodiceCommessaConvenzione()
						, datiDocumentiCorrelatiType.getCodiceCUP()
						, xmlGregorianCalendarToLocalDate(datiDocumentiCorrelatiType.getData())
						, datiDocumentiCorrelatiType.getIdDocumento()
						, invoice, datiDocumentiCorrelatiType.getNumItem()
						, getRelatedPurchaseLines(invoice, datiDocumentiCorrelatiType.getRiferimentoNumeroLinea())
						));
			}
			return documentCorrelati;
		}else
			return null;
	}

	@Override
	protected void buildFinancialInstitution(
			@NotNull DettaglioPagamentoType dettaglioPagamentoType
			, @NotNull Invoice invoice) {
		FinancialInstitution financialInstitution = new FinancialInstitution();
		financialInstitution.setAbi(dettaglioPagamentoType.getABI());
		financialInstitution.setBic(dettaglioPagamentoType.getBIC());
		financialInstitution.setCab(dettaglioPagamentoType.getCAB());
		financialInstitution.setIban(dettaglioPagamentoType.getIBAN());
		financialInstitution.setName(dettaglioPagamentoType.getIstitutoFinanziario());
		invoice.setFinancialInstitution(financialInstitution);
	}

	@Override
	protected void buildInvoiceItems(DatiBeniServiziType datiBeniServizi, Invoice invoice) {
		List<DatiRiepilogoType> datiRiepilogoTypes = datiBeniServizi.getDatiRiepilogo();
		if(datiRiepilogoTypes != null) {
			Set<DatiRiepilogo> datiRiepilogo = new HashSet<>();
			for(DatiRiepilogoType datiRiepilogoType : datiRiepilogoTypes) {
				datiRiepilogo.add(new DatiRiepilogo(
						datiRiepilogoType.getAliquotaIVA()
						, datiRiepilogoType.getArrotondamento()
						, datiRiepilogoType.getEsigibilitaIVA().toString()
						, datiRiepilogoType.getImponibileImporto()
						, datiRiepilogoType.getImposta()
						, invoice
						, datiRiepilogoType.getNatura().toString()
						, datiRiepilogoType.getRiferimentoNormativo()
						, datiRiepilogoType.getSpeseAccessorie()
						));
			}
			invoice.setDatiRiepilogo(datiRiepilogo);
		}
		
		List<DettaglioLineeType> dettaglioLinee = datiBeniServizi.getDettaglioLinee();

		if(dettaglioLinee != null) {
			List<PurchaseLine> purchaseLines = new ArrayList<>(dettaglioLinee.size());
			for(DettaglioLineeType dettaglioLinea : dettaglioLinee) {
				PurchaseLine purchaseLine = new PurchaseLine(Integer.toString(dettaglioLinea.getNumeroLinea()), invoice);

				purchaseLine.setAdministrativeReference(dettaglioLinea.getRiferimentoAmministrazione());

				List<CodiceArticoloType> codiceArticoloTypes = dettaglioLinea.getCodiceArticolo();
				checkSingleElementCollection(codiceArticoloTypes, CodiceArticoloType.class);
				purchaseLine.setItemCode(codiceArticoloTypes.get(0).getCodiceValore());
				purchaseLine.setItemCodeType(codiceArticoloTypes.get(0).getCodiceTipo());

				purchaseLine.setItemDescription(dettaglioLinea.getDescrizione());
				purchaseLine.setKind(dettaglioLinea.getNatura().toString());

				List<AltriDatiGestionaliType> altriDatiGestionaliTypes = dettaglioLinea.getAltriDatiGestionali();
				checkSingleElementCollection(altriDatiGestionaliTypes, AltriDatiGestionaliType.class);
				purchaseLine.setOtherManagementDataDate(xmlGregorianCalendarToLocalDate(altriDatiGestionaliTypes.get(0).getRiferimentoData()));
				purchaseLine.setOtherManagementDataReferenceNumber(altriDatiGestionaliTypes.get(0).getRiferimentoNumero());
				purchaseLine.setOtherManagementDataReferenceText(altriDatiGestionaliTypes.get(0).getRiferimentoTesto());
				purchaseLine.setOtherManagementDataDataType(altriDatiGestionaliTypes.get(0).getTipoDato());

				purchaseLine.setPeriodEndDate(xmlGregorianCalendarToLocalDate(dettaglioLinea.getDataFinePeriodo()));
				purchaseLine.setPeriodStartDate(xmlGregorianCalendarToLocalDate(dettaglioLinea.getDataInizioPeriodo()));
				purchaseLine.setRitenuta(dettaglioLinea.getRitenuta().toString());
				purchaseLine.setQuantity(dettaglioLinea.getQuantita());

				List<ScontoMaggiorazioneType> scontoMaggiorazioneTypes = dettaglioLinea.getScontoMaggiorazione();
				checkSingleElementCollection(scontoMaggiorazioneTypes, ScontoMaggiorazioneType.class);
				purchaseLine.setScontoMaggiorazioneAmount(scontoMaggiorazioneTypes.get(0).getImporto());
				purchaseLine.setScontoMaggiorazionePercentage(scontoMaggiorazioneTypes.get(0).getPercentuale());
				purchaseLine.setScontoMaggiorazioneType(scontoMaggiorazioneTypes.get(0).getTipo().toString());

				purchaseLine.setTaxRate(dettaglioLinea.getAliquotaIVA());
				purchaseLine.setTipoCessazionePrestazione(dettaglioLinea.getTipoCessionePrestazione().toString());
				purchaseLine.setTotalPrice(dettaglioLinea.getPrezzoTotale());
				purchaseLine.setUnitOfMeasureDescription(dettaglioLinea.getUnitaMisura());
				purchaseLine.setUnitPrice(dettaglioLinea.getPrezzoUnitario());

				purchaseLines.add(purchaseLine);
			}
			invoice.setPurchaseLines(new HashSet<>(purchaseLines));
		}
	}

	@Override
	protected void buildInvoiceSending(
			@NotNull DatiTrasmissioneType datiTrasmissione
			, @NotNull Invoice invoice) {
		invoice.setInvoiceRecipientCertifiedEmailAddress(datiTrasmissione.getPECDestinatario());
		invoice.setInvoiceRecipientCode(datiTrasmissione.getCodiceDestinatario());
		invoice.setInvoiceSenderCode(datiTrasmissione.getIdTrasmittente().getIdCodice());
		invoice.setInvoiceSenderCountryCode(datiTrasmissione.getIdTrasmittente().getIdPaese());
		invoice.setInvoiceSenderEmailAddress(datiTrasmissione.getContattiTrasmittente().getEmail());
		invoice.setInvoiceSenderPhoneNumber(datiTrasmissione.getContattiTrasmittente().getTelefono());
		invoice.setInvoiceSendingFormat(datiTrasmissione.getFormatoTrasmissione().toString());
		invoice.setInvoiceSendingNumber(datiTrasmissione.getProgressivoInvio());
	}

	@Override
	protected void buildSoggettoEmittente(SoggettoEmittenteType soggettoEmittenteType, TerzoIntermediarioSoggettoEmittenteType terzoIntermediarioSoggettoEmittenteType, Invoice invoice) {
		InvoiceParticipant soggettoEmittente = new InvoiceParticipant();
		mapAnagraficaTypeToInvoiceParticipant(terzoIntermediarioSoggettoEmittenteType.getDatiAnagrafici().getAnagrafica(), soggettoEmittente);
		mapCodiceFiscaleToInvoiceParticipant(terzoIntermediarioSoggettoEmittenteType.getDatiAnagrafici().getCodiceFiscale(), soggettoEmittente);
		mapIdFiscaleTypeToInvoiceParticipant(terzoIntermediarioSoggettoEmittenteType.getDatiAnagrafici().getIdFiscaleIVA(), soggettoEmittente);
		invoice.setSoggettoEmittente(soggettoEmittente);
		invoice.setSoggettoEmittenteType(soggettoEmittenteType.toString());
	}

	@Override
	public boolean canConvert(Class<?> clazz) {
		return FatturaElettronicaType.class.equals(clazz);
	}
	
	private <T> void checkSingleElementCollection(Collection<T> collection, Class<T> clazz) {
		if(collection == null || collection.size() != 1)
			throw new RuntimeException("Cannot map invoices with no or more than one " + clazz.getName());
	}

	@Override
	public Invoice convert(FatturaElettronicaType source) {
		Invoice invoice = new Invoice();

		// Build Header
		FatturaElettronicaHeaderType header = source.getFatturaElettronicaHeader();
		buildCedentePrestatore(header.getCedentePrestatore(), invoice);
		buildCessionarioCommittente(header.getCessionarioCommittente(), invoice);
		buildInvoiceSending(header.getDatiTrasmissione(), invoice);
		buildSoggettoEmittente(header.getSoggettoEmittente(), header.getTerzoIntermediarioOSoggettoEmittente(), invoice);
		buildRappresentanteFiscale(header.getRappresentanteFiscale(), invoice);
		
		// Build body
		List<FatturaElettronicaBodyType> bodies = source.getFatturaElettronicaBody();
		checkSingleElementCollection(bodies, FatturaElettronicaBodyType.class);
		FatturaElettronicaBodyType body = bodies.get(0);
		invoice.setNumber(body.getDatiGenerali().getDatiGeneraliDocumento().getNumero());
		buildInvoiceItems(body.getDatiBeniServizi(), invoice);
		buildAttachments(body.getAllegati(), invoice);
		buildDatiGenerali(body.getDatiGenerali(), invoice);
		buildDatiPagamento(body.getDatiPagamento(), invoice);
		buildDatiVeicoli(body.getDatiVeicoli(), invoice);

		return invoice;
	}
	
	@Override
	protected void buildRappresentanteFiscale(
			RappresentanteFiscaleType rappresentanteFiscale
			, @NotNull Invoice invoice) {
		if(rappresentanteFiscale != null) {
			InvoiceParticipant invoiceRappresentanteFiscale = new InvoiceParticipant();
			mapAnagraficaTypeToInvoiceParticipant(rappresentanteFiscale.getDatiAnagrafici().getAnagrafica(), invoiceRappresentanteFiscale);
			rappresentanteFiscale.getDatiAnagrafici().getCodiceFiscale();
			rappresentanteFiscale.getDatiAnagrafici().getIdFiscaleIVA();
			mapCodiceFiscaleToInvoiceParticipant(rappresentanteFiscale.getDatiAnagrafici().getCodiceFiscale(), invoiceRappresentanteFiscale);
			mapIdFiscaleTypeToInvoiceParticipant(rappresentanteFiscale.getDatiAnagrafici().getIdFiscaleIVA(), invoiceRappresentanteFiscale);
			invoice.setRappresentanteFiscale(invoiceRappresentanteFiscale);
		}
	}

	@Override
	public String getInvoiceMappingVersion() {
		return "1.2";
	}

	private List<PurchaseLine> getRelatedPurchaseLines(Invoice invoice, List<Integer> purchaseLineIds) {
		if(purchaseLineIds == null || purchaseLineIds.isEmpty())
			return null;
		else
			return invoice.getPurchaseLines().stream()
					.filter(c -> c.getInvoice().getNumber().equals(invoice.getNumber())
							&& purchaseLineIds.contains(Integer.parseInt(c.getDocumentId())))
					.collect(Collectors.toList());
	}

	private void mapAnagraficaTypeToInvoiceParticipant(AnagraficaType anagraficaType, InvoiceParticipant invoiceParticipant) {
		invoiceParticipant.setEoriCode(anagraficaType.getCodEORI());
		invoiceParticipant.setFirstName(anagraficaType.getNome());
		invoiceParticipant.setLastName(anagraficaType.getCognome());
		invoiceParticipant.setName(anagraficaType.getDenominazione());
		invoiceParticipant.setTitle(anagraficaType.getTitolo());
	}

	private void mapCodiceFiscaleToInvoiceParticipant(String codiceFiscale, InvoiceParticipant invoiceParticipant) {
		if(StringUtils.isBlank(codiceFiscale))
			throw new RuntimeException("Error while converting CedentePrestatore instance to InvoiceCedentePrestatore: ID (ssn) is null");
		else
			invoiceParticipant.setSocialSecurityNumber(codiceFiscale);
	}

	private void mapIdFiscaleTypeToInvoiceParticipant(IdFiscaleType taxId, InvoiceParticipant invoiceParticipant) {
		if(taxId != null) {
			invoiceParticipant.setTaxCode(taxId.getIdCodice());
			invoiceParticipant.setTaxCountryCode(taxId.getIdPaese());
		}
	}

	private void mapIndirizzoTypeToInvoiceParticipant(IndirizzoType indirizzoType, InvoiceParticipant invoiceParticipant) {
		if(indirizzoType != null) {
			invoiceParticipant.setCity(indirizzoType.getComune());
			invoiceParticipant.setCountry(indirizzoType.getNazione());
			invoiceParticipant.setDistrict(indirizzoType.getProvincia());
			invoiceParticipant.setHouseNumber(indirizzoType.getNumeroCivico());
			invoiceParticipant.setStreetAddress(indirizzoType.getIndirizzo());
			invoiceParticipant.setZipCode(indirizzoType.getCAP());
		}
	}

	private LocalDate xmlGregorianCalendarToLocalDate(XMLGregorianCalendar xmlGregorianCalendar) {
		Date utilDate = xmlGregorianCalendar.toGregorianCalendar().getTime();
		return LocalDateTime.ofInstant(utilDate.toInstant(), ZoneId.systemDefault()).toLocalDate();
	}
}

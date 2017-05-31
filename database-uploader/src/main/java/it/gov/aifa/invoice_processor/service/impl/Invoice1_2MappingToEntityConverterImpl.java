package it.gov.aifa.invoice_processor.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;
import javax.xml.datatype.XMLGregorianCalendar;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.constant.DocumentoCorrelatoType;
import it.gov.aifa.invoice_processor.constant.InvoiceParticipantType;
import it.gov.aifa.invoice_processor.entity.invoice.Attachment;
import it.gov.aifa.invoice_processor.entity.invoice.DatiRiepilogo;
import it.gov.aifa.invoice_processor.entity.invoice.DocumentoCorrelato;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceParticipant;
import it.gov.aifa.invoice_processor.entity.invoice.PurchaseLine;
import it.gov.aifa.invoice_processor.mapping.InvoiceMapping;
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
import it.gov.aifa.invoice_processor.service.InvoiceMappingToEntityConverter;

@Service
@Validated
public class Invoice1_2MappingToEntityConverterImpl extends AbstractInvoiceMappingToEntityConverter implements InvoiceMappingToEntityConverter{

	@Override
	protected void buildAttachments(
			@NotNull List<AllegatiType> allegati
			, @NotNull Invoice invoice) {
		if(allegati != null && !allegati.isEmpty()) {
			Set<Attachment> attachments = new HashSet<>(allegati.size());
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
		InvoiceParticipant invoiceCedentePrestatore = new InvoiceParticipant(invoice, InvoiceParticipantType.CEDENTE_PRESTATORE);

		ContattiType contacts = cedentePrestatore.getContatti();
		if(contacts != null) {
			invoiceCedentePrestatore.setEmailAddress(contacts.getEmail());
			invoiceCedentePrestatore.setFaxNumber(contacts.getFax());
			invoiceCedentePrestatore.setPhoneNumber(contacts.getTelefono());
		}

		DatiAnagraficiCedenteType biographicalData = cedentePrestatore.getDatiAnagrafici();
		if(biographicalData != null) {
			mapAnagraficaTypeToInvoiceParticipant(biographicalData.getAnagrafica(), invoiceCedentePrestatore);
			invoiceCedentePrestatore.setSocialSecurityNumber(biographicalData.getCodiceFiscale());
			mapIdFiscaleTypeToInvoiceParticipant(biographicalData.getIdFiscaleIVA(), invoiceCedentePrestatore);
			invoiceCedentePrestatore.setProfessionalReg(biographicalData.getAlboProfessionale());
			invoiceCedentePrestatore.setProfessionalRegNumber(biographicalData.getNumeroIscrizioneAlbo());
			invoiceCedentePrestatore.setProfessionalRegDistrict(biographicalData.getProvinciaAlbo());
			if(biographicalData.getDataIscrizioneAlbo() != null)
				invoiceCedentePrestatore.setProfessionalRegSubscrDate(xmlGregorianCalendarToSqlDate(biographicalData.getDataIscrizioneAlbo()));

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
			invoiceCedentePrestatore.setPermEstZipCode(stabileOrganizzazione.getCAP());
			invoiceCedentePrestatore.setPermEstCity(stabileOrganizzazione.getComune());
			invoiceCedentePrestatore.setPermEstStreetAddress(stabileOrganizzazione.getIndirizzo());
			invoiceCedentePrestatore.setPermEstCountry(stabileOrganizzazione.getNazione());
			invoiceCedentePrestatore.setPermEstHouseNumber(stabileOrganizzazione.getNumeroCivico());
			invoiceCedentePrestatore.setPermEstDistrict(stabileOrganizzazione.getProvincia());
		}

		invoice.getInvoiceParticipants().add(invoiceCedentePrestatore);
	}

	@Override
	protected void buildCessionarioCommittente(
			@NotNull CessionarioCommittenteType cessionarioCommittente
			, @NotNull Invoice invoice
			) {
		InvoiceParticipant invoiceCessionarioCommittente = new InvoiceParticipant(invoice, InvoiceParticipantType.CESSIONARIO_COMMITTENTE);

		DatiAnagraficiCessionarioType biographicalData = cessionarioCommittente.getDatiAnagrafici();
		if(biographicalData != null) {
			mapAnagraficaTypeToInvoiceParticipant(biographicalData.getAnagrafica(), invoiceCessionarioCommittente);
			invoiceCessionarioCommittente.setSocialSecurityNumber(biographicalData.getCodiceFiscale());
			mapIdFiscaleTypeToInvoiceParticipant(biographicalData.getIdFiscaleIVA(), invoiceCessionarioCommittente);
		}

		RappresentanteFiscaleCessionarioType rappresentanteFiscaleCessionarioType = cessionarioCommittente.getRappresentanteFiscale();
		if(rappresentanteFiscaleCessionarioType != null) {
			invoiceCessionarioCommittente.setTaxRepresentativeFirstName(rappresentanteFiscaleCessionarioType.getNome());
			if(rappresentanteFiscaleCessionarioType.getIdFiscaleIVA() != null) {
				invoiceCessionarioCommittente.setTaxRepresentativeCountryId(rappresentanteFiscaleCessionarioType.getIdFiscaleIVA().getIdPaese());
				invoiceCessionarioCommittente.setTaxRepresentativeIdCode(rappresentanteFiscaleCessionarioType.getIdFiscaleIVA().getIdCodice());
			}
			invoiceCessionarioCommittente.setTaxRepresentativeLastName(rappresentanteFiscaleCessionarioType.getCognome());
			invoiceCessionarioCommittente.setTaxRepresentativeName(rappresentanteFiscaleCessionarioType.getDenominazione());
		}

		mapIndirizzoTypeToInvoiceParticipant(cessionarioCommittente.getSede(), invoiceCessionarioCommittente);

		IndirizzoType stabileOrganizzazioneType = cessionarioCommittente.getStabileOrganizzazione();
		if(stabileOrganizzazioneType != null) {
			invoiceCessionarioCommittente.setPermEstCity(stabileOrganizzazioneType.getComune());
			invoiceCessionarioCommittente.setPermEstCountry(stabileOrganizzazioneType.getNazione());
			invoiceCessionarioCommittente.setPermEstDistrict(stabileOrganizzazioneType.getProvincia());
			invoiceCessionarioCommittente.setPermEstHouseNumber(stabileOrganizzazioneType.getNumeroCivico());
			invoiceCessionarioCommittente.setPermEstStreetAddress(stabileOrganizzazioneType.getIndirizzo());
			invoiceCessionarioCommittente.setPermEstZipCode(stabileOrganizzazioneType.getCAP());
		}

		invoice.getInvoiceParticipants().add(invoiceCessionarioCommittente);
	}

	@Override
	protected void buildDatiGenerali(DatiGeneraliType datiGenerali, Invoice invoice) {
		List<DatiDDTType> datiDDTTypes = datiGenerali.getDatiDDT();
		if(datiDDTTypes != null) {
			Set<DocumentoCorrelato> invoiceDatiDdt = new HashSet<>(datiDDTTypes.size());
			for(DatiDDTType datiDDTType : datiDDTTypes) {
				Date dataDocumentoCorrelato = null;
				XMLGregorianCalendar dataDDT = datiDDTType.getDataDDT();
				if(dataDDT != null)
					dataDocumentoCorrelato = xmlGregorianCalendarToSqlDate(datiDDTType.getDataDDT());
				DocumentoCorrelato documentoCorrelato = new DocumentoCorrelato(
						dataDocumentoCorrelato
						, datiDDTType.getNumeroDDT()
						, DocumentoCorrelatoType.DDT
						, invoice
						, getRelatedPurchaseLines(invoice, datiDDTType.getRiferimentoNumeroLinea()));
				invoiceDatiDdt.add(documentoCorrelato);
			}
			invoice.getDocumentiCorrelati().addAll(invoiceDatiDdt);
		}

		invoice.getDocumentiCorrelati().addAll(buildDocumentiCorrelati(datiGenerali.getDatiContratto(), DocumentoCorrelatoType.CONTRATTO, invoice));
		invoice.getDocumentiCorrelati().addAll(buildDocumentiCorrelati(datiGenerali.getDatiConvenzione(), DocumentoCorrelatoType.CONVENZIONE, invoice));
		invoice.getDocumentiCorrelati().addAll(buildDocumentiCorrelati(datiGenerali.getDatiFattureCollegate(), DocumentoCorrelatoType.FATTURA_COLLEGATA, invoice));
		invoice.getDocumentiCorrelati().addAll(buildDocumentiCorrelati(datiGenerali.getDatiOrdineAcquisto(), DocumentoCorrelatoType.ORDINE_ACQUISTO, invoice));
		invoice.getDocumentiCorrelati().addAll(buildDocumentiCorrelati(datiGenerali.getDatiRicezione(), DocumentoCorrelatoType.RICEZIONE, invoice));

		if(!CollectionUtils.isEmpty(datiGenerali.getDatiSAL())) {
			checkSingleElementCollection(datiGenerali.getDatiSAL(), DatiSALType.class);
			invoice.setRiferimentoFase(datiGenerali.getDatiSAL().get(0).getRiferimentoFase());
		}

		DatiTrasportoType datiTrasportoType = datiGenerali.getDatiTrasporto();
		if(datiTrasportoType != null) {
			invoice.setCausaleTrasporto(datiTrasportoType.getCausaleTrasporto());
			invoice.setDataInizioTrasporto(datiTrasportoType.getDataInizioTrasporto() != null ? xmlGregorianCalendarToSqlDate(datiTrasportoType.getDataInizioTrasporto()) : null);
			invoice.setDataOraConsegna(datiTrasportoType.getDataOraConsegna() != null ? xmlGregorianCalendarToSqlDate(datiTrasportoType.getDataOraConsegna()) : null);
			invoice.setDataOraRitiro(datiTrasportoType.getDataOraRitiro() != null ? xmlGregorianCalendarToSqlDate(datiTrasportoType.getDataOraRitiro()) : null);

			if(datiTrasportoType.getDatiAnagraficiVettore() != null) {
				InvoiceParticipant vettore = new InvoiceParticipant(invoice, InvoiceParticipantType.VETTORE);
				mapAnagraficaTypeToInvoiceParticipant(datiTrasportoType.getDatiAnagraficiVettore().getAnagrafica(), vettore);
				vettore.setSocialSecurityNumber(datiTrasportoType.getDatiAnagraficiVettore().getCodiceFiscale());
				mapIdFiscaleTypeToInvoiceParticipant(datiTrasportoType.getDatiAnagraficiVettore().getIdFiscaleIVA(), vettore);
				vettore.setNumeroLicenzaGuida(datiTrasportoType.getDatiAnagraficiVettore().getNumeroLicenzaGuida());
				invoice.getInvoiceParticipants().add(vettore);
			}

			invoice.setDescrizioneTrasporto(datiTrasportoType.getDescrizione());
			if(datiTrasportoType.getIndirizzoResa() != null) {
				invoice.setCapResa(datiTrasportoType.getIndirizzoResa().getCAP());
				invoice.setComuneResa(datiTrasportoType.getIndirizzoResa().getComune());
				invoice.setIndirizzoResa(datiTrasportoType.getIndirizzoResa().getIndirizzo());
				invoice.setNazioneResa(datiTrasportoType.getIndirizzoResa().getNazione());
				invoice.setNumeroCivicoResa(datiTrasportoType.getIndirizzoResa().getNumeroCivico());
				invoice.setProvinciaResa(datiTrasportoType.getIndirizzoResa().getProvincia());
			}

			invoice.setMezzoTrasporto(datiTrasportoType.getMezzoTrasporto());
			invoice.setNumeroColli(datiTrasportoType.getNumeroColli());
			invoice.setPesoLordo(datiTrasportoType.getPesoLordo());
			invoice.setPesoNetto(datiTrasportoType.getPesoNetto());
			invoice.setTipoResa(datiTrasportoType.getTipoResa());
			invoice.setUnitaMisuraPeso(datiTrasportoType.getUnitaMisuraPeso());
		}

		DatiGeneraliDocumentoType datiGeneraliDocumentoType = datiGenerali.getDatiGeneraliDocumento();

		if(!CollectionUtils.isEmpty(datiGeneraliDocumentoType.getDatiCassaPrevidenziale())) {
			checkSingleElementCollection(datiGeneraliDocumentoType.getDatiCassaPrevidenziale(), DatiCassaPrevidenzialeType.class);
			DatiCassaPrevidenzialeType datiCassaPrevidenziale = datiGeneraliDocumentoType.getDatiCassaPrevidenziale().get(0);
			invoice.setAlCassa(datiCassaPrevidenziale.getAlCassa());
			invoice.setAliquotaIvaCassa(datiCassaPrevidenziale.getAliquotaIVA());
			invoice.setImponibileCassa(datiCassaPrevidenziale.getImponibileCassa());
			invoice.setImportoContributoCassa(datiCassaPrevidenziale.getImportoContributoCassa());
			invoice.setNaturaCassa(datiCassaPrevidenziale.getNatura());
			invoice.setRiferimentoAmminCassa(datiCassaPrevidenziale.getRiferimentoAmministrazione());
			invoice.setRitenutaCassa(datiCassaPrevidenziale.getRitenuta());
			invoice.setTipoCassa(datiCassaPrevidenziale.getTipoCassa());
		}

		if(datiGeneraliDocumentoType.getDatiRitenuta() != null) {
			invoice.setAliquotaRitenuta(datiGeneraliDocumentoType.getDatiRitenuta().getAliquotaRitenuta());
			invoice.setCausalePagRitenuta(datiGeneraliDocumentoType.getDatiRitenuta().getCausalePagamento().toString());
			invoice.setImportoRitenuta(datiGeneraliDocumentoType.getDatiRitenuta().getImportoRitenuta());
			invoice.setTipoRitenuta(datiGeneraliDocumentoType.getDatiRitenuta().getTipoRitenuta().toString());
		}

		if(datiGenerali.getFatturaPrincipale() != null) {
			invoice.setMainInvoiceDate(xmlGregorianCalendarToSqlDate(datiGenerali.getFatturaPrincipale().getDataFatturaPrincipale()));
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
		if(!CollectionUtils.isEmpty(discount)) {
			checkSingleElementCollection(discount, ScontoMaggiorazioneType.class);
			invoice.setDiscountAmount(discount.get(0).getImporto());
			invoice.setDiscountPercentage(discount.get(0).getPercentuale());
			invoice.setDiscountType(discount.get(0).getTipo().toString());
		}

		invoice.setCurrency(datiGeneraliDocumentoType.getDivisa());
		invoice.setInvoiceDate(xmlGregorianCalendarToSqlDate(datiGeneraliDocumentoType.getData()));
		invoice.setDocumentTypeCode(datiGeneraliDocumentoType.getTipoDocumento().toString());
		invoice.setRounding(datiGeneraliDocumentoType.getArrotondamento());
		invoice.setTotalAmount(datiGeneraliDocumentoType.getImportoTotaleDocumento());
	}

	@Override
	protected void buildDatiPagamento(
			@NotEmpty List<DatiPagamentoType> datiPagamento
			, @NotNull Invoice invoice) {
		if(CollectionUtils.isEmpty(datiPagamento))
			throw new RuntimeException("Cannot map invoice without payment information");
		checkSingleElementCollection(datiPagamento, DatiPagamentoType.class);
		DatiPagamentoType datiPagamentoType = datiPagamento.get(0);

		invoice.setPaymentConditions(datiPagamentoType.getCondizioniPagamento() != null ? datiPagamentoType.getCondizioniPagamento().toString() : null);

		checkSingleElementCollection(datiPagamentoType.getDettaglioPagamento(), DettaglioPagamentoType.class);
		DettaglioPagamentoType dettaglioPagamentoType = datiPagamentoType.getDettaglioPagamento().get(0);
		invoice.setFinancialInstitutionAbi(dettaglioPagamentoType.getABI());
		invoice.setFinancialInstitutionBic(dettaglioPagamentoType.getBIC());
		invoice.setFinancialInstitutionCab(dettaglioPagamentoType.getCAB());
		invoice.setFinancialInstitutionIban(dettaglioPagamentoType.getIBAN());
		invoice.setFinancialInstitutionName(dettaglioPagamentoType.getIstitutoFinanziario());
		invoice.setPaymentAmount(dettaglioPagamentoType.getImportoPagamento());
		invoice.setPaymentExpirationDate(dettaglioPagamentoType.getDataScadenzaPagamento() != null ? xmlGregorianCalendarToSqlDate(dettaglioPagamentoType.getDataScadenzaPagamento()) : null);
		invoice.setPaymentMode(dettaglioPagamentoType.getModalitaPagamento().toString());
		invoice.setPaymentTermDays(dettaglioPagamentoType.getGiorniTerminiPagamento());

		invoice.setBeneficiarioPag(dettaglioPagamentoType.getBeneficiario());
		invoice.setCfQuietanzantePag(dettaglioPagamentoType.getCFQuietanzante());
		invoice.setCodicePag(dettaglioPagamentoType.getCodicePagamento());
		invoice.setCodUfficioPostalePag(dettaglioPagamentoType.getCodUfficioPostale());
		invoice.setCognomeQuietanzantePag(dettaglioPagamentoType.getCognomeQuietanzante());
		invoice.setDataDecorrenzaPenalePag(dettaglioPagamentoType.getDataDecorrenzaPenale() != null ? xmlGregorianCalendarToSqlDate(dettaglioPagamentoType.getDataDecorrenzaPenale()) : null);
		invoice.setDataLimitePagAnticipato(dettaglioPagamentoType.getDataLimitePagamentoAnticipato() != null ? xmlGregorianCalendarToSqlDate(dettaglioPagamentoType.getDataLimitePagamentoAnticipato()) : null);
		invoice.setDataRiferimentoTerminiPag(dettaglioPagamentoType.getDataRiferimentoTerminiPagamento() != null ? xmlGregorianCalendarToSqlDate(dettaglioPagamentoType.getDataRiferimentoTerminiPagamento()) : null);
		invoice.setNomeQuietanzantePag(dettaglioPagamentoType.getNomeQuietanzante());
		invoice.setPenalitaPagamentiRitardati(dettaglioPagamentoType.getPenalitaPagamentiRitardati());
		invoice.setScontoPagAnticipatoPag(dettaglioPagamentoType.getScontoPagamentoAnticipato());
		invoice.setTitoloQuietanzantePag(dettaglioPagamentoType.getTitoloQuietanzante());
	}

	@Override
	protected void buildDatiVeicoli(
			DatiVeicoliType datiVeicoli
			, @NotNull Invoice invoice) {
		if(datiVeicoli != null) {
			invoice.setDataVeicoli(datiVeicoli.getData() != null ? xmlGregorianCalendarToSqlDate(datiVeicoli.getData()) : null);
			invoice.setTotalePercorsoVeicoli(datiVeicoli.getTotalePercorso());
		}
	}

	private Set<DocumentoCorrelato> buildDocumentiCorrelati(List<DatiDocumentiCorrelatiType> datiDocumentiCorrelati, String documentoCorrelatoType, Invoice invoice) {
		if(datiDocumentiCorrelati != null) {
			Set<DocumentoCorrelato> documentCorrelati = new HashSet<>(datiDocumentiCorrelati.size());
			for(DatiDocumentiCorrelatiType datiDocumentiCorrelatiType : datiDocumentiCorrelati) {
				documentCorrelati.add(
						new DocumentoCorrelato(
								datiDocumentiCorrelatiType.getCodiceCIG()
								, datiDocumentiCorrelatiType.getCodiceCommessaConvenzione()
								, datiDocumentiCorrelatiType.getCodiceCUP()
								, datiDocumentiCorrelatiType.getData() != null ? xmlGregorianCalendarToSqlDate(datiDocumentiCorrelatiType.getData()) : null
								, documentoCorrelatoType
								, datiDocumentiCorrelatiType.getIdDocumento()
								, invoice
								, datiDocumentiCorrelatiType.getNumItem()
								, getRelatedPurchaseLines(invoice, datiDocumentiCorrelatiType.getRiferimentoNumeroLinea())
						));
			}
			return documentCorrelati;
		}else
			return null;
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
						, datiRiepilogoType.getNatura() != null ? datiRiepilogoType.getNatura().toString() : null
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
				if(!CollectionUtils.isEmpty(codiceArticoloTypes)) {
					checkSingleElementCollection(codiceArticoloTypes, CodiceArticoloType.class);
					purchaseLine.setItemCode(codiceArticoloTypes.get(0).getCodiceValore());
					purchaseLine.setItemCodeType(codiceArticoloTypes.get(0).getCodiceTipo());
				}

				purchaseLine.setItemDescription(dettaglioLinea.getDescrizione());
				purchaseLine.setKind(dettaglioLinea.getNatura() != null ? dettaglioLinea.getNatura().toString() : null);

				List<AltriDatiGestionaliType> altriDatiGestionaliTypes = dettaglioLinea.getAltriDatiGestionali();
				if(!CollectionUtils.isEmpty(altriDatiGestionaliTypes)) {
					checkSingleElementCollection(altriDatiGestionaliTypes, AltriDatiGestionaliType.class);
					if(altriDatiGestionaliTypes.get(0).getRiferimentoData() != null)
						purchaseLine.setOtherMgmtDataDate(xmlGregorianCalendarToSqlDate(altriDatiGestionaliTypes.get(0).getRiferimentoData()));
					purchaseLine.setOtherMgmtDataRefNumber(altriDatiGestionaliTypes.get(0).getRiferimentoNumero());
					purchaseLine.setOtherMgmtDataRefText(altriDatiGestionaliTypes.get(0).getRiferimentoTesto());
					purchaseLine.setOtherMgmtDataDataType(altriDatiGestionaliTypes.get(0).getTipoDato());
				}

				purchaseLine.setPeriodEndDate(dettaglioLinea.getDataFinePeriodo() != null ? xmlGregorianCalendarToSqlDate(dettaglioLinea.getDataFinePeriodo()) : null);
				purchaseLine.setPeriodStartDate(dettaglioLinea.getDataInizioPeriodo() != null ? xmlGregorianCalendarToSqlDate(dettaglioLinea.getDataInizioPeriodo()) : null);
				purchaseLine.setRitenuta(dettaglioLinea.getRitenuta() != null ? dettaglioLinea.getRitenuta().toString() : null);
				purchaseLine.setQuantity(dettaglioLinea.getQuantita());

				List<ScontoMaggiorazioneType> scontoMaggiorazioneTypes = dettaglioLinea.getScontoMaggiorazione();
				if(!CollectionUtils.isEmpty(scontoMaggiorazioneTypes)) {
					checkSingleElementCollection(scontoMaggiorazioneTypes, ScontoMaggiorazioneType.class);
					purchaseLine.setScontoMaggAmount(scontoMaggiorazioneTypes.get(0).getImporto());
					purchaseLine.setScontoMaggPercentage(scontoMaggiorazioneTypes.get(0).getPercentuale());
					purchaseLine.setScontoMaggType(scontoMaggiorazioneTypes.get(0).getTipo().toString());
				}

				purchaseLine.setTaxRate(dettaglioLinea.getAliquotaIVA());
				purchaseLine.setTipoCessazionePrestazione(dettaglioLinea.getTipoCessionePrestazione() != null ? dettaglioLinea.getTipoCessionePrestazione().toString() : null);
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
		invoice.setRecipientCertEmailAddr(datiTrasmissione.getPECDestinatario());
		invoice.setRecipientCode(datiTrasmissione.getCodiceDestinatario());
		invoice.setInvoiceSenderCode(datiTrasmissione.getIdTrasmittente().getIdCodice());
		invoice.setInvoiceSenderCountryCode(datiTrasmissione.getIdTrasmittente().getIdPaese());
		if(datiTrasmissione.getContattiTrasmittente() != null) {
			invoice.setInvoiceSenderEmailAddress(datiTrasmissione.getContattiTrasmittente().getEmail());
			invoice.setInvoiceSenderPhoneNumber(datiTrasmissione.getContattiTrasmittente().getTelefono());
		}
		invoice.setInvoiceSendingFormat(datiTrasmissione.getFormatoTrasmissione().toString());
		invoice.setInvoiceSendingNumber(datiTrasmissione.getProgressivoInvio());
		invoice.setVersion(datiTrasmissione.getFormatoTrasmissione().version());
	}

	@Override
	protected void buildSoggettoEmittente(SoggettoEmittenteType soggettoEmittenteType, TerzoIntermediarioSoggettoEmittenteType terzoIntermediarioSoggettoEmittenteType, Invoice invoice) {
		InvoiceParticipant soggettoEmittente = null;
		if(terzoIntermediarioSoggettoEmittenteType != null) {
			soggettoEmittente = new InvoiceParticipant(invoice, InvoiceParticipantType.SOGGETTO_EMITTENTE);
			mapAnagraficaTypeToInvoiceParticipant(terzoIntermediarioSoggettoEmittenteType.getDatiAnagrafici().getAnagrafica(), soggettoEmittente);
			soggettoEmittente.setSocialSecurityNumber(terzoIntermediarioSoggettoEmittenteType.getDatiAnagrafici().getCodiceFiscale());
			mapIdFiscaleTypeToInvoiceParticipant(terzoIntermediarioSoggettoEmittenteType.getDatiAnagrafici().getIdFiscaleIVA(), soggettoEmittente);
		}
		invoice.getInvoiceParticipants().add(soggettoEmittente);

		if(soggettoEmittenteType != null)
			invoice.setSoggettoEmittenteType(soggettoEmittenteType.toString());
	}

	@Override
	public boolean canConvert(Class<?> clazz) {
		return FatturaElettronicaType.class.equals(clazz);
	}

	private <T> void checkSingleElementCollection(Collection<T> collection, Class<T> clazz) {
		if(collection.size() != 1)
			throw new RuntimeException("Cannot map invoices with more than one " + clazz.getName());
	}

	@Override
	public Invoice convert(InvoiceMapping<String> source) {
		if(source == null)
			throw new RuntimeException("Source cannot be null");

		if(!canConvert(source.getClass()))
			throw new RuntimeException("This converter does not support " + source.getClass() + " class");

		FatturaElettronicaType fatturaElettronicaType = (FatturaElettronicaType) source;

		List<FatturaElettronicaBodyType> bodies = fatturaElettronicaType.getFatturaElettronicaBody();
		if(CollectionUtils.isEmpty(bodies))
			throw new RuntimeException("Cannot map Invoice without body");
		checkSingleElementCollection(bodies, FatturaElettronicaBodyType.class);
		FatturaElettronicaBodyType body = bodies.get(0);
		Invoice invoice = new Invoice();
		invoice.setInvoiceNumber(body.getDatiGenerali().getDatiGeneraliDocumento().getNumero());

		// Build Header
		FatturaElettronicaHeaderType header = fatturaElettronicaType.getFatturaElettronicaHeader();
		buildCedentePrestatore(header.getCedentePrestatore(), invoice);
		buildCessionarioCommittente(header.getCessionarioCommittente(), invoice);
		buildInvoiceSending(header.getDatiTrasmissione(), invoice);
		buildSoggettoEmittente(header.getSoggettoEmittente(), header.getTerzoIntermediarioOSoggettoEmittente(), invoice);
		buildRappresentanteFiscale(header.getRappresentanteFiscale(), invoice);

		// Build body
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
			InvoiceParticipant invoiceRappresentanteFiscale = new InvoiceParticipant(invoice, InvoiceParticipantType.RAPPRESENTANTE_FISCALE);
			mapAnagraficaTypeToInvoiceParticipant(rappresentanteFiscale.getDatiAnagrafici().getAnagrafica(), invoiceRappresentanteFiscale);
			invoiceRappresentanteFiscale.setSocialSecurityNumber(rappresentanteFiscale.getDatiAnagrafici().getCodiceFiscale());
			mapIdFiscaleTypeToInvoiceParticipant(rappresentanteFiscale.getDatiAnagrafici().getIdFiscaleIVA(), invoiceRappresentanteFiscale);
			invoice.getInvoiceParticipants().add(invoiceRappresentanteFiscale);
		}
	}

	private Set<PurchaseLine> getRelatedPurchaseLines(Invoice invoice, List<Integer> purchaseLineIds) {
		if(purchaseLineIds == null || purchaseLineIds.isEmpty())
			return null;
		else {
			Set<PurchaseLine> relatedPurchaseLines = invoice.getPurchaseLines().stream()
					.filter(c -> c.getInvoice().getInvoiceNumber().equals(invoice.getInvoiceNumber())
							&& purchaseLineIds.contains(Integer.parseInt(c.getDocumentId()))
							)
					.collect(Collectors.toSet());
			return relatedPurchaseLines;
		}
	}

	private void mapAnagraficaTypeToInvoiceParticipant(AnagraficaType anagraficaType, InvoiceParticipant invoiceParticipant) {
		invoiceParticipant.setEoriCode(anagraficaType.getCodEORI());
		invoiceParticipant.setFirstName(anagraficaType.getNome());
		invoiceParticipant.setLastName(anagraficaType.getCognome());
		invoiceParticipant.setName(anagraficaType.getDenominazione());
		invoiceParticipant.setTitle(anagraficaType.getTitolo());
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

	private Date xmlGregorianCalendarToSqlDate(XMLGregorianCalendar xmlGregorianCalendar) {
		java.util.Date date = xmlGregorianCalendar.toGregorianCalendar().getTime();
		LocalDate localDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
		return Date.valueOf(localDate);
	}
}

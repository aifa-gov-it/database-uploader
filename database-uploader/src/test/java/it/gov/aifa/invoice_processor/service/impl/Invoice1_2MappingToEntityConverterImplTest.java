package it.gov.aifa.invoice_processor.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.constant.InvoiceParticipantType;
import it.gov.aifa.invoice_processor.entity.invoice.Attachment;
import it.gov.aifa.invoice_processor.entity.invoice.DatiRiepilogo;
import it.gov.aifa.invoice_processor.entity.invoice.DocumentoCorrelato;
import it.gov.aifa.invoice_processor.entity.invoice.DocumentoCorrelatoType;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.entity.invoice.InvoiceParticipant;
import it.gov.aifa.invoice_processor.entity.invoice.PurchaseLine;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.AllegatiType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.AltriDatiGestionaliType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.AnagraficaType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.Art73Type;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.BolloVirtualeType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.CausalePagamentoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.CedentePrestatoreType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.CessionarioCommittenteType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.CodiceArticoloType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.CondizioniPagamentoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.ContattiTrasmittenteType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.ContattiType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiAnagraficiCedenteType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiAnagraficiCessionarioType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiAnagraficiRappresentanteType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiAnagraficiTerzoIntermediarioType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiAnagraficiVettoreType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiBeniServiziType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiBolloType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiCassaPrevidenzialeType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiDDTType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiDocumentiCorrelatiType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiGeneraliDocumentoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiGeneraliType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiPagamentoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiRiepilogoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiRitenutaType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiSALType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiTrasmissioneType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiTrasportoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DatiVeicoliType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DettaglioLineeType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.DettaglioPagamentoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.EsigibilitaIVAType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.FatturaElettronicaBodyType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.FatturaElettronicaHeaderType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.FatturaElettronicaType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.FatturaPrincipaleType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.FormatoTrasmissioneType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.IdFiscaleType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.IndirizzoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.IscrizioneREAType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.ModalitaPagamentoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.NaturaType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.RappresentanteFiscaleCessionarioType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.RappresentanteFiscaleType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.RegimeFiscaleType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.RitenutaType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.ScontoMaggiorazioneType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.SocioUnicoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.SoggettoEmittenteType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.StatoLiquidazioneType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.TerzoIntermediarioSoggettoEmittenteType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.TipoCassaType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.TipoCessionePrestazioneType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.TipoDocumentoType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.TipoRitenutaType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.TipoScontoMaggiorazioneType;

public class Invoice1_2MappingToEntityConverterImplTest{

	private List<AllegatiType> buildAllegatiTypes() {
		return buildOneElementList(new AllegatiType("algoritmoCompressione", "attachment".getBytes(), "descrizioneAttachment", "formatoAttachment", "nomeAttachment"), AllegatiType.class);
	}

	@Test
	public void buildAttachmentsTest() {
		List<AllegatiType> allegati = buildAllegatiTypes();
		Invoice1_2MappingToEntityConverterImpl converter = new Invoice1_2MappingToEntityConverterImpl();
		Invoice invoice = new Invoice();
		converter.buildAttachments(allegati, invoice);
		Set<Attachment> attachments = invoice.getAttachments();
		assertThat(attachments).isNotNull();
		assertThat(attachments).hasSize(allegati.size());
		Attachment attachment = attachments.iterator().next();
		assertThat(attachment.getCompressionAlgorithm()).isEqualTo(allegati.get(0).getAlgoritmoCompressione());
		assertThat(attachment.getData()).isEqualTo(allegati.get(0).getAttachment());
		assertThat(attachment.getDescription()).isEqualTo(allegati.get(0).getDescrizioneAttachment());
		assertThat(attachment.getFormat()).isEqualTo(allegati.get(0).getFormatoAttachment());
		assertThat(attachment.getInvoice()).isSameAs(invoice);
		assertThat(attachment.getName()).isEqualTo(allegati.get(0).getNomeAttachment());
	}

	@Test
	public void buildCedentePrestatoreTest() throws DatatypeConfigurationException {
		CedentePrestatoreType cedentePrestatoreType = buildCedentePrestatoreType();

		Invoice1_2MappingToEntityConverterImpl converter = new Invoice1_2MappingToEntityConverterImpl();
		Invoice invoice = new Invoice();
		converter.buildCedentePrestatore(cedentePrestatoreType, invoice);
		assertThat(invoice.getInvoiceParticipants()).hasSize(1);
		InvoiceParticipant invoiceCedentePrestatore = invoice.getInvoiceParticipants().iterator().next();
		assertThat(invoiceCedentePrestatore).isNotNull();
		assertThat(invoiceCedentePrestatore.getType()).isEqualTo(InvoiceParticipantType.CEDENTE_PRESTATORE);
		assertThat(invoiceCedentePrestatore.getAdministrativeReference()).isEqualTo(cedentePrestatoreType.getRiferimentoAmministrazione());
		assertThat(invoiceCedentePrestatore.getCity()).isEqualTo(cedentePrestatoreType.getSede().getComune());
		assertThat(invoiceCedentePrestatore.getClearanceState()).isEqualTo(cedentePrestatoreType.getIscrizioneREA().getStatoLiquidazione().toString());
		assertThat(invoiceCedentePrestatore.getCountry()).isEqualTo(cedentePrestatoreType.getSede().getNazione());
		assertThat(invoiceCedentePrestatore.getDistrict()).isEqualTo(cedentePrestatoreType.getSede().getProvincia());
		assertThat(invoiceCedentePrestatore.getEmailAddress()).isEqualTo(cedentePrestatoreType.getContatti().getEmail());
		checkInvoiceParticipant(
				invoiceCedentePrestatore
				, invoice
				, cedentePrestatoreType.getDatiAnagrafici().getAnagrafica()
				, cedentePrestatoreType.getDatiAnagrafici().getCodiceFiscale()
				, cedentePrestatoreType.getDatiAnagrafici().getIdFiscaleIVA().getIdCodice()
				, cedentePrestatoreType.getDatiAnagrafici().getIdFiscaleIVA().getIdPaese()
				);
		assertThat(invoiceCedentePrestatore.getFaxNumber()).isEqualTo(cedentePrestatoreType.getContatti().getFax());
		assertThat(invoiceCedentePrestatore.getHouseNumber()).isEqualTo(cedentePrestatoreType.getSede().getNumeroCivico());
		assertThat(invoiceCedentePrestatore.getInvoice()).isSameAs(invoice);
		assertThat(invoiceCedentePrestatore.getPermanentEstablishmentCity()).isEqualTo(cedentePrestatoreType.getStabileOrganizzazione().getComune());
		assertThat(invoiceCedentePrestatore.getPermanentEstablishmentCountry()).isEqualTo(cedentePrestatoreType.getStabileOrganizzazione().getNazione());
		assertThat(invoiceCedentePrestatore.getPermanentEstablishmentDistrict()).isEqualTo(cedentePrestatoreType.getStabileOrganizzazione().getProvincia());
		assertThat(invoiceCedentePrestatore.getPermanentEstablishmentHouseNumber()).isEqualTo(cedentePrestatoreType.getStabileOrganizzazione().getNumeroCivico());
		assertThat(invoiceCedentePrestatore.getPermanentEstablishmentStreetAddress()).isEqualTo(cedentePrestatoreType.getStabileOrganizzazione().getIndirizzo());
		assertThat(invoiceCedentePrestatore.getPermanentEstablishmentZipCode()).isEqualTo(cedentePrestatoreType.getStabileOrganizzazione().getCAP());
		assertThat(invoiceCedentePrestatore.getPhoneNumber()).isEqualTo(cedentePrestatoreType.getContatti().getTelefono());
		assertThat(invoiceCedentePrestatore.getProfessionalRegister()).isEqualTo(cedentePrestatoreType.getDatiAnagrafici().getAlboProfessionale());
		assertThat(invoiceCedentePrestatore.getProfessionalRegisterDistrict()).isEqualTo(cedentePrestatoreType.getDatiAnagrafici().getProvinciaAlbo());
		assertThat(invoiceCedentePrestatore.getProfessionalRegisterNumber()).isEqualTo(cedentePrestatoreType.getDatiAnagrafici().getNumeroIscrizioneAlbo());
		compareDates(invoiceCedentePrestatore.getProfessionalRegisterSubscriptionDate(), cedentePrestatoreType.getDatiAnagrafici().getDataIscrizioneAlbo());
		assertThat(invoiceCedentePrestatore.getReaNumber()).isEqualTo(cedentePrestatoreType.getIscrizioneREA().getNumeroREA());
		assertThat(invoiceCedentePrestatore.getReaOffice()).isEqualTo(cedentePrestatoreType.getIscrizioneREA().getUfficio());
		assertThat(invoiceCedentePrestatore.getShareCapital()).isEqualTo(cedentePrestatoreType.getIscrizioneREA().getCapitaleSociale());
		assertThat(invoiceCedentePrestatore.getSoleStakeholder()).isEqualTo(cedentePrestatoreType.getIscrizioneREA().getSocioUnico().toString());
		assertThat(invoiceCedentePrestatore.getStreetAddress()).isEqualTo(cedentePrestatoreType.getSede().getIndirizzo());
		assertThat(invoiceCedentePrestatore.getTaxSystem()).isEqualTo(cedentePrestatoreType.getDatiAnagrafici().getRegimeFiscale().toString());
		assertThat(invoiceCedentePrestatore.getZipCode()).isEqualTo(cedentePrestatoreType.getSede().getCAP());
	}

	private CedentePrestatoreType buildCedentePrestatoreType() throws DatatypeConfigurationException {
		return new CedentePrestatoreType(
				new ContattiType("email", "fax", "telefono")
				, new DatiAnagraficiCedenteType(
						new IdFiscaleType("idCodiceCedentePrestatore", "idPaeseCedentePrestatore")
						, "codiceFiscaleCedentePrestatore"
						, new AnagraficaType("codEORI", "cognome", "denominazione", "nome", "titolo")
						, "alboProfessionale"
						, "provinciaAlbo"
						, "numeroIscrizioneAlbo"
						, DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 5, 12, 4, 5, 6, 7, 0)
						, RegimeFiscaleType.RF_01
						)
				, new IscrizioneREAType(new BigDecimal(123.456), "numeroREA", SocioUnicoType.SM, StatoLiquidazioneType.LN, "ufficio")
				, "riferimentoAmministrazione"
				, new IndirizzoType("cap", "comune", "indirizzo", "nazione", "numeroCivico", "provincia")
				, new IndirizzoType("cap", "comune", "indirizzo", "nazione", "numeroCivico", "provincia")
				);
	}

	@Test
	public void buildCessionarioCommittenteTest() {
		CessionarioCommittenteType cessionarioCommittenteType = buildCessionarioCommittenteType();
		Invoice1_2MappingToEntityConverterImpl converter = new Invoice1_2MappingToEntityConverterImpl();
		Invoice invoice = new Invoice();
		converter.buildCessionarioCommittente(cessionarioCommittenteType, invoice);
		assertThat(invoice.getInvoiceParticipants()).hasSize(1);
		InvoiceParticipant invoiceCessionarioCommittente = invoice.getInvoiceParticipants().iterator().next();
		assertThat(invoiceCessionarioCommittente.getType()).isEqualTo(InvoiceParticipantType.CESSIONARIO_COMMITTENTE);
		assertThat(invoiceCessionarioCommittente).isNotNull();
		assertThat(invoiceCessionarioCommittente.getCity()).isEqualTo(cessionarioCommittenteType.getSede().getComune());
		assertThat(invoiceCessionarioCommittente.getCountry()).isEqualTo(cessionarioCommittenteType.getSede().getNazione());
		assertThat(invoiceCessionarioCommittente.getDistrict()).isEqualTo(cessionarioCommittenteType.getSede().getProvincia());
		checkInvoiceParticipant(
				invoiceCessionarioCommittente
				, invoice
				, cessionarioCommittenteType.getDatiAnagrafici().getAnagrafica()
				, cessionarioCommittenteType.getDatiAnagrafici().getCodiceFiscale()
				, cessionarioCommittenteType.getDatiAnagrafici().getIdFiscaleIVA().getIdCodice()
				, cessionarioCommittenteType.getDatiAnagrafici().getIdFiscaleIVA().getIdPaese()
				);
		assertThat(invoiceCessionarioCommittente.getHouseNumber()).isEqualTo(cessionarioCommittenteType.getSede().getNumeroCivico());
		assertThat(invoiceCessionarioCommittente.getInvoice()).isSameAs(invoice);
		assertThat(invoiceCessionarioCommittente.getPermanentEstablishmentCity()).isEqualTo(cessionarioCommittenteType.getStabileOrganizzazione().getComune());
		assertThat(invoiceCessionarioCommittente.getPermanentEstablishmentCountry()).isEqualTo(cessionarioCommittenteType.getStabileOrganizzazione().getNazione());
		assertThat(invoiceCessionarioCommittente.getPermanentEstablishmentDistrict()).isEqualTo(cessionarioCommittenteType.getStabileOrganizzazione().getProvincia());
		assertThat(invoiceCessionarioCommittente.getPermanentEstablishmentHouseNumber()).isEqualTo(cessionarioCommittenteType.getStabileOrganizzazione().getNumeroCivico());
		assertThat(invoiceCessionarioCommittente.getPermanentEstablishmentStreetAddress()).isEqualTo(cessionarioCommittenteType.getStabileOrganizzazione().getIndirizzo());
		assertThat(invoiceCessionarioCommittente.getPermanentEstablishmentZipCode()).isEqualTo(cessionarioCommittenteType.getStabileOrganizzazione().getCAP());
		assertThat(invoiceCessionarioCommittente.getSocialSecurityNumber()).isEqualTo(cessionarioCommittenteType.getDatiAnagrafici().getCodiceFiscale());
		assertThat(invoiceCessionarioCommittente.getStreetAddress()).isEqualTo(cessionarioCommittenteType.getSede().getIndirizzo());
		assertThat(invoiceCessionarioCommittente.getTaxRepresentativeCountryId()).isEqualTo(cessionarioCommittenteType.getRappresentanteFiscale().getIdFiscaleIVA().getIdPaese());
		assertThat(invoiceCessionarioCommittente.getTaxRepresentativeFirstName()).isEqualTo(cessionarioCommittenteType.getRappresentanteFiscale().getNome());
		assertThat(invoiceCessionarioCommittente.getTaxRepresentativeIdCode()).isEqualTo(cessionarioCommittenteType.getRappresentanteFiscale().getIdFiscaleIVA().getIdCodice());
		assertThat(invoiceCessionarioCommittente.getTaxRepresentativeLastName()).isEqualTo(cessionarioCommittenteType.getRappresentanteFiscale().getCognome());
		assertThat(invoiceCessionarioCommittente.getTaxRepresentativeName()).isEqualTo(cessionarioCommittenteType.getRappresentanteFiscale().getDenominazione());
		assertThat(invoiceCessionarioCommittente.getZipCode()).isEqualTo(cessionarioCommittenteType.getSede().getCAP());
	}

	private CessionarioCommittenteType buildCessionarioCommittenteType() {
		return new CessionarioCommittenteType(
				new DatiAnagraficiCessionarioType(
						new AnagraficaType("codEORI", "cognome", "denominazione", "nome", "titolo")
						, "codiceFiscale"
						, new IdFiscaleType("idCodice", "idPaese")
						)
				, new RappresentanteFiscaleCessionarioType("cognome2", "denominazione2", new IdFiscaleType("idCodice2", "idPaese2"), "nome2")
				, new IndirizzoType("cap", "comune", "indirizzo", "nazione", "numeroCivico", "provincia")
				, new IndirizzoType("cap2", "comune2", "indirizzo2", "nazione2", "numeroCivico2", "provincia2"));
	}

	private DatiBeniServiziType buildDatiBeniServiziType() throws DatatypeConfigurationException {
		DatiRiepilogoType datiRiepilogoType = new DatiRiepilogoType(
				new BigDecimal(0.1)
				, new BigDecimal(0.2)
				, EsigibilitaIVAType.S
				, new BigDecimal(0.3)
				, new BigDecimal(0.4)
				, NaturaType.N_1
				, "riferimentoNormativo"
				, new BigDecimal(0.5)
				);
		List<DatiRiepilogoType> datiRiepilogoTypes = buildOneElementList(datiRiepilogoType, DatiRiepilogoType.class);

		AltriDatiGestionaliType altriDatiGestionaliType = new AltriDatiGestionaliType(
				DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 5, 12, 4, 5, 6, 7, 0)
				, new BigDecimal(0.6)
				, "riferimentoTesto"
				, "tipoDato"
				);
		List<AltriDatiGestionaliType> altriDatiGestionaliTypes = buildOneElementList(altriDatiGestionaliType, AltriDatiGestionaliType.class);

		ScontoMaggiorazioneType scontoMaggiorazioneType = new ScontoMaggiorazioneType(new BigDecimal(1.1), new BigDecimal(1.2), TipoScontoMaggiorazioneType.MG);
		List<ScontoMaggiorazioneType> scontoMaggiorazioneTypes = buildOneElementList(scontoMaggiorazioneType, ScontoMaggiorazioneType.class);

		CodiceArticoloType codiceArticoloType = new CodiceArticoloType("codiceTipo", "codiceValore");
		List<CodiceArticoloType> codiceArticoloTypes = buildOneElementList(codiceArticoloType, CodiceArticoloType.class);

		DettaglioLineeType dettaglioLineeType = new DettaglioLineeType(
				new BigDecimal(0.7)
				, altriDatiGestionaliTypes
				, codiceArticoloTypes
				, DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 5, 13, 4, 5, 6, 7, 0)
				, DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 5, 14, 4, 5, 6, 7, 0)
				, "descrizione"
				, NaturaType.N_1
				, 1
				, new BigDecimal(0.8)
				, new BigDecimal(0.9)
				, new BigDecimal(1.0)
				, "riferimentoAmministrazione"
				, RitenutaType.SI
				, scontoMaggiorazioneTypes
				, TipoCessionePrestazioneType.AB
				, "unitaMisura"
				);

		List<DettaglioLineeType> dettaglioLineeTypes = buildOneElementList(dettaglioLineeType, DettaglioLineeType.class);

		return new DatiBeniServiziType(datiRiepilogoTypes, dettaglioLineeTypes);
	}

	private DatiDocumentiCorrelatiType buildDatiDocumentiCorrelati(String suffix, int dataIncrement, Integer riferimentoNumeroLinea) throws DatatypeConfigurationException {
		List<Integer> riferimentiNumeroLinea = null;
		if(riferimentoNumeroLinea != null)
			riferimentiNumeroLinea = buildOneElementList(riferimentoNumeroLinea, Integer.class);
		DatiDocumentiCorrelatiType datiDocumentiCorrelatiType = new DatiDocumentiCorrelatiType(
				"codiceCIG" + suffix
				, "codiceCommessaConvenzione" + suffix
				, "codiceCUP" + suffix
				, DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 1, 1 + dataIncrement, 4, 5, 6, 7, 0)
				, "idDocumento" + suffix
				, "numItem" + suffix
				, riferimentiNumeroLinea);
		return datiDocumentiCorrelatiType;
	}

	@Test
	public void buildDatiGeneraliTest() throws DatatypeConfigurationException {
		Invoice1_2MappingToEntityConverterImpl converter = new Invoice1_2MappingToEntityConverterImpl();
		Invoice invoice = new Invoice();
		invoice.setNumber("123456");
		Integer purchaseLineId = 1;
		invoice.setPurchaseLines(buildOneElementSet(new PurchaseLine(purchaseLineId.toString(), invoice), PurchaseLine.class));
		DatiGeneraliType datiGeneraliType = buildDatiGeneraliType(purchaseLineId);
		converter.buildDatiGenerali(datiGeneraliType, invoice);
		Set<DocumentoCorrelato> datiDdt = invoice.getDocumentiCorrelati().stream()
				.filter(d -> d.getDocumentoCorrelatoType().equals(DocumentoCorrelatoType.DDT))
				.collect(Collectors.toSet());
		assertThat(datiDdt).hasSameSizeAs(datiGeneraliType.getDatiDDT());
		DocumentoCorrelato datoDdt = datiDdt.iterator().next();
		compareDates(datoDdt.getData(), datiGeneraliType.getDatiDDT().get(0).getDataDDT());
		assertThat(datoDdt.getInvoice()).isSameAs(invoice);
		assertThat(datoDdt.getDocumentId()).contains(datiGeneraliType.getDatiDDT().get(0).getNumeroDDT());
		assertThat(datoDdt.getPurchaseLine()).hasSameElementsAs(invoice.getPurchaseLines());
		assertThat(datoDdt.getDocumentoCorrelatoType()).isEqualTo(DocumentoCorrelatoType.DDT);
		checkDocumentiCorrelati(datiGeneraliType.getDatiContratto(), invoice, DocumentoCorrelatoType.CONTRATTO);
		checkDocumentiCorrelati(datiGeneraliType.getDatiConvenzione(), invoice, DocumentoCorrelatoType.CONVENZIONE);
		checkDocumentiCorrelati(datiGeneraliType.getDatiFattureCollegate(), invoice, DocumentoCorrelatoType.FATTURA_COLLEGATA);
		checkDocumentiCorrelati(datiGeneraliType.getDatiOrdineAcquisto(), invoice, DocumentoCorrelatoType.ORDINE_ACQUISTO);
		checkDocumentiCorrelati(datiGeneraliType.getDatiRicezione(), invoice, DocumentoCorrelatoType.RICEZIONE);
		assertThat(invoice.getRiferimentoFase()).isEqualTo(datiGeneraliType.getDatiSAL().get(0).getRiferimentoFase());

		assertThat(invoice.getCausaleTrasporto()).isEqualTo(datiGeneraliType.getDatiTrasporto().getCausaleTrasporto());
		compareDates(invoice.getDataInizioTrasporto(), datiGeneraliType.getDatiTrasporto().getDataInizioTrasporto());
		compareDates(invoice.getDataOraConsegna(), datiGeneraliType.getDatiTrasporto().getDataOraConsegna());
		compareDates(invoice.getDataOraRitiro(), datiGeneraliType.getDatiTrasporto().getDataOraRitiro());
		assertThat(invoice.getInvoiceParticipants()).hasSize(1);
		InvoiceParticipant vettore = invoice.getInvoiceParticipants().iterator().next();
		assertThat(vettore).isNotNull();
		assertThat(vettore.getType()).isEqualTo(InvoiceParticipantType.VETTORE);
		checkInvoiceParticipant(
				vettore
				, invoice
				, datiGeneraliType.getDatiTrasporto().getDatiAnagraficiVettore().getAnagrafica()
				, datiGeneraliType.getDatiTrasporto().getDatiAnagraficiVettore().getCodiceFiscale()
				, datiGeneraliType.getDatiTrasporto().getDatiAnagraficiVettore().getIdFiscaleIVA().getIdCodice()
				, datiGeneraliType.getDatiTrasporto().getDatiAnagraficiVettore().getIdFiscaleIVA().getIdPaese()
				);
		assertThat(vettore.getNumeroLicenzaGuida()).isEqualTo(datiGeneraliType.getDatiTrasporto().getDatiAnagraficiVettore().getNumeroLicenzaGuida());

		assertThat(invoice.getDescrizioneTrasporto()).isEqualTo(datiGeneraliType.getDatiTrasporto().getDescrizione());
		assertThat(invoice.getCapResa()).isEqualTo(datiGeneraliType.getDatiTrasporto().getIndirizzoResa().getCAP());
		assertThat(invoice.getComuneResa()).isEqualTo(datiGeneraliType.getDatiTrasporto().getIndirizzoResa().getComune());
		assertThat(invoice.getIndirizzoResa()).isEqualTo(datiGeneraliType.getDatiTrasporto().getIndirizzoResa().getIndirizzo());
		assertThat(invoice.getNazioneResa()).isEqualTo(datiGeneraliType.getDatiTrasporto().getIndirizzoResa().getNazione());
		assertThat(invoice.getNumeroCivicoResa()).isEqualTo(datiGeneraliType.getDatiTrasporto().getIndirizzoResa().getNumeroCivico());
		assertThat(invoice.getProvinciaResa()).isEqualTo(datiGeneraliType.getDatiTrasporto().getIndirizzoResa().getProvincia());

		assertThat(invoice.getMezzoTrasporto()).isEqualTo(datiGeneraliType.getDatiTrasporto().getMezzoTrasporto());
		assertThat(invoice.getNumeroColli()).isEqualTo(datiGeneraliType.getDatiTrasporto().getNumeroColli());
		assertThat(invoice.getPesoLordo()).isEqualTo(datiGeneraliType.getDatiTrasporto().getPesoLordo());
		assertThat(invoice.getPesoNetto()).isEqualTo(datiGeneraliType.getDatiTrasporto().getPesoNetto());
		assertThat(invoice.getTipoResa()).isEqualTo(datiGeneraliType.getDatiTrasporto().getTipoResa());
		assertThat(invoice.getUnitaMisuraPeso()).isEqualTo(datiGeneraliType.getDatiTrasporto().getUnitaMisuraPeso());

		List<DatiCassaPrevidenzialeType> datiCassaPrevidenzialeTypes = datiGeneraliType.getDatiGeneraliDocumento().getDatiCassaPrevidenziale();
		DatiCassaPrevidenzialeType datiCassaPrevidenziale = datiCassaPrevidenzialeTypes.get(0);
		assertThat(invoice.getAlCassa()).isEqualTo(datiCassaPrevidenziale.getAlCassa());
		assertThat(invoice.getAliquotaIvaCassa()).isEqualTo(datiCassaPrevidenziale.getAliquotaIVA());
		assertThat(invoice.getImponibileCassa()).isEqualTo(datiCassaPrevidenziale.getImponibileCassa());
		assertThat(invoice.getImportoContributoCassa()).isEqualTo(datiCassaPrevidenziale.getImportoContributoCassa());
		assertThat(invoice.getNaturaCassa()).isEqualTo(datiCassaPrevidenziale.getNatura());
		assertThat(invoice.getRiferimentoAmministrazioneCassa()).isEqualTo(datiCassaPrevidenziale.getRiferimentoAmministrazione());
		assertThat(invoice.getRitenutaCassa()).isEqualTo(datiCassaPrevidenziale.getRitenuta());
		assertThat(invoice.getTipoCassa()).isEqualTo(datiCassaPrevidenziale.getTipoCassa());

		assertThat(invoice.getAliquotaRitenuta()).isEqualTo(datiGeneraliType.getDatiGeneraliDocumento().getDatiRitenuta().getAliquotaRitenuta());
		assertThat(invoice.getCausalePagamentoRitenuta()).isEqualTo(datiGeneraliType.getDatiGeneraliDocumento().getDatiRitenuta().getCausalePagamento().toString());
		assertThat(invoice.getImportoRitenuta()).isEqualTo(datiGeneraliType.getDatiGeneraliDocumento().getDatiRitenuta().getImportoRitenuta());
		assertThat(invoice.getTipoRitenuta()).isEqualTo(datiGeneraliType.getDatiGeneraliDocumento().getDatiRitenuta().getTipoRitenuta().toString());

		compareDates(invoice.getMainInvoiceDate(), datiGeneraliType.getFatturaPrincipale().getDataFatturaPrincipale());
		assertThat(invoice.getMainInvoiceNumber()).isEqualTo(datiGeneraliType.getFatturaPrincipale().getNumeroFatturaPrincipale());

		assertThat(invoice.getArt73()).isEqualTo(datiGeneraliType.getDatiGeneraliDocumento().getArt73().toString());

		assertThat(invoice.getStampAmount()).isEqualTo(datiGeneraliType.getDatiGeneraliDocumento().getDatiBollo().getImportoBollo());
		assertThat(invoice.getVirtualStamp()).isEqualTo(datiGeneraliType.getDatiGeneraliDocumento().getDatiBollo().getBolloVirtuale().toString());

		assertThat(invoice.getDescription()).isEqualTo(String.join("", datiGeneraliType.getDatiGeneraliDocumento().getCausale()));

		ScontoMaggiorazioneType scontoMaggiorazioneType = datiGeneraliType.getDatiGeneraliDocumento().getScontoMaggiorazione().iterator().next();
		assertThat(invoice.getDiscountAmount()).isEqualTo(scontoMaggiorazioneType.getImporto());
		assertThat(invoice.getDiscountPercentage()).isEqualTo(scontoMaggiorazioneType.getPercentuale());
		assertThat(invoice.getDiscountType()).isEqualTo(scontoMaggiorazioneType.getTipo().toString());

		assertThat(invoice.getCurrency()).isEqualTo(datiGeneraliType.getDatiGeneraliDocumento().getDivisa());
		compareDates(invoice.getDate(), datiGeneraliType.getDatiGeneraliDocumento().getData());
		assertThat(invoice.getDocumentTypeCode()).isEqualTo(datiGeneraliType.getDatiGeneraliDocumento().getTipoDocumento().toString());
		assertThat(invoice.getRounding()).isEqualTo(datiGeneraliType.getDatiGeneraliDocumento().getArrotondamento());
		assertThat(invoice.getTotalAmount()).isEqualTo(datiGeneraliType.getDatiGeneraliDocumento().getImportoTotaleDocumento());
	}

	private DatiGeneraliType buildDatiGeneraliType(Integer purchaseLineId) throws DatatypeConfigurationException {
		List<DatiDocumentiCorrelatiType> datiContratto = buildOneElementList(buildDatiDocumentiCorrelati("Contratto", 1, purchaseLineId), DatiDocumentiCorrelatiType.class);
		List<DatiDocumentiCorrelatiType> datiConvenzione = buildOneElementList(buildDatiDocumentiCorrelati("Convenzione", 2, purchaseLineId), DatiDocumentiCorrelatiType.class);
		List<DatiDocumentiCorrelatiType> datiFattureCollegate = buildOneElementList(buildDatiDocumentiCorrelati("FattureCollegate", 3, purchaseLineId), DatiDocumentiCorrelatiType.class);
		List<DatiDocumentiCorrelatiType> datiOrdineAcquisto = buildOneElementList(buildDatiDocumentiCorrelati("OrdineAcquisto", 4, purchaseLineId), DatiDocumentiCorrelatiType.class);
		List<DatiDocumentiCorrelatiType> datiRicezione = buildOneElementList(buildDatiDocumentiCorrelati("Ricezione", 5, purchaseLineId), DatiDocumentiCorrelatiType.class);

		List<DatiDDTType> datiDDT = buildOneElementList(new DatiDDTType(
				DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 1, 6, 4, 5, 6, 7, 0)
				, "numeroDDT"
				, buildOneElementList(1, Integer.class))
				, DatiDDTType.class);
		List<DatiSALType> datiSAL = buildOneElementList(new DatiSALType(0), DatiSALType.class);

		List<DatiCassaPrevidenzialeType> datiCassaPrevidenziale = buildOneElementList(
				new DatiCassaPrevidenzialeType(
						new BigDecimal(0.7)
						, new BigDecimal(0.8)
						, new BigDecimal(0.9)
						, new BigDecimal(1.0)
						, NaturaType.N_1
						, "riferimentoAmministrazione"
						, RitenutaType.SI
						, TipoCassaType.TC_01
						)
				, DatiCassaPrevidenzialeType.class);

		List<ScontoMaggiorazioneType> scontoMaggiorazione = buildOneElementList(new ScontoMaggiorazioneType(
				new BigDecimal(1.1)
				, new BigDecimal(1.2)
				, TipoScontoMaggiorazioneType.MG), ScontoMaggiorazioneType.class);

		List<String> causale = buildOneElementList("causale", String.class);

		return new DatiGeneraliType(
				datiContratto
				, datiConvenzione
				, datiDDT
				, datiFattureCollegate
				, new DatiGeneraliDocumentoType(
						new BigDecimal(0.3)
						, Art73Type.SI
						, causale
						, DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 5, 16, 4, 5, 6, 7, 0)
						, new DatiBolloType(BolloVirtualeType.SI, new BigDecimal(0.5))
						, datiCassaPrevidenziale
						, new DatiRitenutaType(new BigDecimal(0.5), CausalePagamentoType.A, new BigDecimal(0.6), TipoRitenutaType.RT_01)
						, "divisa"
						, new BigDecimal(0.4)
						, "numero"
						, scontoMaggiorazione
						, TipoDocumentoType.TD_01
						)
				, datiOrdineAcquisto
				, datiRicezione
				, datiSAL
				, new DatiTrasportoType(
						"causaleTrasporto"
						, DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 5, 13, 4, 5, 6, 7, 0)
						, DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 5, 14, 4, 5, 6, 7, 0)
						, DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 5, 15, 4, 5, 6, 7, 0)
						, new DatiAnagraficiVettoreType(
								new AnagraficaType("codEORIVettore", "cognomeVettore", "denominazioneVettore", "nomeVettore", "titoloVettore")
								, "codiceFiscaleVettore"
								, new IdFiscaleType("idCodiceVettore", "idPaeseVettore")
								, "numeroLicenzaGuida"
								)
						, "descrizione"
						, new IndirizzoType(
								"capTrasporto"
								, "comuneTrasporto"
								, "indirizzoTrasporto"
								, "nazioneTrasporto"
								, "numeroCivicoTrasporto"
								, "provinciaTrasporto"
								)
						, "mezzoTrasporto"
						, 1
						, new BigDecimal(0.1)
						, new BigDecimal(0.2)
						, "tipoResaTrasporto"
						, "unitaMisuraPesoTrasporto"
						)
				, new FatturaPrincipaleType(
						DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 5, 12, 4, 5, 6, 7, 0)
						, "numeroFatturaPrincipale")
				);
	}

	@Test
	public void buildDatiPagamentoTest() throws DatatypeConfigurationException {
		Invoice1_2MappingToEntityConverterImpl converter = new Invoice1_2MappingToEntityConverterImpl();
		Invoice invoice = new Invoice();
		invoice.setNumber("123456");
		List<DatiPagamentoType> datiPagamentoTypes = buildDatiPagamentoTypes();
		DatiPagamentoType datiPagamentoType = datiPagamentoTypes.get(0);
		converter.buildDatiPagamento(datiPagamentoTypes, invoice);

		compareDates(invoice.getDataDecorrenzaPenalePagamento(), datiPagamentoType.getDettaglioPagamento().get(0).getDataDecorrenzaPenale());
		compareDates(invoice.getDataLimitePagamentoAnticipatoPagamento(), datiPagamentoType.getDettaglioPagamento().get(0).getDataLimitePagamentoAnticipato());
		compareDates(invoice.getDataRiferimentoTerminiPagamento(), datiPagamentoType.getDettaglioPagamento().get(0).getDataRiferimentoTerminiPagamento());
		compareDates(invoice.getPaymentExpirationDate(), datiPagamentoType.getDettaglioPagamento().get(0).getDataScadenzaPagamento());

		assertThat(invoice.getFinancialInstitutionAbi()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getABI());
		assertThat(invoice.getFinancialInstitutionBic()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getBIC());
		assertThat(invoice.getFinancialInstitutionCab()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getCAB());
		assertThat(invoice.getFinancialInstitutionIban()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getIBAN());
		assertThat(invoice.getFinancialInstitutionName()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getIstitutoFinanziario());
		assertThat(invoice.getPaymentConditions()).isEqualTo(datiPagamentoType.getCondizioniPagamento().toString());
		assertThat(invoice.getPaymentAmount()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getImportoPagamento());
		assertThat(invoice.getPaymentMode()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getModalitaPagamento().toString());
		assertThat(invoice.getPaymentTermDays()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getGiorniTerminiPagamento());
		assertThat(invoice.getPaymentMode()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getModalitaPagamento().toString());
		assertThat(invoice.getPaymentTermDays()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getGiorniTerminiPagamento());
		assertThat(invoice.getBeneficiarioPagamento()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getBeneficiario());
		assertThat(invoice.getCfQuietanzantePagamento()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getCFQuietanzante());
		assertThat(invoice.getCodicePagamento()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getCodicePagamento());
		assertThat(invoice.getCodUfficioPostalePagamento()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getCodUfficioPostale());
		assertThat(invoice.getCognomeQuietanzantePagamento()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getCognomeQuietanzante());
		assertThat(invoice.getNomeQuietanzantePagamento()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getNomeQuietanzante());
		assertThat(invoice.getPenalitaPagamentiRitardatiPagamento()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getPenalitaPagamentiRitardati());
		assertThat(invoice.getScontoPagamentoAnticipatoPagamento()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getScontoPagamentoAnticipato());
		assertThat(invoice.getTitoloQuietanzantePagamento()).isEqualTo(datiPagamentoType.getDettaglioPagamento().get(0).getTitoloQuietanzante());
	}

	private List<DatiPagamentoType> buildDatiPagamentoTypes() throws DatatypeConfigurationException{
		DatiPagamentoType datiPagamentoType = new DatiPagamentoType(CondizioniPagamentoType.TP_01
				, new ArrayList<>());
		List<DatiPagamentoType> datiPagamentoTypes = buildOneElementList(datiPagamentoType, DatiPagamentoType.class);
		datiPagamentoType.getDettaglioPagamento().add(new DettaglioPagamentoType(
				"abi"
				, "beneficiario"
				, "bic"
				, "cab"
				, "cfQuietanzante"
				, "codicePagamento"
				, "codUfficioPostale"
				, "cognomeQuietanzante"
				, DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 5, 12, 4, 5, 6, 7, 0)
				, DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 5, 13, 4, 5, 6, 7, 0)
				, DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 5, 14, 4, 5, 6, 7, 0)
				, DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 5, 15, 4, 5, 6, 7, 0)
				, 10
				, "iban"
				, new BigDecimal(0.1)
				, "istitutoFinanziario"
				, ModalitaPagamentoType.MP_01
				, "nomeQuietanzante"
				, new BigDecimal(0.2)
				, new BigDecimal(0.3)
				, "titoloQuietanzante"
				));
		return datiPagamentoTypes;
	}

	private DatiTrasmissioneType buildDatiTrasmissioneType() {
		return new DatiTrasmissioneType(
				"codiceDestinatarioDatiTrasmissione"
				, new ContattiTrasmittenteType("emailDatiTrasmissione", "telefonoDatiTrasmissione")
				, FormatoTrasmissioneType.FPA_12
				, new IdFiscaleType("idCodiceDatiTrasmissione", "idPaeseDatiTrasmissione")
				, "pecDestinatarioDatiTrasmissione"
				, "progressivoInvioDatiTrasmissione"
				);
	}

	@Test
	public void buildDatiVeicoliTest() throws DatatypeConfigurationException {
		DatiVeicoliType datiVeicoliType = buildDatiVeicoliType();
		Invoice1_2MappingToEntityConverterImpl converter = new Invoice1_2MappingToEntityConverterImpl();
		Invoice invoice = new Invoice();
		invoice.setNumber("123456");
		converter.buildDatiVeicoli(datiVeicoliType, invoice);
		compareDates(invoice.getDataVeicoli(), datiVeicoliType.getData());
		assertThat(invoice.getTotalePercorsoVeicoli()).isEqualTo(datiVeicoliType.getTotalePercorso());
	}

	private DatiVeicoliType buildDatiVeicoliType() throws DatatypeConfigurationException {
		return new DatiVeicoliType(
				DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 5, 12, 4, 5, 6, 7, 0)
				, "totalePercorso"
				);
	}

	@Test
	public void buildInvoiceItemsTest() throws DatatypeConfigurationException {
		Invoice1_2MappingToEntityConverterImpl converter = new Invoice1_2MappingToEntityConverterImpl();
		Invoice invoice = new Invoice();
		invoice.setNumber("123456");
		DatiBeniServiziType datiBeniServizi = buildDatiBeniServiziType();
		List<DatiRiepilogoType> datiRiepilogoTypes = datiBeniServizi.getDatiRiepilogo();
		DatiRiepilogoType datiRiepilogoType = datiRiepilogoTypes.get(0);
		converter.buildInvoiceItems(datiBeniServizi, invoice);
		Set<DatiRiepilogo> datiRiepilogo = invoice.getDatiRiepilogo();
		assertThat(datiRiepilogo).hasSameSizeAs(datiRiepilogoTypes);
		DatiRiepilogo dr = datiRiepilogo.iterator().next();
		assertThat(dr.getAliquotaIVA()).isEqualTo(datiRiepilogoType.getAliquotaIVA());
		assertThat(dr.getArrotondamento()).isEqualTo(datiRiepilogoType.getArrotondamento());
		assertThat(dr.getEsigibilitaIVA()).isEqualTo(datiRiepilogoType.getEsigibilitaIVA().toString());
		assertThat(dr.getImponibileImporto()).isEqualTo(datiRiepilogoType.getImponibileImporto());
		assertThat(dr.getImposta()).isEqualTo(datiRiepilogoType.getImposta());
		assertThat(dr.getInvoice()).isSameAs(invoice);
		assertThat(dr.getNatura()).isEqualTo(datiRiepilogoType.getNatura().toString());
		assertThat(dr.getRiferimentoNormativo()).isEqualTo(datiRiepilogoType.getRiferimentoNormativo());
		assertThat(dr.getSpeseAccessorie()).isEqualTo(datiRiepilogoType.getSpeseAccessorie());

		List<DettaglioLineeType> dettaglioLineeTypes = datiBeniServizi.getDettaglioLinee();
		DettaglioLineeType dettaglioLineeType = dettaglioLineeTypes.get(0);
		Set<PurchaseLine> purchaseLines = invoice.getPurchaseLines();
		assertThat(purchaseLines).hasSize(dettaglioLineeTypes.size());
		PurchaseLine purchaseLine = purchaseLines.iterator().next();
		assertThat(purchaseLine.getAdministrativeReference()).isEqualTo(dettaglioLineeType.getRiferimentoAmministrazione());
		assertThat(purchaseLine.getInvoice()).isSameAs(invoice);

		CodiceArticoloType codiceArticoloType = dettaglioLineeType.getCodiceArticolo().get(0);
		assertThat(purchaseLine.getItemCode()).isEqualTo(codiceArticoloType.getCodiceValore());
		assertThat(purchaseLine.getItemCodeType()).isEqualTo(codiceArticoloType.getCodiceTipo());
		assertThat(purchaseLine.getItemDescription()).isEqualTo(dettaglioLineeType.getDescrizione());
		assertThat(purchaseLine.getKind()).isEqualTo(dettaglioLineeType.getNatura().toString());
		AltriDatiGestionaliType altriDatiGestionaliType = dettaglioLineeType.getAltriDatiGestionali().get(0);
		compareDates(purchaseLine.getOtherManagementDataDate(), altriDatiGestionaliType.getRiferimentoData());
		assertThat(purchaseLine.getOtherManagementDataReferenceNumber()).isEqualTo(altriDatiGestionaliType.getRiferimentoNumero());
		assertThat(purchaseLine.getOtherManagementDataReferenceText()).isEqualTo(altriDatiGestionaliType.getRiferimentoTesto());
		assertThat(purchaseLine.getOtherManagementDataDataType()).isEqualTo(altriDatiGestionaliType.getTipoDato());

		compareDates(purchaseLine.getPeriodEndDate(), dettaglioLineeType.getDataFinePeriodo());
		compareDates(purchaseLine.getPeriodStartDate(), dettaglioLineeType.getDataInizioPeriodo());

		assertThat(purchaseLine.getRitenuta()).isEqualTo(dettaglioLineeType.getRitenuta().toString());

		assertThat(purchaseLine.getQuantity()).isEqualTo(dettaglioLineeType.getQuantita());

		ScontoMaggiorazioneType scontoMaggiorazioneType = dettaglioLineeType.getScontoMaggiorazione().get(0);
		assertThat(purchaseLine.getScontoMaggiorazioneAmount()).isEqualTo(scontoMaggiorazioneType.getImporto());
		assertThat(purchaseLine.getScontoMaggiorazionePercentage()).isEqualTo(scontoMaggiorazioneType.getPercentuale());
		assertThat(purchaseLine.getScontoMaggiorazioneType()).isEqualTo(scontoMaggiorazioneType.getTipo().toString());

		assertThat(purchaseLine.getTaxRate()).isEqualTo(dettaglioLineeType.getAliquotaIVA());
		assertThat(purchaseLine.getTipoCessazionePrestazione()).isEqualTo(dettaglioLineeType.getTipoCessionePrestazione().toString());
		assertThat(purchaseLine.getTotalPrice()).isEqualTo(dettaglioLineeType.getPrezzoTotale());
		assertThat(purchaseLine.getUnitOfMeasureDescription()).isEqualTo(dettaglioLineeType.getUnitaMisura());
		assertThat(purchaseLine.getUnitPrice()).isEqualTo(dettaglioLineeType.getPrezzoUnitario());
	}

	@Test
	public void buildInvoiceSendingTest() {
		DatiTrasmissioneType datiTrasmissione = buildDatiTrasmissioneType();
		Invoice1_2MappingToEntityConverterImpl converter = new Invoice1_2MappingToEntityConverterImpl();
		Invoice invoice = new Invoice();
		converter.buildInvoiceSending(datiTrasmissione, invoice);
		assertThat(invoice.getInvoiceRecipientCertifiedEmailAddress()).isEqualTo(datiTrasmissione.getPECDestinatario());
		assertThat(invoice.getInvoiceRecipientCode()).isEqualTo(datiTrasmissione.getCodiceDestinatario());
		assertThat(invoice.getInvoiceSenderCode()).isEqualTo(datiTrasmissione.getIdTrasmittente().getIdCodice());
		assertThat(invoice.getInvoiceSenderCountryCode()).isEqualTo(datiTrasmissione.getIdTrasmittente().getIdPaese());
		assertThat(invoice.getInvoiceSenderEmailAddress()).isEqualTo(datiTrasmissione.getContattiTrasmittente().getEmail());
		assertThat(invoice.getInvoiceSenderPhoneNumber()).isEqualTo(datiTrasmissione.getContattiTrasmittente().getTelefono());
		assertThat(invoice.getInvoiceSendingFormat()).isEqualTo(datiTrasmissione.getFormatoTrasmissione().toString());
		assertThat(invoice.getInvoiceSendingNumber()).isEqualTo(datiTrasmissione.getProgressivoInvio());
		assertThat(invoice.getVersion()).isEqualTo(datiTrasmissione.getFormatoTrasmissione().version());
	}

	private <T> List<T> buildOneElementList(T element, Class<T> clazz){
		List<T> list = new ArrayList<>();
		list.add(element);
		return list;
	}

	private <T> Set<T> buildOneElementSet(T element, Class<T> clazz){
		Set<T> set = new HashSet<>();
		set.add(element);
		return set;
	}

	@Test
	public void buildRappresentanteFiscaleTest() {
		Invoice1_2MappingToEntityConverterImpl converter = new Invoice1_2MappingToEntityConverterImpl();
		Invoice invoice = new Invoice();
		RappresentanteFiscaleType rappresentanteFiscaleType = buildRappresentanteFiscaleType();
		converter.buildRappresentanteFiscale(rappresentanteFiscaleType, invoice);
		assertThat(invoice.getInvoiceParticipants()).hasSize(1);
		InvoiceParticipant rappresentanteFiscale = invoice.getInvoiceParticipants().iterator().next();
		assertThat(rappresentanteFiscale).isNotNull();
		assertThat(rappresentanteFiscale.getType()).isEqualTo(InvoiceParticipantType.RAPPRESENTANTE_FISCALE);
		checkInvoiceParticipant(
				rappresentanteFiscale
				, invoice
				, rappresentanteFiscaleType.getDatiAnagrafici().getAnagrafica()
				, rappresentanteFiscaleType.getDatiAnagrafici().getCodiceFiscale()
				, rappresentanteFiscaleType.getDatiAnagrafici().getIdFiscaleIVA().getIdCodice()
				, rappresentanteFiscaleType.getDatiAnagrafici().getIdFiscaleIVA().getIdPaese()
				);
	}


	private RappresentanteFiscaleType buildRappresentanteFiscaleType() {
		return new RappresentanteFiscaleType(new DatiAnagraficiRappresentanteType(
				new AnagraficaType(
						"codEORIRappresentanteFiscaleType"
						, "cognomeRappresentanteFiscaleType"
						, "denominazioneRappresentanteFiscaleType"
						, "nomeRappresentanteFiscaleType"
						, "titoloRappresentanteFiscaleType"
						)
				, "codiceFiscaleRappresentanteFiscaleType"
				, new IdFiscaleType("idCodiceRappresentanteFiscaleType", "idPaeseRappresentanteFiscaleType")
				)
				);
	}

	@Test
	public void buildSoggettoEmittenteTest() {
		TerzoIntermediarioSoggettoEmittenteType terzoIntermediarioSoggettoEmittenteType = buildTerzoIntermediarioSoggettoEmittenteType();
		Invoice1_2MappingToEntityConverterImpl converter = new Invoice1_2MappingToEntityConverterImpl();
		Invoice invoice = new Invoice();
		SoggettoEmittenteType soggettoEmittenteType = SoggettoEmittenteType.TZ;
		converter.buildSoggettoEmittente(soggettoEmittenteType, terzoIntermediarioSoggettoEmittenteType, invoice);
		assertThat(invoice.getSoggettoEmittenteType()).isEqualTo(soggettoEmittenteType.toString());
		assertThat(invoice.getInvoiceParticipants()).hasSize(1);
		InvoiceParticipant soggettoEmittente = invoice.getInvoiceParticipants().iterator().next();
		assertThat(soggettoEmittente).isNotNull();
		assertThat(soggettoEmittente.getType()).isEqualTo(InvoiceParticipantType.SOGGETTO_EMITTENTE);
		assertThat(soggettoEmittente.getInvoice()).isSameAs(invoice);
		checkInvoiceParticipant(
				soggettoEmittente
				, invoice
				, terzoIntermediarioSoggettoEmittenteType.getDatiAnagrafici().getAnagrafica()
				, terzoIntermediarioSoggettoEmittenteType.getDatiAnagrafici().getCodiceFiscale()
				, terzoIntermediarioSoggettoEmittenteType.getDatiAnagrafici().getIdFiscaleIVA().getIdCodice()
				, terzoIntermediarioSoggettoEmittenteType.getDatiAnagrafici().getIdFiscaleIVA().getIdPaese()
				);
	}

	private TerzoIntermediarioSoggettoEmittenteType buildTerzoIntermediarioSoggettoEmittenteType() {
		return new TerzoIntermediarioSoggettoEmittenteType(
				new DatiAnagraficiTerzoIntermediarioType(
						new AnagraficaType("codEORITer", "cognomeTer", "denominazioneTer", "nomeTer", "titoloTer")
						, "codiceFiscaleTer"
						, new IdFiscaleType("idCodiceTer", "idPaeseTer")
						)
				);
	}

	public void canConvertTest() {
		assertThat(new Invoice1_2MappingToEntityConverterImpl().canConvert(FatturaElettronicaType.class)).isFalse();
	}

	private void checkDocumentiCorrelati(
			List<DatiDocumentiCorrelatiType> datiDocumentiCorrelatiTypes
			, Invoice invoice
			, DocumentoCorrelatoType documentoCorrelatoType
			) {
		Set<DocumentoCorrelato> documentiCorrelati = invoice.getDocumentiCorrelati().stream()
				.filter(d -> d.getDocumentoCorrelatoType().equals(documentoCorrelatoType))
				.collect(Collectors.toSet());
		for(DocumentoCorrelato documentoCorrelato : documentiCorrelati)
			assertThat(documentoCorrelato.getInvoice()).isSameAs(invoice);
		assertThat(documentiCorrelati).hasSameSizeAs(datiDocumentiCorrelatiTypes);
		for(DocumentoCorrelato documentoCorrelato : documentiCorrelati) {
			// Search for the relevant source data
			List<DatiDocumentiCorrelatiType> related = datiDocumentiCorrelatiTypes.stream()
					.filter(c -> 
					checkDocumentoCorrelatoFieldValue(documentoCorrelato.getCigCode(), c.getCodiceCIG())
					&& checkDocumentoCorrelatoFieldValue(documentoCorrelato.getCodiceCommessaConvenzione(), c.getCodiceCommessaConvenzione())
					&& checkDocumentoCorrelatoFieldValue(documentoCorrelato.getCodiceCUP(), c.getCodiceCUP())
					&& compareDates(documentoCorrelato.getData(), c.getData())
					&& checkDocumentoCorrelatoFieldValue(documentoCorrelato.getDocumentId(), c.getIdDocumento())
					&& checkDocumentoCorrelatoFieldValue(documentoCorrelato.getNumItem(), c.getNumItem())
					&& (
							documentoCorrelato.getPurchaseLine() == null ?
									true : documentoCorrelato.getPurchaseLine().stream().filter(
											d -> c.getRiferimentoNumeroLinea().contains(Integer.parseInt(d.getDocumentId()))
											)
									.collect(Collectors.toSet()).size() == 1)
							)
					.collect(Collectors.toList());
			assertThat(related).hasSize(1);
			assertThat(documentoCorrelato.getDocumentoCorrelatoType()).isEqualTo(documentoCorrelatoType);
		}
	}

	private boolean checkDocumentoCorrelatoFieldValue(Object value, Object other) {
		return value != null ? value.equals(other) : true;
	}

	private void checkInvoiceParticipant(
			InvoiceParticipant invoiceParticipant
			, Invoice invoice
			, AnagraficaType anagraficaType
			, String socialSecurityNumber
			, String taxCodeId
			, String taxCountryCode
			) {
		assertThat(invoiceParticipant.getEoriCode()).isEqualTo(anagraficaType.getCodEORI());
		assertThat(invoiceParticipant.getInvoice()).isSameAs(invoice);
		assertThat(invoiceParticipant.getLastName()).isEqualTo(anagraficaType.getCognome());
		assertThat(invoiceParticipant.getName()).isEqualTo(anagraficaType.getDenominazione());
		assertThat(invoiceParticipant.getFirstName()).isEqualTo(anagraficaType.getNome());
		assertThat(invoiceParticipant.getTitle()).isEqualTo(anagraficaType.getTitolo());

		assertThat(invoiceParticipant.getSocialSecurityNumber()).isEqualTo(socialSecurityNumber);

		assertThat(invoiceParticipant.getTaxCode()).isEqualTo(taxCodeId);
		assertThat(invoiceParticipant.getTaxCountryCode()).isEqualTo(taxCountryCode);
	}

	private boolean compareDates(Date date, XMLGregorianCalendar xmlGregorianCalendar) {
		LocalDate localDate = date.toLocalDate();
		assertThat(localDate.getYear()).isEqualTo(xmlGregorianCalendar.getYear());
		assertThat(localDate.getMonth().getValue()).isEqualTo(xmlGregorianCalendar.getMonth());
		assertThat(localDate.getDayOfMonth()).isEqualTo(xmlGregorianCalendar.getDay());

		// Reached only if the previous assertions are true
		return true;
	}

	@Test
	public void convertTest() throws DatatypeConfigurationException {
		Invoice invoice = new Invoice1_2MappingToEntityConverterImpl().convert(
				new FatturaElettronicaType(
						buildOneElementList(
								new FatturaElettronicaBodyType(
										buildAllegatiTypes()
										, buildDatiBeniServiziType()
										, buildDatiGeneraliType(1)
										, buildDatiPagamentoTypes()
										, buildDatiVeicoliType()
										)
								, FatturaElettronicaBodyType.class)
						, new FatturaElettronicaHeaderType(
								buildCedentePrestatoreType()
								, buildCessionarioCommittenteType()
								, buildDatiTrasmissioneType()
								, buildRappresentanteFiscaleType()
								, SoggettoEmittenteType.TZ
								, buildTerzoIntermediarioSoggettoEmittenteType()
								)
						, FormatoTrasmissioneType.FPA_12
						)
				);
		assertThat(invoice.getInvoiceParticipants()).hasSize(5);
		// Let's pick a relevant field because we already tested the rest
		assertThat(invoice.getInvoiceSendingNumber()).isNotBlank();
		assertThat(invoice.getNumber()).isNotBlank();

		assertThat(invoice.getPurchaseLines()).isNotEmpty();
		assertThat(invoice.getAttachments()).isNotEmpty();
		assertThat(invoice.getDocumentiCorrelati()).isNotEmpty();
		assertThat(invoice.getPaymentConditions()).isNotBlank();
		assertThat(invoice.getTotalePercorsoVeicoli()).isNotBlank();
	}
}

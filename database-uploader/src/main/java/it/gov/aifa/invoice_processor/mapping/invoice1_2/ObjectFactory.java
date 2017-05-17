package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

	private final static QName _FatturaElettronica_QNAME = new QName(
			"http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v1.2", "FatturaElettronica");

	public ObjectFactory() {
	}

	public FatturaElettronicaType createFatturaElettronicaType() {
		return new FatturaElettronicaType();
	}

	public CodiceArticoloType createCodiceArticoloType() {
		return new CodiceArticoloType();
	}

	public DatiBeniServiziType createDatiBeniServiziType() {
		return new DatiBeniServiziType();
	}

	public RappresentanteFiscaleType createRappresentanteFiscaleType() {
		return new RappresentanteFiscaleType();
	}

	public DettaglioPagamentoType createDettaglioPagamentoType() {
		return new DettaglioPagamentoType();
	}

	public FatturaPrincipaleType createFatturaPrincipaleType() {
		return new FatturaPrincipaleType();
	}

	public ContattiType createContattiType() {
		return new ContattiType();
	}

	public DatiDocumentiCorrelatiType createDatiDocumentiCorrelatiType() {
		return new DatiDocumentiCorrelatiType();
	}

	public DatiRitenutaType createDatiRitenutaType() {
		return new DatiRitenutaType();
	}

	public DatiPagamentoType createDatiPagamentoType() {
		return new DatiPagamentoType();
	}

	public DatiAnagraficiCessionarioType createDatiAnagraficiCessionarioType() {
		return new DatiAnagraficiCessionarioType();
	}

	public ScontoMaggiorazioneType createScontoMaggiorazioneType() {
		return new ScontoMaggiorazioneType();
	}

	public ContattiTrasmittenteType createContattiTrasmittenteType() {
		return new ContattiTrasmittenteType();
	}

	public DatiTrasportoType createDatiTrasportoType() {
		return new DatiTrasportoType();
	}

	public DatiCassaPrevidenzialeType createDatiCassaPrevidenzialeType() {
		return new DatiCassaPrevidenzialeType();
	}

	public RappresentanteFiscaleCessionarioType createRappresentanteFiscaleCessionarioType() {
		return new RappresentanteFiscaleCessionarioType();
	}

	public CedentePrestatoreType createCedentePrestatoreType() {
		return new CedentePrestatoreType();
	}

	public DatiAnagraficiVettoreType createDatiAnagraficiVettoreType() {
		return new DatiAnagraficiVettoreType();
	}

	public DatiGeneraliDocumentoType createDatiGeneraliDocumentoType() {
		return new DatiGeneraliDocumentoType();
	}

	public IscrizioneREAType createIscrizioneREAType() {
		return new IscrizioneREAType();
	}

	public IdFiscaleType createIdFiscaleType() {
		return new IdFiscaleType();
	}

	public FatturaElettronicaBodyType createFatturaElettronicaBodyType() {
		return new FatturaElettronicaBodyType();
	}

	public CessionarioCommittenteType createCessionarioCommittenteType() {
		return new CessionarioCommittenteType();
	}

	public IndirizzoType createIndirizzoType() {
		return new IndirizzoType();
	}

	public DatiVeicoliType createDatiVeicoliType() {
		return new DatiVeicoliType();
	}

	public DatiGeneraliType createDatiGeneraliType() {
		return new DatiGeneraliType();
	}

	public DatiRiepilogoType createDatiRiepilogoType() {
		return new DatiRiepilogoType();
	}

	public AltriDatiGestionaliType createAltriDatiGestionaliType() {
		return new AltriDatiGestionaliType();
	}

	public DatiTrasmissioneType createDatiTrasmissioneType() {
		return new DatiTrasmissioneType();
	}

	public DatiSALType createDatiSALType() {
		return new DatiSALType();
	}

	public DatiAnagraficiRappresentanteType createDatiAnagraficiRappresentanteType() {
		return new DatiAnagraficiRappresentanteType();
	}

	public DatiAnagraficiTerzoIntermediarioType createDatiAnagraficiTerzoIntermediarioType() {
		return new DatiAnagraficiTerzoIntermediarioType();
	}

	public AllegatiType createAllegatiType() {
		return new AllegatiType();
	}

	public DatiAnagraficiCedenteType createDatiAnagraficiCedenteType() {
		return new DatiAnagraficiCedenteType();
	}

	public DettaglioLineeType createDettaglioLineeType() {
		return new DettaglioLineeType();
	}

	public TerzoIntermediarioSoggettoEmittenteType createTerzoIntermediarioSoggettoEmittenteType() {
		return new TerzoIntermediarioSoggettoEmittenteType();
	}

	public DatiDDTType createDatiDDTType() {
		return new DatiDDTType();
	}

	public AnagraficaType createAnagraficaType() {
		return new AnagraficaType();
	}

	public FatturaElettronicaHeaderType createFatturaElettronicaHeaderType() {
		return new FatturaElettronicaHeaderType();
	}

	public DatiBolloType createDatiBolloType() {
		return new DatiBolloType();
	}

	@XmlElementDecl(namespace = "http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v1.2", name = "FatturaElettronica")
	public JAXBElement<FatturaElettronicaType> createFatturaElettronica(FatturaElettronicaType value) {
		return new JAXBElement<FatturaElettronicaType>(_FatturaElettronica_QNAME, FatturaElettronicaType.class, null,
				value);
	}

}

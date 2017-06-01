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

	public AllegatiType createAllegatiType() {
		return new AllegatiType();
	}

	public AltriDatiGestionaliType createAltriDatiGestionaliType() {
		return new AltriDatiGestionaliType();
	}

	public AnagraficaType createAnagraficaType() {
		return new AnagraficaType();
	}

	public CedentePrestatoreType createCedentePrestatoreType() {
		return new CedentePrestatoreType();
	}

	public CessionarioCommittenteType createCessionarioCommittenteType() {
		return new CessionarioCommittenteType();
	}

	public CodiceArticoloType createCodiceArticoloType() {
		return new CodiceArticoloType();
	}

	public ContattiTrasmittenteType createContattiTrasmittenteType() {
		return new ContattiTrasmittenteType();
	}

	public ContattiType createContattiType() {
		return new ContattiType();
	}

	public DatiAnagraficiCedenteType createDatiAnagraficiCedenteType() {
		return new DatiAnagraficiCedenteType();
	}

	public DatiAnagraficiCessionarioType createDatiAnagraficiCessionarioType() {
		return new DatiAnagraficiCessionarioType();
	}

	public DatiAnagraficiRappresentanteType createDatiAnagraficiRappresentanteType() {
		return new DatiAnagraficiRappresentanteType();
	}

	public DatiAnagraficiTerzoIntermediarioType createDatiAnagraficiTerzoIntermediarioType() {
		return new DatiAnagraficiTerzoIntermediarioType();
	}

	public DatiAnagraficiVettoreType createDatiAnagraficiVettoreType() {
		return new DatiAnagraficiVettoreType();
	}

	public DatiBeniServiziType createDatiBeniServiziType() {
		return new DatiBeniServiziType();
	}

	public DatiBolloType createDatiBolloType() {
		return new DatiBolloType();
	}

	public DatiCassaPrevidenzialeType createDatiCassaPrevidenzialeType() {
		return new DatiCassaPrevidenzialeType();
	}

	public DatiDDTType createDatiDDTType() {
		return new DatiDDTType();
	}

	public DatiDocumentiCorrelatiType createDatiDocumentiCorrelatiType() {
		return new DatiDocumentiCorrelatiType();
	}

	public DatiGeneraliDocumentoType createDatiGeneraliDocumentoType() {
		return new DatiGeneraliDocumentoType();
	}

	public DatiGeneraliType createDatiGeneraliType() {
		return new DatiGeneraliType();
	}

	public DatiPagamentoType createDatiPagamentoType() {
		return new DatiPagamentoType();
	}

	public DatiRiepilogoType createDatiRiepilogoType() {
		return new DatiRiepilogoType();
	}

	public DatiRitenutaType createDatiRitenutaType() {
		return new DatiRitenutaType();
	}

	public DatiSALType createDatiSALType() {
		return new DatiSALType();
	}

	public DatiTrasmissioneType createDatiTrasmissioneType() {
		return new DatiTrasmissioneType();
	}

	public DatiTrasportoType createDatiTrasportoType() {
		return new DatiTrasportoType();
	}

	public DatiVeicoliType createDatiVeicoliType() {
		return new DatiVeicoliType();
	}

	public DettaglioLineeType createDettaglioLineeType() {
		return new DettaglioLineeType();
	}

	public DettaglioPagamentoType createDettaglioPagamentoType() {
		return new DettaglioPagamentoType();
	}

	@XmlElementDecl(namespace = "http://ivaservizi.agenziaentrate.gov.it/docs/xsd/fatture/v1.2", name = "FatturaElettronica")
	public JAXBElement<FatturaElettronicaType> createFatturaElettronica(FatturaElettronicaType value) {
		return new JAXBElement<FatturaElettronicaType>(_FatturaElettronica_QNAME, FatturaElettronicaType.class, null,
				value);
	}

	public FatturaElettronicaBodyType createFatturaElettronicaBodyType() {
		return new FatturaElettronicaBodyType();
	}

	public FatturaElettronicaHeaderType createFatturaElettronicaHeaderType() {
		return new FatturaElettronicaHeaderType();
	}

	public FatturaElettronicaType createFatturaElettronicaType() {
		return new FatturaElettronicaType();
	}

	public FatturaPrincipaleType createFatturaPrincipaleType() {
		return new FatturaPrincipaleType();
	}

	public IdFiscaleType createIdFiscaleType() {
		return new IdFiscaleType();
	}

	public IndirizzoType createIndirizzoType() {
		return new IndirizzoType();
	}

	public IscrizioneREAType createIscrizioneREAType() {
		return new IscrizioneREAType();
	}

	public RappresentanteFiscaleCessionarioType createRappresentanteFiscaleCessionarioType() {
		return new RappresentanteFiscaleCessionarioType();
	}

	public RappresentanteFiscaleType createRappresentanteFiscaleType() {
		return new RappresentanteFiscaleType();
	}

	public ScontoMaggiorazioneType createScontoMaggiorazioneType() {
		return new ScontoMaggiorazioneType();
	}

	public TerzoIntermediarioSoggettoEmittenteType createTerzoIntermediarioSoggettoEmittenteType() {
		return new TerzoIntermediarioSoggettoEmittenteType();
	}

}

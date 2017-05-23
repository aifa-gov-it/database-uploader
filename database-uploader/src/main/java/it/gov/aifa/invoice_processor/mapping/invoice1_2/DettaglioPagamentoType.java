package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DettaglioPagamentoType", propOrder = { "beneficiario", "modalitaPagamento",
		"dataRiferimentoTerminiPagamento", "giorniTerminiPagamento", "dataScadenzaPagamento", "importoPagamento",
		"codUfficioPostale", "cognomeQuietanzante", "nomeQuietanzante", "cfQuietanzante", "titoloQuietanzante",
		"istitutoFinanziario", "iban", "abi", "cab", "bic", "scontoPagamentoAnticipato",
		"dataLimitePagamentoAnticipato", "penalitaPagamentiRitardati", "dataDecorrenzaPenale", "codicePagamento" })
public class DettaglioPagamentoType {

	@XmlElement(name = "ABI")
	protected String abi;

	@XmlElement(name = "Beneficiario")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String beneficiario;

	@XmlElement(name = "BIC")
	protected String bic;
	@XmlElement(name = "CAB")
	protected String cab;
	@XmlElement(name = "CFQuietanzante")
	protected String cfQuietanzante;
	@XmlElement(name = "CodicePagamento")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String codicePagamento;
	@XmlElement(name = "CodUfficioPostale")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String codUfficioPostale;
	@XmlElement(name = "CognomeQuietanzante")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String cognomeQuietanzante;
	@XmlElement(name = "DataDecorrenzaPenale")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dataDecorrenzaPenale;
	@XmlElement(name = "DataLimitePagamentoAnticipato")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dataLimitePagamentoAnticipato;
	@XmlElement(name = "DataRiferimentoTerminiPagamento")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dataRiferimentoTerminiPagamento;
	@XmlElement(name = "DataScadenzaPagamento")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dataScadenzaPagamento;
	@XmlElement(name = "GiorniTerminiPagamento")
	@XmlSchemaType(name = "integer")
	protected Integer giorniTerminiPagamento;
	@XmlElement(name = "IBAN")
	protected String iban;
	@XmlElement(name = "ImportoPagamento", required = true)
	protected BigDecimal importoPagamento;
	@XmlElement(name = "IstitutoFinanziario")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String istitutoFinanziario;
	@XmlElement(name = "ModalitaPagamento", required = true)
	@XmlSchemaType(name = "string")
	protected ModalitaPagamentoType modalitaPagamento;
	@XmlElement(name = "NomeQuietanzante")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String nomeQuietanzante;
	@XmlElement(name = "PenalitaPagamentiRitardati")
	protected BigDecimal penalitaPagamentiRitardati;
	@XmlElement(name = "ScontoPagamentoAnticipato")
	protected BigDecimal scontoPagamentoAnticipato;
	@XmlElement(name = "TitoloQuietanzante")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String titoloQuietanzante;
	public DettaglioPagamentoType() {
	}
	public DettaglioPagamentoType(String abi, String beneficiario, String bic, String cab, String cfQuietanzante,
			String codicePagamento, String codUfficioPostale, String cognomeQuietanzante,
			XMLGregorianCalendar dataDecorrenzaPenale, XMLGregorianCalendar dataLimitePagamentoAnticipato,
			XMLGregorianCalendar dataRiferimentoTerminiPagamento, XMLGregorianCalendar dataScadenzaPagamento,
			Integer giorniTerminiPagamento, String iban, BigDecimal importoPagamento, String istitutoFinanziario,
			ModalitaPagamentoType modalitaPagamento, String nomeQuietanzante, BigDecimal penalitaPagamentiRitardati,
			BigDecimal scontoPagamentoAnticipato, String titoloQuietanzante) {
		this.abi = abi;
		this.beneficiario = beneficiario;
		this.bic = bic;
		this.cab = cab;
		this.cfQuietanzante = cfQuietanzante;
		this.codicePagamento = codicePagamento;
		this.codUfficioPostale = codUfficioPostale;
		this.cognomeQuietanzante = cognomeQuietanzante;
		this.dataDecorrenzaPenale = dataDecorrenzaPenale;
		this.dataLimitePagamentoAnticipato = dataLimitePagamentoAnticipato;
		this.dataRiferimentoTerminiPagamento = dataRiferimentoTerminiPagamento;
		this.dataScadenzaPagamento = dataScadenzaPagamento;
		this.giorniTerminiPagamento = giorniTerminiPagamento;
		this.iban = iban;
		this.importoPagamento = importoPagamento;
		this.istitutoFinanziario = istitutoFinanziario;
		this.modalitaPagamento = modalitaPagamento;
		this.nomeQuietanzante = nomeQuietanzante;
		this.penalitaPagamentiRitardati = penalitaPagamentiRitardati;
		this.scontoPagamentoAnticipato = scontoPagamentoAnticipato;
		this.titoloQuietanzante = titoloQuietanzante;
	}

	public String getABI() {
		return abi;
	}

	public String getBeneficiario() {
		return beneficiario;
	}

	public String getBIC() {
		return bic;
	}

	public String getCAB() {
		return cab;
	}

	public String getCFQuietanzante() {
		return cfQuietanzante;
	}

	public String getCodicePagamento() {
		return codicePagamento;
	}

	public String getCodUfficioPostale() {
		return codUfficioPostale;
	}

	public String getCognomeQuietanzante() {
		return cognomeQuietanzante;
	}

	public XMLGregorianCalendar getDataDecorrenzaPenale() {
		return dataDecorrenzaPenale;
	}

	public XMLGregorianCalendar getDataLimitePagamentoAnticipato() {
		return dataLimitePagamentoAnticipato;
	}

	public XMLGregorianCalendar getDataRiferimentoTerminiPagamento() {
		return dataRiferimentoTerminiPagamento;
	}

	public XMLGregorianCalendar getDataScadenzaPagamento() {
		return dataScadenzaPagamento;
	}

	public Integer getGiorniTerminiPagamento() {
		return giorniTerminiPagamento;
	}

	public String getIBAN() {
		return iban;
	}

	public BigDecimal getImportoPagamento() {
		return importoPagamento;
	}

	public String getIstitutoFinanziario() {
		return istitutoFinanziario;
	}

	public ModalitaPagamentoType getModalitaPagamento() {
		return modalitaPagamento;
	}

	public String getNomeQuietanzante() {
		return nomeQuietanzante;
	}

	public BigDecimal getPenalitaPagamentiRitardati() {
		return penalitaPagamentiRitardati;
	}

	public BigDecimal getScontoPagamentoAnticipato() {
		return scontoPagamentoAnticipato;
	}

	public String getTitoloQuietanzante() {
		return titoloQuietanzante;
	}

	public void setABI(String value) {
		this.abi = value;
	}

	public void setBeneficiario(String value) {
		this.beneficiario = value;
	}

	public void setBIC(String value) {
		this.bic = value;
	}

	public void setCAB(String value) {
		this.cab = value;
	}

	public void setCFQuietanzante(String value) {
		this.cfQuietanzante = value;
	}

	public void setCodicePagamento(String value) {
		this.codicePagamento = value;
	}

	public void setCodUfficioPostale(String value) {
		this.codUfficioPostale = value;
	}

	public void setCognomeQuietanzante(String value) {
		this.cognomeQuietanzante = value;
	}

	public void setDataDecorrenzaPenale(XMLGregorianCalendar value) {
		this.dataDecorrenzaPenale = value;
	}

	public void setDataLimitePagamentoAnticipato(XMLGregorianCalendar value) {
		this.dataLimitePagamentoAnticipato = value;
	}

	public void setDataRiferimentoTerminiPagamento(XMLGregorianCalendar value) {
		this.dataRiferimentoTerminiPagamento = value;
	}

	public void setDataScadenzaPagamento(XMLGregorianCalendar value) {
		this.dataScadenzaPagamento = value;
	}

	public void setGiorniTerminiPagamento(Integer value) {
		this.giorniTerminiPagamento = value;
	}

	public void setIBAN(String value) {
		this.iban = value;
	}

	public void setImportoPagamento(BigDecimal value) {
		this.importoPagamento = value;
	}

	public void setIstitutoFinanziario(String value) {
		this.istitutoFinanziario = value;
	}

	public void setModalitaPagamento(ModalitaPagamentoType value) {
		this.modalitaPagamento = value;
	}

	public void setNomeQuietanzante(String value) {
		this.nomeQuietanzante = value;
	}

	public void setPenalitaPagamentiRitardati(BigDecimal value) {
		this.penalitaPagamentiRitardati = value;
	}

	public void setScontoPagamentoAnticipato(BigDecimal value) {
		this.scontoPagamentoAnticipato = value;
	}

	public void setTitoloQuietanzante(String value) {
		this.titoloQuietanzante = value;
	}

}

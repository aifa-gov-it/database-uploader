package it.gov.aifa.invoice_processor.entity.invoice;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.impl.AbstractInvoiceProcessorEntity;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.NaturaType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.RitenutaType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.TipoCassaType;

@Entity
@Validated
public class Invoice extends AbstractInvoiceProcessorEntity {
	
	private static final long serialVersionUID = -8619663315685190327L;

	private BigDecimal alCassa;

	private BigDecimal aliquotaIvaCassa;

	private BigDecimal aliquotaRitenuta;
	
	private String art73;
	
	private Set<Attachment> attachments;

	private String beneficiarioPagamento;

	private String capResa;

	private String causalePagamentoRitenuta;

	private String causaleTrasporto;
	
	private String cfQuietanzantePagamento;
	
	private String codicePagamento;

	private String codUfficioPostalePagamento;

	private String cognomeQuietanzantePagamento;

	private String comuneResa;

	private String currency;
	
	private Date dataDecorrenzaPenalePagamento;
	
	private Date dataInizioTrasporto;

	private Date dataLimitePagamentoAnticipatoPagamento;
	
	private Date dataOraConsegna;

	private Date dataOraRitiro;

	private Date dataRiferimentoTerminiPagamento;

	private Date dataVeicoli;

	private Date date;
	
	private Set<DatiRiepilogo> datiRiepilogo;
	
	private String description;
	
	private String descrizioneTrasporto;

	private BigDecimal discountAmount;

	private BigDecimal discountPercentage;

	private String discountType;

	private Set<DocumentoCorrelato> documentiCorrelati;

	private String documentTypeCode;
	
	private String financialInstitutionAbi;

	private String financialInstitutionBic;

	private String financialInstitutionCab;

	private String financialInstitutionIban;

	private String financialInstitutionName;

	private BigDecimal imponibileCassa;

	private Timestamp importDate = Timestamp.valueOf(LocalDateTime.now());

	private BigDecimal importoContributoCassa;

	private BigDecimal importoRitenuta;

	private String indirizzoResa;

	private Set<InvoiceParticipant> invoiceParticipants;

	private String invoiceRecipientCertifiedEmailAddress;
	
	@NotBlank
	private String invoiceRecipientCode;
	
	@NotBlank
	private String invoiceSenderCode;
	
	@NotBlank
	private String invoiceSenderCountryCode;
	
	private String invoiceSenderEmailAddress;

	private String invoiceSenderPhoneNumber;

	@NotBlank
	private String invoiceSendingFormat;

	@NotBlank
	private String invoiceSendingNumber;

	private Date mainInvoiceDate;

	private String mainInvoiceNumber;

	private String mezzoTrasporto;

	private NaturaType naturaCassa;

	private String nazioneResa;

	private String nomeQuietanzantePagamento;

	private String number;

	private String numeroCivicoResa;

	private Integer numeroColli;

	private BigDecimal paymentAmount;

	private String paymentConditions;

	private Date paymentExpirationDate;

	private String paymentMode;

	private Integer paymentTermDays;

	private BigDecimal penalitaPagamentiRitardatiPagamento;

	private BigDecimal pesoLordo;

	private BigDecimal pesoNetto;

	private String provinciaResa;

	private Set<PurchaseLine> purchaseLines;

	private String riferimentoAmministrazioneCassa;
	
	private Integer riferimentoFase;
	
	private RitenutaType ritenutaCassa;
	
	private BigDecimal rounding;
	
	private BigDecimal scontoPagamentoAnticipatoPagamento;

	private String soggettoEmittenteType;

	private BigDecimal stampAmount;

	private TipoCassaType tipoCassa;
	
	private String tipoResa;

	private String tipoRitenuta;

	private String titoloQuietanzantePagamento;

	private BigDecimal totalAmount;

	private String totalePercorsoVeicoli;

	private String unitaMisuraPeso;

	private String version;
	
	private String virtualStamp;
	
	public Invoice() {
		super();
		this.documentiCorrelati = new HashSet<>();
		this.invoiceParticipants = new HashSet<>();
	}

	public Invoice(String number) {
		this();
		this.number = number;
	}

	public BigDecimal getAlCassa() {
		return alCassa;
	}

	public BigDecimal getAliquotaIvaCassa() {
		return aliquotaIvaCassa;
	}

	public BigDecimal getAliquotaRitenuta() {
		return aliquotaRitenuta;
	}

	public String getArt73() {
		return art73;
	}
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "invoice")
	public Set<Attachment> getAttachments() {
		return attachments;
	}
	
	public String getBeneficiarioPagamento() {
		return beneficiarioPagamento;
	}

	public String getCapResa() {
		return capResa;
	}

	public String getCausalePagamentoRitenuta() {
		return causalePagamentoRitenuta;
	}
	
	public String getCausaleTrasporto() {
		return causaleTrasporto;
	}
	
	public String getCfQuietanzantePagamento() {
		return cfQuietanzantePagamento;
	}
	
	public String getCodicePagamento() {
		return codicePagamento;
	}
	
	public String getCodUfficioPostalePagamento() {
		return codUfficioPostalePagamento;
	}
	
	public String getCognomeQuietanzantePagamento() {
		return cognomeQuietanzantePagamento;
	}
	
	public String getComuneResa() {
		return comuneResa;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public Date getDataDecorrenzaPenalePagamento() {
		return dataDecorrenzaPenalePagamento;
	}

	public Date getDataInizioTrasporto() {
		return dataInizioTrasporto;
	}
	
	public Date getDataLimitePagamentoAnticipatoPagamento() {
		return dataLimitePagamentoAnticipatoPagamento;
	}
	
	public Date getDataOraConsegna() {
		return dataOraConsegna;
	}

	public Date getDataOraRitiro() {
		return dataOraRitiro;
	}

	public Date getDataRiferimentoTerminiPagamento() {
		return dataRiferimentoTerminiPagamento;
	}

	public Date getDataVeicoli() {
		return dataVeicoli;
	}

	public Date getDate() {
		return date;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "invoice")
	public Set<DatiRiepilogo> getDatiRiepilogo() {
		return datiRiepilogo;
	}

	@Lob
	public String getDescription() {
		return description;
	}
	
	@Lob
	public String getDescrizioneTrasporto() {
		return descrizioneTrasporto;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public BigDecimal getDiscountPercentage() {
		return discountPercentage;
	}

	public String getDiscountType() {
		return discountType;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "invoice")
	public Set<DocumentoCorrelato> getDocumentiCorrelati() {
		return documentiCorrelati;
	}

	public String getDocumentTypeCode() {
		return documentTypeCode;
	}

	public String getFinancialInstitutionAbi() {
		return financialInstitutionAbi;
	}

	public String getFinancialInstitutionBic() {
		return financialInstitutionBic;
	}

	public String getFinancialInstitutionCab() {
		return financialInstitutionCab;
	}

	public String getFinancialInstitutionIban() {
		return financialInstitutionIban;
	}

	public String getFinancialInstitutionName() {
		return financialInstitutionName;
	}

	@Override
	@Transient
	public List<String> getIdValues() {
		List<String> additionalIdValues = new ArrayList<>();
		if(StringUtils.isNotBlank(number))
			additionalIdValues.add(number);
		else
			throw new RuntimeException("Invoice reference cannot be null");
		return Collections.unmodifiableList(additionalIdValues);
	}

	public BigDecimal getImponibileCassa() {
		return imponibileCassa;
	}
	
	public Timestamp getImportDate() {
		return importDate;
	}
	
	public BigDecimal getImportoContributoCassa() {
		return importoContributoCassa;
	}
	
	public BigDecimal getImportoRitenuta() {
		return importoRitenuta;
	}
	
	public String getIndirizzoResa() {
		return indirizzoResa;
	}
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "invoice")
	public Set<InvoiceParticipant> getInvoiceParticipants() {
		return invoiceParticipants;
	}
	
	public String getInvoiceRecipientCertifiedEmailAddress() {
		return invoiceRecipientCertifiedEmailAddress;
	}

	public String getInvoiceRecipientCode() {
		return invoiceRecipientCode;
	}

	public String getInvoiceSenderCode() {
		return invoiceSenderCode;
	}

	public String getInvoiceSenderCountryCode() {
		return invoiceSenderCountryCode;
	}

	public String getInvoiceSenderEmailAddress() {
		return invoiceSenderEmailAddress;
	}

	public String getInvoiceSenderPhoneNumber() {
		return invoiceSenderPhoneNumber;
	}
	
	public String getInvoiceSendingFormat() {
		return invoiceSendingFormat;
	}
	
	public String getInvoiceSendingNumber() {
		return invoiceSendingNumber;
	}
	
	public Date getMainInvoiceDate() {
		return mainInvoiceDate;
	}
	
	public String getMainInvoiceNumber() {
		return mainInvoiceNumber;
	}
	
	public String getMezzoTrasporto() {
		return mezzoTrasporto;
	}
	
	public NaturaType getNaturaCassa() {
		return naturaCassa;
	}
	
	public String getNazioneResa() {
		return nazioneResa;
	}
	
	public String getNomeQuietanzantePagamento() {
		return nomeQuietanzantePagamento;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getNumeroCivicoResa() {
		return numeroCivicoResa;
	}
	
	public Integer getNumeroColli() {
		return numeroColli;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public String getPaymentConditions() {
		return paymentConditions;
	}

	public Date getPaymentExpirationDate() {
		return paymentExpirationDate;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public Integer getPaymentTermDays() {
		return paymentTermDays;
	}

	public BigDecimal getPenalitaPagamentiRitardatiPagamento() {
		return penalitaPagamentiRitardatiPagamento;
	}

	public BigDecimal getPesoLordo() {
		return pesoLordo;
	}

	public BigDecimal getPesoNetto() {
		return pesoNetto;
	}

	public String getProvinciaResa() {
		return provinciaResa;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "invoice")
	public Set<PurchaseLine> getPurchaseLines() {
		return purchaseLines;
	}

	public String getRiferimentoAmministrazioneCassa() {
		return riferimentoAmministrazioneCassa;
	}

	public Integer getRiferimentoFase() {
		return riferimentoFase;
	}

	public RitenutaType getRitenutaCassa() {
		return ritenutaCassa;
	}

	public BigDecimal getRounding() {
		return rounding;
	}

	public BigDecimal getScontoPagamentoAnticipatoPagamento() {
		return scontoPagamentoAnticipatoPagamento;
	}

	public String getSoggettoEmittenteType() {
		return soggettoEmittenteType;
	}

	public BigDecimal getStampAmount() {
		return stampAmount;
	}

	public TipoCassaType getTipoCassa() {
		return tipoCassa;
	}

	public String getTipoResa() {
		return tipoResa;
	}

	public String getTipoRitenuta() {
		return tipoRitenuta;
	}

	public String getTitoloQuietanzantePagamento() {
		return titoloQuietanzantePagamento;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	
	public String getTotalePercorsoVeicoli() {
		return totalePercorsoVeicoli;
	}

	public String getUnitaMisuraPeso() {
		return unitaMisuraPeso;
	}

	public String getVersion() {
		return version;
	}

	public String getVirtualStamp() {
		return virtualStamp;
	}

	public void setAlCassa(BigDecimal alCassa) {
		this.alCassa = alCassa;
	}

	public void setAliquotaIvaCassa(BigDecimal aliquotaIvaCassa) {
		this.aliquotaIvaCassa = aliquotaIvaCassa;
	}

	public void setAliquotaRitenuta(BigDecimal aliquotaRitenuta) {
		this.aliquotaRitenuta = aliquotaRitenuta;
	}
	
	public void setArt73(String art73) {
		this.art73 = art73;
	}

	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}

	public void setBeneficiarioPagamento(String beneficiarioPagamento) {
		this.beneficiarioPagamento = beneficiarioPagamento;
	}

	public void setCapResa(String capResa) {
		this.capResa = capResa;
	}

	public void setCausalePagamentoRitenuta(String causalePagamentoRitenuta) {
		this.causalePagamentoRitenuta = causalePagamentoRitenuta;
	}

	public void setCausaleTrasporto(String causaleTrasporto) {
		this.causaleTrasporto = causaleTrasporto;
	}

	public void setCfQuietanzantePagamento(String cfQuietanzantePagamento) {
		this.cfQuietanzantePagamento = cfQuietanzantePagamento;
	}

	public void setCodicePagamento(String codicePagamento) {
		this.codicePagamento = codicePagamento;
	}
	
	public void setCodUfficioPostalePagamento(String codUfficioPostalePagamento) {
		this.codUfficioPostalePagamento = codUfficioPostalePagamento;
	}

	public void setCognomeQuietanzantePagamento(String cognomeQuietanzantePagamento) {
		this.cognomeQuietanzantePagamento = cognomeQuietanzantePagamento;
	}
	
	public void setComuneResa(String comuneResa) {
		this.comuneResa = comuneResa;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public void setDataDecorrenzaPenalePagamento(Date dataDecorrenzaPenalePagamento) {
		this.dataDecorrenzaPenalePagamento = dataDecorrenzaPenalePagamento;
	}
	
	public void setDataInizioTrasporto(Date dataInizioTrasporto) {
		this.dataInizioTrasporto = dataInizioTrasporto;
	}
	
	public void setDataLimitePagamentoAnticipatoPagamento(Date dataLimitePagamentoAnticipatoPagamento) {
		this.dataLimitePagamentoAnticipatoPagamento = dataLimitePagamentoAnticipatoPagamento;
	}

	public void setDataOraConsegna(Date dataOraConsegna) {
		this.dataOraConsegna = dataOraConsegna;
	}

	public void setDataOraRitiro(Date dataOraRitiro) {
		this.dataOraRitiro = dataOraRitiro;
	}

	public void setDataRiferimentoTerminiPagamento(Date dataRiferimentoTerminiPagamento) {
		this.dataRiferimentoTerminiPagamento = dataRiferimentoTerminiPagamento;
	}

	public void setDataVeicoli(Date dataVeicoli) {
		this.dataVeicoli = dataVeicoli;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDatiRiepilogo(Set<DatiRiepilogo> datiRiepilogo) {
		this.datiRiepilogo = datiRiepilogo;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDescrizioneTrasporto(String descrizioneTrasporto) {
		this.descrizioneTrasporto = descrizioneTrasporto;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public void setDiscountPercentage(BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public void setDocumentiCorrelati(Set<DocumentoCorrelato> documentiCorrelati) {
		this.documentiCorrelati = documentiCorrelati;
	}

	public void setDocumentTypeCode(String documentTypeCode) {
		this.documentTypeCode = documentTypeCode;
	}

	public void setFinancialInstitutionAbi(String financialInstitutionAbi) {
		this.financialInstitutionAbi = financialInstitutionAbi;
	}

	public void setFinancialInstitutionBic(String financialInstitutionBic) {
		this.financialInstitutionBic = financialInstitutionBic;
	}
	
	public void setFinancialInstitutionCab(String financialInstitutionCab) {
		this.financialInstitutionCab = financialInstitutionCab;
	}
	
	public void setFinancialInstitutionIban(String financialInstitutionIban) {
		this.financialInstitutionIban = financialInstitutionIban;
	}
	public void setFinancialInstitutionName(String financialInstitutionName) {
		this.financialInstitutionName = financialInstitutionName;
	}
	
	public void setImponibileCassa(BigDecimal imponibileCassa) {
		this.imponibileCassa = imponibileCassa;
	}
	
	public void setImportDate(Timestamp importDate) {
		this.importDate = importDate;
	}
	
	public void setImportoContributoCassa(BigDecimal importoContributoCassa) {
		this.importoContributoCassa = importoContributoCassa;
	}
	
	public void setImportoRitenuta(BigDecimal importoRitenuta) {
		this.importoRitenuta = importoRitenuta;
	}
	
	public void setIndirizzoResa(String indirizzoResa) {
		this.indirizzoResa = indirizzoResa;
	}
	
	public void setInvoiceParticipants(Set<InvoiceParticipant> invoiceParticipants) {
		this.invoiceParticipants = invoiceParticipants;
	}
	
	public void setInvoiceRecipientCertifiedEmailAddress(String invoiceRecipientCertifiedEmailAddress) {
		this.invoiceRecipientCertifiedEmailAddress = invoiceRecipientCertifiedEmailAddress;
	}
	
	public void setInvoiceRecipientCode(String invoiceRecipientCode) {
		this.invoiceRecipientCode = invoiceRecipientCode;
	}

	public void setInvoiceSenderCode(String invoiceSenderCode) {
		this.invoiceSenderCode = invoiceSenderCode;
	}

	public void setInvoiceSenderCountryCode(String invoiceSenderCountryCode) {
		this.invoiceSenderCountryCode = invoiceSenderCountryCode;
	}

	public void setInvoiceSenderEmailAddress(String invoiceSenderEmailAddress) {
		this.invoiceSenderEmailAddress = invoiceSenderEmailAddress;
	}

	public void setInvoiceSenderPhoneNumber(String invoiceSenderPhoneNumber) {
		this.invoiceSenderPhoneNumber = invoiceSenderPhoneNumber;
	}

	public void setInvoiceSendingFormat(String invoiceSendingFormat) {
		this.invoiceSendingFormat = invoiceSendingFormat;
	}

	public void setInvoiceSendingNumber(String invoiceSendingNumber) {
		this.invoiceSendingNumber = invoiceSendingNumber;
	}

	public void setMainInvoiceDate(Date mainInvoiceDate) {
		this.mainInvoiceDate = mainInvoiceDate;
	}

	public void setMainInvoiceNumber(String mainInvoiceNumber) {
		this.mainInvoiceNumber = mainInvoiceNumber;
	}

	public void setMezzoTrasporto(String mezzoTrasporto) {
		this.mezzoTrasporto = mezzoTrasporto;
	}

	public void setNaturaCassa(NaturaType naturaCassa) {
		this.naturaCassa = naturaCassa;
	}

	public void setNazioneResa(String nazioneResa) {
		this.nazioneResa = nazioneResa;
	}

	public void setNomeQuietanzantePagamento(String nomeQuietanzantePagamento) {
		this.nomeQuietanzantePagamento = nomeQuietanzantePagamento;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setNumeroCivicoResa(String numeroCivicoResa) {
		this.numeroCivicoResa = numeroCivicoResa;
	}

	public void setNumeroColli(Integer numeroColli) {
		this.numeroColli = numeroColli;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public void setPaymentConditions(String paymentConditions) {
		this.paymentConditions = paymentConditions;
	}

	public void setPaymentExpirationDate(Date paymentExpirationDate) {
		this.paymentExpirationDate = paymentExpirationDate;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public void setPaymentTermDays(Integer paymentTermDays) {
		this.paymentTermDays = paymentTermDays;
	}

	public void setPenalitaPagamentiRitardatiPagamento(BigDecimal penalitaPagamentiRitardatiPagamento) {
		this.penalitaPagamentiRitardatiPagamento = penalitaPagamentiRitardatiPagamento;
	}

	public void setPesoLordo(BigDecimal pesoLordo) {
		this.pesoLordo = pesoLordo;
	}

	public void setPesoNetto(BigDecimal pesoNetto) {
		this.pesoNetto = pesoNetto;
	}

	public void setProvinciaResa(String provinciaResa) {
		this.provinciaResa = provinciaResa;
	}

	public void setPurchaseLines(Set<PurchaseLine> purchaseLines) {
		this.purchaseLines = purchaseLines;
	}

	public void setRiferimentoAmministrazioneCassa(String riferimentoAmministrazioneCassa) {
		this.riferimentoAmministrazioneCassa = riferimentoAmministrazioneCassa;
	}

	public void setRiferimentoFase(Integer riferimentoFase) {
		this.riferimentoFase = riferimentoFase;
	}

	public void setRitenutaCassa(RitenutaType ritenutaCassa) {
		this.ritenutaCassa = ritenutaCassa;
	}

	public void setRounding(BigDecimal rounding) {
		this.rounding = rounding;
	}

	public void setScontoPagamentoAnticipatoPagamento(BigDecimal scontoPagamentoAnticipatoPagamento) {
		this.scontoPagamentoAnticipatoPagamento = scontoPagamentoAnticipatoPagamento;
	}

	public void setSoggettoEmittenteType(String soggettoEmittenteType) {
		this.soggettoEmittenteType = soggettoEmittenteType;
	}

	public void setStampAmount(BigDecimal stampAmount) {
		this.stampAmount = stampAmount;
	}

	public void setTipoCassa(TipoCassaType tipoCassa) {
		this.tipoCassa = tipoCassa;
	}

	public void setTipoResa(String tipoResa) {
		this.tipoResa = tipoResa;
	}

	public void setTipoRitenuta(String tipoRitenuta) {
		this.tipoRitenuta = tipoRitenuta;
	}

	public void setTitoloQuietanzantePagamento(String titoloQuietanzantePagamento) {
		this.titoloQuietanzantePagamento = titoloQuietanzantePagamento;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setTotalePercorsoVeicoli(String totalePercorsoVeicoli) {
		this.totalePercorsoVeicoli = totalePercorsoVeicoli;
	}

	public void setUnitaMisuraPeso(String unitaMisuraPeso) {
		this.unitaMisuraPeso = unitaMisuraPeso;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setVirtualStamp(String virtualStamp) {
		this.virtualStamp = virtualStamp;
	}
}

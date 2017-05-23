package it.gov.aifa.invoice_processor.entity.invoice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.impl.AbstractInvoiceProcessorEntity;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.NaturaType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.RitenutaType;
import it.gov.aifa.invoice_processor.mapping.invoice1_2.TipoCassaType;

@Entity
@Validated
public class Invoice extends AbstractInvoiceProcessorEntity {
	
	private BigDecimal alCassa;

	private BigDecimal aliquotaIvaCassa;

	private BigDecimal aliquotaRitenuta;
	
	private String art73;
	
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "invoice")
	private List<Attachment> attachments;

	private String beneficiarioPagamento;

	private String capResa;

	private String causalePagamentoRitenuta;

	private String causaleTrasporto;

	@ManyToOne(cascade = { CascadeType.ALL })
	@NotNull
	private InvoiceCedentePrestatore cedentePrestatore;

	@ManyToOne(cascade = { CascadeType.ALL })
	@NotNull
	private InvoiceParticipant cessionarioCommittente;

	private String cfQuietanzantePagamento;

	private String codicePagamento;

	private String codUfficioPostalePagamento;

	private String cognomeQuietanzantePagamento;

	private String comuneResa;
	
	@NotBlank
	private String currency;
	
	private LocalDate dataDecorrenzaPenalePagamento;

	private LocalDate dataInizioTrasporto;
	
	private LocalDate dataLimitePagamentoAnticipatoPagamento;

	private LocalDate dataOraConsegna;

	private LocalDate dataOraRitiro;

	private LocalDate dataRiferimentoTerminiPagamento;

	private LocalDate dataVeicoli;
	
	@NotNull
	private LocalDate date;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Set<DocumentoCorrelato> datiContratto;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Set<DocumentoCorrelato> datiConvenzione;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Set<DocumentoCorrelato> datiDdt;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Set<DocumentoCorrelato> datiRicezione;
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Set<DatiRiepilogo> datiRiepilogo;

	@NotBlank
	private String description;

	private String descrizioneTrasporto;

	private BigDecimal discountAmount;

	private BigDecimal discountPercentage;

	private String discountType;

	private String documentTypeCode;

	@ManyToOne(cascade = { CascadeType.ALL })
	@NotNull
	private FinancialInstitution financialInstitution;

	private BigDecimal imponibileCassa;

	private LocalDateTime importDate = LocalDateTime.now();

	private BigDecimal importoContributoCassa;

	private BigDecimal importoRitenuta;

	private String indirizzoResa;

	private String invoiceRecipientCertifiedEmailAddress;

	@NotBlank
	private String invoiceRecipientCode;

	private String invoiceSenderCode;

	private String invoiceSenderCountryCode;

	private String invoiceSenderEmailAddress;

	private String invoiceSenderPhoneNumber;

	@NotBlank
	private String invoiceSendingFormat;

	@NotBlank
	private String invoiceSendingNumber;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Set<DocumentoCorrelato> linkedInvoices;

	private LocalDate mainInvoiceDate;

	private String mainInvoiceNumber;

	private String mezzoTrasporto;

	private NaturaType naturaCassa;

	private String nazioneResa;

	private String nomeQuietanzantePagamento;

	@NotBlank
	private String number;

	private String numeroCivicoResa;

	private Integer numeroColli;

	private BigDecimal paymentAmount;
	
	@NotBlank
	private String paymentConditions;
	
	@NotNull
	private LocalDate paymentExpirationDate;
	
	@NotBlank
	private String paymentMode;
	
	private int paymentTermDays;
	
	private BigDecimal penalitaPagamentiRitardatiPagamento;
	
	private BigDecimal pesoLordo;

	private BigDecimal pesoNetto;

	private String provinciaResa;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Set<PurchaseLine> purchaseLines;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Set<DocumentoCorrelato> purchaseOrders;
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@NotNull
	private InvoiceParticipant rappresentanteFiscale;

	private String riferimentoAmministrazioneCassa;

	private Integer riferimentoFase;

	private RitenutaType ritenutaCassa;

	private BigDecimal rounding;

	private BigDecimal scontoPagamentoAnticipatoPagamento;

	@ManyToOne(cascade = { CascadeType.ALL })
	@NotNull
	private InvoiceParticipant soggettoEmittente;
	
	@NotBlank
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

	@ManyToOne(cascade = { CascadeType.ALL })
	private Vettore vettore;
	
	private String virtualStamp;
	
	public Invoice() {
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
	
	public List<Attachment> getAttachments() {
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

	public InvoiceCedentePrestatore getCedentePrestatore() {
		return cedentePrestatore;
	}

	public InvoiceParticipant getCessionarioCommittente() {
		return cessionarioCommittente;
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

	public LocalDate getDataDecorrenzaPenalePagamento() {
		return dataDecorrenzaPenalePagamento;
	}

	public LocalDate getDataInizioTrasporto() {
		return dataInizioTrasporto;
	}

	public LocalDate getDataLimitePagamentoAnticipatoPagamento() {
		return dataLimitePagamentoAnticipatoPagamento;
	}

	public LocalDate getDataOraConsegna() {
		return dataOraConsegna;
	}

	public LocalDate getDataOraRitiro() {
		return dataOraRitiro;
	}

	public LocalDate getDataRiferimentoTerminiPagamento() {
		return dataRiferimentoTerminiPagamento;
	}

	public LocalDate getDataVeicoli() {
		return dataVeicoli;
	}

	public LocalDate getDate() {
		return date;
	}

	public Set<DocumentoCorrelato> getDatiContratto() {
		return datiContratto;
	}

	public Set<DocumentoCorrelato> getDatiConvenzione() {
		return datiConvenzione;
	}

	public Set<DocumentoCorrelato> getDatiDdt() {
		return datiDdt;
	}

	public Set<DocumentoCorrelato> getDatiRicezione() {
		return datiRicezione;
	}

	public Set<DatiRiepilogo> getDatiRiepilogo() {
		return datiRiepilogo;
	}

	public String getDescription() {
		return description;
	}

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
	
	public String getDocumentTypeCode() {
		return documentTypeCode;
	}
	
	public FinancialInstitution getFinancialInstitution() {
		return financialInstitution;
	}
	
	@Override
	public List<String> getIdValues() {
		List<String> additionalIdValues = new ArrayList<>();
		additionalIdValues.add(number);
		return Collections.unmodifiableList(additionalIdValues);
	}
	
	public BigDecimal getImponibileCassa() {
		return imponibileCassa;
	}

	public LocalDateTime getImportDate() {
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
	
	public Set<DocumentoCorrelato> getLinkedInvoices() {
		return linkedInvoices;
	}
	
	public LocalDate getMainInvoiceDate() {
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

	public LocalDate getPaymentExpirationDate() {
		return paymentExpirationDate;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public int getPaymentTermDays() {
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

	public Set<PurchaseLine> getPurchaseLines() {
		return purchaseLines;
	}

	public Set<DocumentoCorrelato> getPurchaseOrders() {
		return purchaseOrders;
	}

	public InvoiceParticipant getRappresentanteFiscale() {
		return rappresentanteFiscale;
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

	public InvoiceParticipant getSoggettoEmittente() {
		return soggettoEmittente;
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
	
	public Vettore getVettore() {
		return vettore;
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

	public void setAttachments(List<Attachment> attachments) {
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

	public void setCedentePrestatore(InvoiceCedentePrestatore cedentePrestatore) {
		this.cedentePrestatore = cedentePrestatore;
	}
	
	public void setCessionarioCommittente(InvoiceParticipant cessionarioCommittente) {
		this.cessionarioCommittente = cessionarioCommittente;
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

	public void setDataDecorrenzaPenalePagamento(LocalDate dataDecorrenzaPenalePagamento) {
		this.dataDecorrenzaPenalePagamento = dataDecorrenzaPenalePagamento;
	}

	public void setDataInizioTrasporto(LocalDate dataInizioTrasporto) {
		this.dataInizioTrasporto = dataInizioTrasporto;
	}

	public void setDataLimitePagamentoAnticipatoPagamento(LocalDate dataLimitePagamentoAnticipatoPagamento) {
		this.dataLimitePagamentoAnticipatoPagamento = dataLimitePagamentoAnticipatoPagamento;
	}

	public void setDataOraConsegna(LocalDate dataOraConsegna) {
		this.dataOraConsegna = dataOraConsegna;
	}

	public void setDataOraRitiro(LocalDate dataOraRitiro) {
		this.dataOraRitiro = dataOraRitiro;
	}

	public void setDataRiferimentoTerminiPagamento(LocalDate dataRiferimentoTerminiPagamento) {
		this.dataRiferimentoTerminiPagamento = dataRiferimentoTerminiPagamento;
	}

	public void setDataVeicoli(LocalDate dataVeicoli) {
		this.dataVeicoli = dataVeicoli;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public void setDatiContratto(Set<DocumentoCorrelato> datiContratto) {
		this.datiContratto = datiContratto;
	}
	
	public void setDatiConvenzione(Set<DocumentoCorrelato> datiConvenzione) {
		this.datiConvenzione = datiConvenzione;
	}

	public void setDatiDdt(Set<DocumentoCorrelato> datiDdt) {
		this.datiDdt = datiDdt;
	}

	public void setDatiRicezione(Set<DocumentoCorrelato> datiRicezione) {
		this.datiRicezione = datiRicezione;
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
	
	public void setDocumentTypeCode(String documentTypeCode) {
		this.documentTypeCode = documentTypeCode;
	}
	
	public void setFinancialInstitution(FinancialInstitution financialInstitution) {
		this.financialInstitution = financialInstitution;
	}
	public void setImponibileCassa(BigDecimal imponibileCassa) {
		this.imponibileCassa = imponibileCassa;
	}
	
	public void setImportDate(LocalDateTime importDate) {
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

	public void setLinkedInvoices(Set<DocumentoCorrelato> linkedInvoices) {
		this.linkedInvoices = linkedInvoices;
	}

	public void setMainInvoiceDate(LocalDate mainInvoiceDate) {
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

	public void setPaymentExpirationDate(LocalDate paymentExpirationDate) {
		this.paymentExpirationDate = paymentExpirationDate;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public void setPaymentTermDays(int paymentTermDays) {
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

	public void setPurchaseOrders(Set<DocumentoCorrelato> purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}

	public void setRappresentanteFiscale(InvoiceParticipant rappresentanteFiscale) {
		this.rappresentanteFiscale = rappresentanteFiscale;
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

	public void setSoggettoEmittente(InvoiceParticipant soggettoEmittente) {
		this.soggettoEmittente = soggettoEmittente;
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

	public void setVettore(Vettore vettore) {
		this.vettore = vettore;
	}

	public void setVirtualStamp(String virtualStamp) {
		this.virtualStamp = virtualStamp;
	}
}

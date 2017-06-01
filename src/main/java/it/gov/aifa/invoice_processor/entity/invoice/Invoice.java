package it.gov.aifa.invoice_processor.entity.invoice;

import java.math.BigDecimal;
import java.sql.Date;
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

	private String beneficiarioPag;

	private String capResa;

	private String causalePagRitenuta;

	private String causaleTrasporto;
	
	private String cfQuietanzantePag;
	
	private String codicePag;

	private String codUfficioPostalePag;

	private String cognomeQuietanzantePag;

	private String comuneResa;

	private String currency;
	
	private Date dataDecorrenzaPenalePag;
	
	private Date dataInizioTrasporto;

	private Date dataLimitePagAnticipato;
	
	private Date dataOraConsegna;

	private Date dataOraRitiro;

	private Date dataRiferimentoTerminiPag;

	private Date dataVeicoli;

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

	private BigDecimal importoContributoCassa;

	private BigDecimal importoRitenuta;

	private String indirizzoResa;

	private Date invoiceDate;

	private String invoiceNumber;

	private Set<InvoiceParticipant> invoiceParticipants;
	
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

	private String nomeQuietanzantePag;

	private String numeroCivicoResa;

	private Integer numeroColli;

	private BigDecimal paymentAmount;

	private String paymentConditions;

	private Date paymentExpirationDate;

	private String paymentMode;

	private Integer paymentTermDays;

	private BigDecimal penalitaPagamentiRitardati;

	private BigDecimal pesoLordo;

	private BigDecimal pesoNetto;

	private String provinciaResa;

	private Set<PurchaseLine> purchaseLines;

	private String recipientCertEmailAddr;

	@NotBlank
	private String recipientCode;

	private String riferimentoAmminCassa;
	
	private Integer riferimentoFase;
	
	private RitenutaType ritenutaCassa;
	
	private BigDecimal rounding;
	
	private BigDecimal scontoPagAnticipatoPag;

	private String soggettoEmittenteType;

	private BigDecimal stampAmount;

	private TipoCassaType tipoCassa;
	
	private String tipoResa;

	private String tipoRitenuta;

	private String titoloQuietanzantePag;

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

	public Invoice(String invoiceNumber) {
		this();
		this.invoiceNumber = invoiceNumber;
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
	
	public String getBeneficiarioPag() {
		return beneficiarioPag;
	}

	public String getCapResa() {
		return capResa;
	}

	public String getCausalePagRitenuta() {
		return causalePagRitenuta;
	}
	
	public String getCausaleTrasporto() {
		return causaleTrasporto;
	}
	
	public String getCfQuietanzantePag() {
		return cfQuietanzantePag;
	}
	
	public String getCodicePag() {
		return codicePag;
	}
	
	public String getCodUfficioPostalePag() {
		return codUfficioPostalePag;
	}
	
	public String getCognomeQuietanzantePag() {
		return cognomeQuietanzantePag;
	}
	
	public String getComuneResa() {
		return comuneResa;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public Date getDataDecorrenzaPenalePag() {
		return dataDecorrenzaPenalePag;
	}

	public Date getDataInizioTrasporto() {
		return dataInizioTrasporto;
	}
	
	public Date getDataLimitePagAnticipato() {
		return dataLimitePagAnticipato;
	}
	
	public Date getDataOraConsegna() {
		return dataOraConsegna;
	}

	public Date getDataOraRitiro() {
		return dataOraRitiro;
	}

	public Date getDataRiferimentoTerminiPag() {
		return dataRiferimentoTerminiPag;
	}

	public Date getDataVeicoli() {
		return dataVeicoli;
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
		if(StringUtils.isNotBlank(invoiceNumber))
			additionalIdValues.add(invoiceNumber);
		else
			throw new RuntimeException("Invoice reference cannot be null");
		return Collections.unmodifiableList(additionalIdValues);
	}

	public BigDecimal getImponibileCassa() {
		return imponibileCassa;
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
	
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "invoice")
	public Set<InvoiceParticipant> getInvoiceParticipants() {
		return invoiceParticipants;
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
	
	public String getNomeQuietanzantePag() {
		return nomeQuietanzantePag;
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

	public BigDecimal getPenalitaPagamentiRitardati() {
		return penalitaPagamentiRitardati;
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

	public String getRecipientCertEmailAddr() {
		return recipientCertEmailAddr;
	}

	public String getRecipientCode() {
		return recipientCode;
	}

	public String getRiferimentoAmminCassa() {
		return riferimentoAmminCassa;
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

	public BigDecimal getScontoPagAnticipatoPag() {
		return scontoPagAnticipatoPag;
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

	public String getTitoloQuietanzantePag() {
		return titoloQuietanzantePag;
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

	public void setBeneficiarioPag(String beneficiarioPag) {
		this.beneficiarioPag = beneficiarioPag;
	}

	public void setCapResa(String capResa) {
		this.capResa = capResa;
	}

	public void setCausalePagRitenuta(String causalePagRitenuta) {
		this.causalePagRitenuta = causalePagRitenuta;
	}

	public void setCausaleTrasporto(String causaleTrasporto) {
		this.causaleTrasporto = causaleTrasporto;
	}

	public void setCfQuietanzantePag(String cfQuietanzantePag) {
		this.cfQuietanzantePag = cfQuietanzantePag;
	}

	public void setCodicePag(String codicePag) {
		this.codicePag = codicePag;
	}
	
	public void setCodUfficioPostalePag(String codUfficioPostalePag) {
		this.codUfficioPostalePag = codUfficioPostalePag;
	}

	public void setCognomeQuietanzantePag(String cognomeQuietanzantePag) {
		this.cognomeQuietanzantePag = cognomeQuietanzantePag;
	}
	
	public void setComuneResa(String comuneResa) {
		this.comuneResa = comuneResa;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public void setDataDecorrenzaPenalePag(Date dataDecorrenzaPenalePag) {
		this.dataDecorrenzaPenalePag = dataDecorrenzaPenalePag;
	}
	
	public void setDataInizioTrasporto(Date dataInizioTrasporto) {
		this.dataInizioTrasporto = dataInizioTrasporto;
	}
	
	public void setDataLimitePagAnticipato(Date dataLimitePagAnticipato) {
		this.dataLimitePagAnticipato = dataLimitePagAnticipato;
	}

	public void setDataOraConsegna(Date dataOraConsegna) {
		this.dataOraConsegna = dataOraConsegna;
	}

	public void setDataOraRitiro(Date dataOraRitiro) {
		this.dataOraRitiro = dataOraRitiro;
	}

	public void setDataRiferimentoTerminiPag(Date dataRiferimentoTerminiPag) {
		this.dataRiferimentoTerminiPag = dataRiferimentoTerminiPag;
	}

	public void setDataVeicoli(Date dataVeicoli) {
		this.dataVeicoli = dataVeicoli;
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
	
	public void setImportoContributoCassa(BigDecimal importoContributoCassa) {
		this.importoContributoCassa = importoContributoCassa;
	}
	
	public void setImportoRitenuta(BigDecimal importoRitenuta) {
		this.importoRitenuta = importoRitenuta;
	}
	
	public void setIndirizzoResa(String indirizzoResa) {
		this.indirizzoResa = indirizzoResa;
	}
	
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	
	public void setInvoiceParticipants(Set<InvoiceParticipant> invoiceParticipants) {
		this.invoiceParticipants = invoiceParticipants;
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

	public void setNomeQuietanzantePag(String nomeQuietanzantePag) {
		this.nomeQuietanzantePag = nomeQuietanzantePag;
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

	public void setPenalitaPagamentiRitardati(BigDecimal penalitaPagamentiRitardati) {
		this.penalitaPagamentiRitardati = penalitaPagamentiRitardati;
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

	public void setRecipientCertEmailAddr(String recipientCertEmailAddr) {
		this.recipientCertEmailAddr = recipientCertEmailAddr;
	}

	public void setRecipientCode(String recipientCode) {
		this.recipientCode = recipientCode;
	}

	public void setRiferimentoAmminCassa(String riferimentoAmminCassa) {
		this.riferimentoAmminCassa = riferimentoAmminCassa;
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

	public void setScontoPagAnticipatoPag(BigDecimal scontoPagAnticipatoPag) {
		this.scontoPagAnticipatoPag = scontoPagAnticipatoPag;
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

	public void setTitoloQuietanzantePag(String titoloQuietanzantePag) {
		this.titoloQuietanzantePag = titoloQuietanzantePag;
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

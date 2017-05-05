package it.gov.aifa.invoice_processor.entity.invoice;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class Invoice {

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "cedentePrestatoreCode", referencedColumnName = "code")
		, @JoinColumn(name = "cedentePrestatoreCountryCode", referencedColumnName = "country_code")
	})
	@NotNull
	private InvoiceCedentePrestatore cedentePrestatore;

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "cessionarioCommittenteCode", referencedColumnName = "code")
		, @JoinColumn(name = "cessionarioCommittenteCountryCode", referencedColumnName = "countryCode")
	})
	@NotNull
	private InvoiceParticipant cessionarioCommittente;

	@NotBlank
	private String currency;

	@NotNull
	private LocalDate date;
	
	@NotBlank
	private String description;
	
	private double discountAmount;
	
	@NotBlank
	private String discountType;
	
	@NotBlank
	private String documentTypeCode;
	
	@ManyToOne
	@JoinColumn(name = "financialInstitutionId", referencedColumnName = "iban")
	@NotNull
	private FinancialInstitution financialInstitution;
	
	@NotBlank
	private String invoiceRecipientCode;
	
	@NotBlank
	private String invoiceSenderCode;

	@NotBlank
	private String invoiceSenderCountryCode;
	
	@NotBlank
	private String invoiceSendingFormat;
	
	@NotBlank
	private String invoiceSendingNumber;
	
	@ManyToOne
	@JoinColumn(name = "taxId", referencedColumnName = "id")
	@NotNull
	private InvoiceTax invoiceTax;
	
	@ManyToOne
	@JoinColumn(name = "version")
	@NotNull
	private InvoiceVersion invoiceVersion;
	
	@JoinColumn(name = "invoiceId")
	@OneToMany(fetch = FetchType.EAGER)
	@NotEmpty
	private Set<LinkedInvoice> linkedInvoices;
	
	@Id
	@NotBlank
	private String number;

	private double paymentAmount;

	@NotBlank
	private String paymentConditions;
	
	@NotBlank
	private LocalDate paymentExpirationDate;
	
	@NotBlank
	private String paymentMode;
	
	private int paymentTermDays;
	
	@JoinColumn(name = "invoiceId")
	@OneToMany(fetch = FetchType.EAGER)
	@NotEmpty
	private Set<PurchaseLine> purchaseLines;
	
	@NotBlank
	private String soggettoEmittente;
	
	@NotBlank
	private String soggettoEmittenteName;
	
	private double stampAmount;

	private double taxableAmount;

	@NotBlank
	private String taxDue;
	
	private double totalAmount;
	
	@NotNull
	private LocalDate transportDocumentDate;
	@NotBlank
	private String transportDocumentId;
	
	private Boolean virtualStamp;
	
	public Invoice() {
	}
	
	public Invoice(String number) {
		this();
		this.number = number;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Invoice) == false) {
			return false;
		}
		Invoice rhs = ((Invoice) other);
		return new EqualsBuilder()
				.append(cedentePrestatore, rhs.cedentePrestatore)
				.append(cessionarioCommittente, rhs.cessionarioCommittente)
				.append(date, rhs.date)
				.append(description, rhs.description)
				.append(discountType, rhs.discountType)
				.append(discountAmount, rhs.discountAmount)
				.append(documentTypeCode, rhs.documentTypeCode)
				.append(financialInstitution, rhs.financialInstitution)
				.append(invoiceSenderCode, rhs.invoiceSenderCode)
				.append(invoiceSenderCountryCode, rhs.invoiceSenderCountryCode)
				.append(invoiceSendingNumber, rhs.invoiceSendingNumber)
				.append(invoiceRecipientCode, rhs.invoiceRecipientCode)
				.append(invoiceSendingFormat, rhs.invoiceSendingFormat)
				.append(invoiceVersion, rhs.invoiceVersion)
				.append(number, rhs.number)
				.append(paymentConditions, rhs.paymentConditions)
				.append(paymentMode, rhs.paymentMode)
				.append(paymentTermDays, rhs.paymentTermDays)
				.append(paymentExpirationDate, rhs.paymentExpirationDate)
				.append(paymentAmount, rhs.paymentAmount)
				.append(soggettoEmittente, rhs.soggettoEmittente)
				.append(soggettoEmittenteName, rhs.soggettoEmittenteName)
				.append(stampAmount, rhs.stampAmount)
				.append(taxableAmount, rhs.taxableAmount)
				.append(taxDue, rhs.taxDue)
				.append(invoiceTax, rhs.invoiceTax)
				.append(totalAmount, rhs.totalAmount)
				.append(transportDocumentId, rhs.transportDocumentId)
				.append(transportDocumentDate, rhs.transportDocumentDate)
				.append(virtualStamp, rhs.virtualStamp)
				.isEquals();
	}
	
	public InvoiceCedentePrestatore getCedentePrestatore() {
		return cedentePrestatore;
	}
	
	public InvoiceParticipant getCessionarioCommittente() {
		return cessionarioCommittente;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public String getDescription() {
		return description;
	}

	public double getDiscountAmount() {
		return discountAmount;
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

	public String getInvoiceRecipientCode() {
		return invoiceRecipientCode;
	}

	public String getInvoiceSenderCode() {
		return invoiceSenderCode;
	}

	public String getInvoiceSenderCountryCode() {
		return invoiceSenderCountryCode;
	}

	public String getInvoiceSendingFormat() {
		return invoiceSendingFormat;
	}

	public String getInvoiceSendingNumber() {
		return invoiceSendingNumber;
	}

	public InvoiceTax getInvoiceTax() {
		return invoiceTax;
	}

	public InvoiceVersion getInvoiceVersion() {
		return invoiceVersion;
	}

	public Set<LinkedInvoice> getLinkedInvoices() {
		return linkedInvoices;
	}

	public String getNumber() {
		return number;
	}

	public double getPaymentAmount() {
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

	public Set<PurchaseLine> getPurchaseLines() {
		return purchaseLines;
	}

	public String getSoggettoEmittente() {
		return soggettoEmittente;
	}

	public String getSoggettoEmittenteName() {
		return soggettoEmittenteName;
	}

	public double getStampAmount() {
		return stampAmount;
	}

	public double getTaxableAmount() {
		return taxableAmount;
	}

	public String getTaxDue() {
		return taxDue;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public LocalDate getTransportDocumentDate() {
		return transportDocumentDate;
	}

	public String getTransportDocumentId() {
		return transportDocumentId;
	}

	public Boolean getVirtualStamp() {
		return virtualStamp;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(cedentePrestatore)
				.append(cessionarioCommittente)
				.append(date)
				.append(description)
				.append(discountType)
				.append(discountAmount)
				.append(documentTypeCode)
				.append(financialInstitution)
				.append(invoiceSenderCode)
				.append(invoiceSenderCountryCode)
				.append(invoiceSendingNumber)
				.append(invoiceRecipientCode)
				.append(invoiceSendingFormat)
				.append(invoiceVersion)
				.append(linkedInvoices)
				.append(number)
				.append(paymentConditions)
				.append(paymentMode)
				.append(paymentTermDays)
				.append(paymentExpirationDate)
				.append(paymentAmount)
				.append(purchaseLines)
				.append(soggettoEmittente)
				.append(soggettoEmittenteName)
				.append(stampAmount)
				.append(taxableAmount)
				.append(taxDue)
				.append(invoiceTax)
				.append(totalAmount)
				.append(transportDocumentId)
				.append(transportDocumentDate)
				.append(virtualStamp)
				.toHashCode();
	}

	public void setCedentePrestatore(InvoiceCedentePrestatore cedentePrestatore) {
		this.cedentePrestatore = cedentePrestatore;
	}

	public void setCessionarioCommittente(InvoiceParticipant cessionarioCommittente) {
		this.cessionarioCommittente = cessionarioCommittente;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
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

	public void setInvoiceRecipientCode(String invoiceRecipientCode) {
		this.invoiceRecipientCode = invoiceRecipientCode;
	}

	public void setInvoiceSenderCode(String invoiceSenderCode) {
		this.invoiceSenderCode = invoiceSenderCode;
	}

	public void setInvoiceSenderCountryCode(String invoiceSenderCountryCode) {
		this.invoiceSenderCountryCode = invoiceSenderCountryCode;
	}

	public void setInvoiceSendingFormat(String invoiceSendingFormat) {
		this.invoiceSendingFormat = invoiceSendingFormat;
	}

	public void setInvoiceSendingNumber(String invoiceSendingNumber) {
		this.invoiceSendingNumber = invoiceSendingNumber;
	}

	public void setInvoiceTax(InvoiceTax invoiceTax) {
		this.invoiceTax = invoiceTax;
	}

	public void setInvoiceVersion(InvoiceVersion invoiceVersion) {
		this.invoiceVersion = invoiceVersion;
	}

	public void setLinkedInvoices(Set<LinkedInvoice> linkedInvoices) {
		this.linkedInvoices = linkedInvoices;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setPaymentAmount(double paymentAmount) {
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

	public void setPurchaseLines(Set<PurchaseLine> purchaseLines) {
		this.purchaseLines = purchaseLines;
	}

	public void setSoggettoEmittente(String soggettoEmittente) {
		this.soggettoEmittente = soggettoEmittente;
	}

	public void setSoggettoEmittenteName(String soggettoEmittenteName) {
		this.soggettoEmittenteName = soggettoEmittenteName;
	}

	public void setStampAmount(double stampAmount) {
		this.stampAmount = stampAmount;
	}

	public void setTaxableAmount(double taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	public void setTaxDue(String taxDue) {
		this.taxDue = taxDue;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setTransportDocumentDate(LocalDate transportDocumentDate) {
		this.transportDocumentDate = transportDocumentDate;
	}

	public void setTransportDocumentId(String transportDocumentId) {
		this.transportDocumentId = transportDocumentId;
	}

	public void setVirtualStamp(Boolean virtualStamp) {
		this.virtualStamp = virtualStamp;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

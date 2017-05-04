package it.gov.aifa.invoice_processor.entity.invoice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
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
	@JoinColumn(name = "version")
	@NotNull
	private InvoiceVersion invoiceVersion;

	@Id
	@NotBlank
	private String number;
	
	@NotBlank
	private String soggettoEmittente;
	
	@NotBlank
	private String soggettoEmittenteName;

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
				.append(invoiceSenderCode, rhs.invoiceSenderCode)
				.append(invoiceSenderCountryCode, rhs.invoiceSenderCountryCode)
				.append(invoiceSendingNumber, rhs.invoiceSendingNumber)
				.append(invoiceRecipientCode, rhs.invoiceRecipientCode)
				.append(invoiceSendingFormat, rhs.invoiceSendingFormat)
				.append(invoiceVersion, rhs.invoiceVersion)
				.append(number, rhs.number)
				.append(soggettoEmittente, rhs.soggettoEmittente)
				.append(soggettoEmittenteName, rhs.soggettoEmittenteName)
				.isEquals();
	}
	
	public InvoiceCedentePrestatore getCedentePrestatore() {
		return cedentePrestatore;
	}

	public InvoiceParticipant getCessionarioCommittente() {
		return cessionarioCommittente;
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

	public InvoiceVersion getInvoiceVersion() {
		return invoiceVersion;
	}

	public String getNumber() {
		return number;
	}

	public String getSoggettoEmittente() {
		return soggettoEmittente;
	}

	public String getSoggettoEmittenteName() {
		return soggettoEmittenteName;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(cedentePrestatore)
				.append(cessionarioCommittente)
				.append(invoiceSenderCode)
				.append(invoiceSenderCountryCode)
				.append(invoiceSendingNumber)
				.append(invoiceRecipientCode)
				.append(invoiceSendingFormat)
				.append(invoiceVersion)
				.append(number)
				.append(soggettoEmittente)
				.append(soggettoEmittenteName)
				.toHashCode();
	}

	public void setCedentePrestatore(InvoiceCedentePrestatore cedentePrestatore) {
		this.cedentePrestatore = cedentePrestatore;
	}

	public void setCessionarioCommittente(InvoiceParticipant cessionarioCommittente) {
		this.cessionarioCommittente = cessionarioCommittente;
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

	public void setInvoiceVersion(InvoiceVersion invoiceVersion) {
		this.invoiceVersion = invoiceVersion;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setSoggettoEmittente(String soggettoEmittente) {
		this.soggettoEmittente = soggettoEmittente;
	}

	public void setSoggettoEmittenteName(String soggettoEmittenteName) {
		this.soggettoEmittenteName = soggettoEmittenteName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

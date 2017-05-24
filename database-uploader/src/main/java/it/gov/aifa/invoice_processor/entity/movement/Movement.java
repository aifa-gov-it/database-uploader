package it.gov.aifa.invoice_processor.entity.movement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.impl.AbstractInvoiceProcessorEntity;

@Entity
@Validated
public class Movement extends AbstractInvoiceProcessorEntity {

	private static final long serialVersionUID = 1614101902310533402L;

	private String accountHolderCode;

	private String accountHolderTypeCode;
	
	@NotBlank
	private String aic;
	
	@NotBlank
	private String customerCode;
	
	@NotBlank
	private String customerTypeCode;
	
	@NotBlank
	private String documentNumber;
	
	@NotBlank
	private String documentTypeCode;
	
	private LocalDate expirationDate;
	
	@NotNull
	private LocalDateTime importDate = LocalDateTime.now();
	
	private String lot;

	@NotBlank
	private String movementCode;

	private Double quantity;
	
	@Transient
	private String rawExpirationDate;
	
	@NotBlank
	private String recipientCode;
	
	@NotBlank
	private String recipientTypeCode;
	
	@NotBlank
	private String senderCode;

	@NotBlank
	private String senderTypeCode;

	@Transient
	private String transmissionDate;
	
	@NotNull
	private LocalDateTime transmissionDateTime;
	
	@Transient
	private String transmissionTime;
	
	private Double value;
	
	public String getAccountHolderCode() {
		return accountHolderCode;
	}
	
	public String getAccountHolderTypeCode() {
		return accountHolderTypeCode;
	}
	
	public String getAic() {
		return aic;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public String getCustomerTypeCode() {
		return customerTypeCode;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public String getDocumentTypeCode() {
		return documentTypeCode;
	}
	
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	
	@Override
	@Transient
	public List<String> getIdValues() {
		List<String> idValues = new ArrayList<>();
		idValues.add(aic);
		idValues.add(transmissionDateTime.toString());
		idValues.add(documentTypeCode);
		idValues.add(documentNumber);
		return idValues;
	}
	
	public LocalDateTime getImportDate() {
		return importDate;
	}

	public String getLot() {
		return lot;
	}

	public String getMovementCode() {
		return movementCode;
	}

	public double getQuantity() {
		return quantity;
	}

	public String getRawExpirationDate() {
		return rawExpirationDate;
	}

	public String getRecipientCode() {
		return recipientCode;
	}

	public String getRecipientTypeCode() {
		return recipientTypeCode;
	}

	public String getSenderCode() {
		return senderCode;
	}

	public String getSenderTypeCode() {
		return senderTypeCode;
	}

	public String getTransmissionDate() {
		return transmissionDate;
	}

	public LocalDateTime getTransmissionDateTime() {
		return transmissionDateTime;
	}

	public String getTransmissionTime() {
		return transmissionTime;
	}

	public Double getValue() {
		return value;
	}

	public void setAccountHolderCode(String accountHolderCode) {
		this.accountHolderCode = accountHolderCode;
	}

	public void setAccountHolderTypeCode(String accountHolderTypeCode) {
		this.accountHolderTypeCode = accountHolderTypeCode;
	}

	public void setAic(String aic) {
		this.aic = aic;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public void setCustomerTypeCode(String customerTypeCode) {
		this.customerTypeCode = customerTypeCode;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public void setDocumentTypeCode(String documentTypeCode) {
		this.documentTypeCode = documentTypeCode;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setImportDate(LocalDateTime importDate) {
		this.importDate = importDate;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public void setMovementCode(String movementCode) {
		this.movementCode = movementCode;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public void setRawExpirationDate(String rawExpirationDate) {
		this.rawExpirationDate = rawExpirationDate;
	}

	public void setRecipientCode(String recipientCode) {
		this.recipientCode = recipientCode;
	}

	public void setRecipientTypeCode(String recipientTypeCode) {
		this.recipientTypeCode = recipientTypeCode;
	}

	public void setSenderCode(String senderCode) {
		this.senderCode = senderCode;
	}

	public void setSenderTypeCode(String senderTypeCode) {
		this.senderTypeCode = senderTypeCode;
	}

	public void setTransmissionDate(String transmissionDate) {
		this.transmissionDate = transmissionDate;
	}

	public void setTransmissionDateTime(LocalDateTime transmissionDateTime) {
		this.transmissionDateTime = transmissionDateTime;
	}

	public void setTransmissionTime(String transmissionTime) {
		this.transmissionTime = transmissionTime;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}

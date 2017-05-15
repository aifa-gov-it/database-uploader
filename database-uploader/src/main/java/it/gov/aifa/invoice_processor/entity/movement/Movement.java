package it.gov.aifa.invoice_processor.entity.movement;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Access(AccessType.FIELD)
@Entity
@Validated
public class Movement {
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
	
	// This field is mapped via it's property
	private String id;
	
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
	
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Movement) == false) {
			return false;
		}
		Movement rhs = ((Movement) other);
		return new EqualsBuilder()
				.append(accountHolderCode, rhs.accountHolderCode)
				.append(accountHolderTypeCode, rhs.accountHolderTypeCode)
				.append(aic, rhs.aic)
				.append(customerCode, rhs.customerCode)
				.append(customerTypeCode, rhs.customerTypeCode)
				.append(documentNumber, rhs.documentNumber)
				.append(documentTypeCode, rhs.documentTypeCode)
				.append(expirationDate, rhs.expirationDate)
				.append(id, rhs.id)
				.append(importDate, rhs.importDate)
				.append(lot, rhs.lot)
				.append(movementCode, rhs.movementCode)
				.append(quantity, rhs.quantity)
				.append(recipientCode, rhs.recipientCode)
				.append(recipientTypeCode, rhs.recipientTypeCode)
				.append(senderCode, rhs.senderCode)
				.append(senderTypeCode, rhs.senderTypeCode)
				.append(transmissionDateTime, rhs.transmissionDateTime)
				.append(value, rhs.value)
				.isEquals();
		
	}
	
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
	
	@Access(AccessType.PROPERTY)
	@Id
	@NotBlank
	public String getId() {
		if(StringUtils.isBlank(id)) {
			StringBuilder builder = new StringBuilder();
			FieldUtils.getAllFieldsList(this.getClass()).stream()
				.forEach(f -> {
					try {
						Object value = FieldUtils.readField(f, this, true);
						if(value != null)
							builder.append(value.toString());
					} catch (IllegalAccessException e) {
						// Let's reuse the StringBuilder
						builder.setLength(0);
						builder.append("Cannot build id for ");
						builder.append(this.toString());
						throw new RuntimeException(builder.toString(), e);
					}
				});
			id = builder.toString();
		}
		return id;
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

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(accountHolderCode)
				.append(accountHolderTypeCode)
				.append(aic)
				.append(customerCode)
				.append(customerTypeCode)
				.append(documentNumber)
				.append(documentTypeCode)
				.append(expirationDate)
				.append(id)
				.append(importDate)
				.append(lot)
				.append(movementCode)
				.append(quantity)
				.append(recipientCode)
				.append(recipientTypeCode)
				.append(senderCode)
				.append(senderTypeCode)
				.append(transmissionDateTime)
				.append(value)
				.toHashCode();
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

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
package it.gov.aifa.invoice_processor.entity.movement;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.impl.AbstractInvoiceProcessorEntity;

@Entity
@Table(
		name = "MDS_MOV"
		, uniqueConstraints = @UniqueConstraint( columnNames={"aic", "lot", "transmissionDateTime", "documentTypeCode", "documentNumber"} )
		)
@Validated
public class Movement extends AbstractInvoiceProcessorEntity {

	private static final long serialVersionUID = 1614101902310533402L;

	private String accountHolderCode;

	private String accountHolderTypeCode;
	
	private String aic;
	
	private String customerCode;
	
	private String customerTypeCode;
	
	private String documentNumber;
	
	private String documentTypeCode;
	
	private Date expirationDate;
	
	private String lot;

	private String movementCode;

	private Double quantity;
	
	private String rawExpirationDate;
	
	private String recipientCode;
	
	private String recipientTypeCode;
	
	private String senderCode;

	private String senderTypeCode;

	private String transmissionDate;
	
	private Timestamp transmissionDateTime;
	
	private String transmissionTime;
	
	private Double value;
	
	public Movement() {
		super();
	}
	
	public Movement(
			@NotBlank String aic
			, @NotBlank String documentNumber
			, @NotBlank String documentTypeCode
			, @NotBlank String lot
			, @NotBlank String transmissionDate
			, @NotBlank String transmissionTime) {
		this();
		this.aic = aic;
		this.documentNumber = documentNumber;
		this.documentTypeCode = documentTypeCode;
		this.lot = lot;
		setTransmissionDate(transmissionDate);
		setTransmissionTime(transmissionTime);
		updateTransmissionDateTime();
		updateId();
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
	
	public Date getExpirationDate() {
		updateExpirationDate();
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
		if(StringUtils.isNotBlank(lot))
			idValues.add(lot);
		return idValues;
	}
	
	public String getLot() {
		return lot;
	}

	public String getMovementCode() {
		return movementCode;
	}

	public Double getQuantity() {
		return quantity;
	}

	@Transient
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

	@Transient
	public String getTransmissionDate() {
		return transmissionDate;
	}

	public Timestamp getTransmissionDateTime() {
		updateTransmissionDateTime();
		return transmissionDateTime;
	}

	@Transient
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

	public void setAic(@NotBlank String aic) {
		this.aic = aic;
	}

	public void setCustomerCode(@NotBlank String customerCode) {
		this.customerCode = customerCode;
	}

	public void setCustomerTypeCode(@NotBlank String customerTypeCode) {
		this.customerTypeCode = customerTypeCode;
	}

	public void setDocumentNumber(@NotBlank String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public void setDocumentTypeCode(@NotBlank String documentTypeCode) {
		this.documentTypeCode = documentTypeCode;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public void setMovementCode(@NotBlank String movementCode) {
		this.movementCode = movementCode;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	
	public void setRawExpirationDate(String rawExpirationDate) {
		this.rawExpirationDate = rawExpirationDate;
		updateExpirationDate();
	}

	public void setRecipientCode(@NotBlank String recipientCode) {
		this.recipientCode = recipientCode;
	}

	public void setRecipientTypeCode(@NotBlank String recipientTypeCode) {
		this.recipientTypeCode = recipientTypeCode;
	}

	public void setSenderCode(@NotBlank String senderCode) {
		this.senderCode = senderCode;
	}

	public void setSenderTypeCode(@NotBlank String senderTypeCode) {
		this.senderTypeCode = senderTypeCode;
	}

	public void setTransmissionDate(String transmissionDate) {
		this.transmissionDate = transmissionDate;
		updateTransmissionDateTime();
	}

	public void setTransmissionDateTime(@NotNull Timestamp transmissionDateTime) {
		this.transmissionDateTime = transmissionDateTime;
	}

	public void setTransmissionTime(String transmissionTime) {
		this.transmissionTime = transmissionTime;
		updateTransmissionDateTime();
	}

	public void setValue(Double value) {
		this.value = value;
	}

	private void updateExpirationDate() {
		if(expirationDate == null && StringUtils.isNotBlank(rawExpirationDate))
			expirationDate = Date.valueOf(LocalDate.parse(rawExpirationDate));
	}

	private void updateTransmissionDateTime() {
		if(
				transmissionDateTime == null
				&& StringUtils.isNotBlank(transmissionDate)
				&& StringUtils.isNotBlank(transmissionTime)
				) {
		StringBuilder transmissionDateTime = new StringBuilder(transmissionDate.length() + transmissionTime.length() + 1);
		transmissionDateTime.append(transmissionDate);
		transmissionDateTime.append("T");
		transmissionDateTime.append(transmissionTime);
		this.transmissionDateTime = Timestamp.valueOf(LocalDateTime.parse(transmissionDateTime));
		}
	}
}

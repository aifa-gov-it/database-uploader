package it.gov.aifa.invoice_processor.entity.invoice;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.impl.AbstractInvoiceReferenceEntity;

@Entity
@Validated
public class PurchaseLine extends AbstractInvoiceReferenceEntity{
	
	private static final long serialVersionUID = 3245656788830144352L;

	private String administrativeReference;
	
	@NotBlank
	private String documentId;

	private String itemCode;

	private String itemCodeType;
	
	@NotBlank
	private String itemDescription;

	private String kind;

	private String otherMgmtDataDataType;
	
	private Date otherMgmtDataDate;
	
	private BigDecimal otherMgmtDataRefNumber;
	
	private String otherMgmtDataRefText;
	
	private Date periodEndDate;
	
	private Date periodStartDate;
	
	private BigDecimal quantity;

	private String ritenuta;

	private BigDecimal scontoMaggAmount;

	private BigDecimal scontoMaggPercentage;

	private String scontoMaggType;

	@NotNull
	private BigDecimal taxRate;

	private String tipoCessazionePrestazione;

	@NotNull
	private BigDecimal totalPrice;

	private String unitOfMeasureDescription;

	@NotNull
	private BigDecimal unitPrice;

	public PurchaseLine() {
		super();
	}

	public PurchaseLine(String purchaseLineNumber, Invoice invoice) {
		super(invoice);
		this.documentId = purchaseLineNumber;
	}

	@Override
	@Transient
	protected List<String> getAdditionalIdValues() {
		List<String> additionalIdValues = new ArrayList<>();
		additionalIdValues.add(documentId);
		return Collections.unmodifiableList(additionalIdValues);
	}

	public String getAdministrativeReference() {
		return administrativeReference;
	}
	
	public String getDocumentId() {
		return documentId;
	}
	
	public String getItemCode() {
		return itemCode;
	}
	
	public String getItemCodeType() {
		return itemCodeType;
	}

	@Lob
	public String getItemDescription() {
		return itemDescription;
	}

	public String getKind() {
		return kind;
	}

	public String getOtherMgmtDataDataType() {
		return otherMgmtDataDataType;
	}

	public Date getOtherMgmtDataDate() {
		return otherMgmtDataDate;
	}

	public BigDecimal getOtherMgmtDataRefNumber() {
		return otherMgmtDataRefNumber;
	}

	public String getOtherMgmtDataRefText() {
		return otherMgmtDataRefText;
	}

	public Date getPeriodEndDate() {
		return periodEndDate;
	}

	public Date getPeriodStartDate() {
		return periodStartDate;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public String getRitenuta() {
		return ritenuta;
	}
	
	public BigDecimal getScontoMaggAmount() {
		return scontoMaggAmount;
	}
	
	public BigDecimal getScontoMaggPercentage() {
		return scontoMaggPercentage;
	}

	public String getScontoMaggType() {
		return scontoMaggType;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}
	
	public String getTipoCessazionePrestazione() {
		return tipoCessazionePrestazione;
	}
	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	
	public String getUnitOfMeasureDescription() {
		return unitOfMeasureDescription;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setAdministrativeReference(String administrativeReference) {
		this.administrativeReference = administrativeReference;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public void setItemCodeType(String itemCodeType) {
		this.itemCodeType = itemCodeType;
	}
	
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public void setOtherMgmtDataDataType(String otherMgmtDataDataType) {
		this.otherMgmtDataDataType = otherMgmtDataDataType;
	}

	public void setOtherMgmtDataDate(Date otherMgmtDataDate) {
		this.otherMgmtDataDate = otherMgmtDataDate;
	}

	public void setOtherMgmtDataRefNumber(BigDecimal otherMgmtDataRefNumber) {
		this.otherMgmtDataRefNumber = otherMgmtDataRefNumber;
	}

	public void setOtherMgmtDataRefText(String otherMgmtDataRefText) {
		this.otherMgmtDataRefText = otherMgmtDataRefText;
	}

	public void setPeriodEndDate(Date periodEndDate) {
		this.periodEndDate = periodEndDate;
	}

	public void setPeriodStartDate(Date periodStartDate) {
		this.periodStartDate = periodStartDate;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public void setRitenuta(String ritenuta) {
		this.ritenuta = ritenuta;
	}

	public void setScontoMaggAmount(BigDecimal scontoMaggAmount) {
		this.scontoMaggAmount = scontoMaggAmount;
	}

	public void setScontoMaggPercentage(BigDecimal scontoMaggPercentage) {
		this.scontoMaggPercentage = scontoMaggPercentage;
	}

	public void setScontoMaggType(String scontoMaggType) {
		this.scontoMaggType = scontoMaggType;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public void setTipoCessazionePrestazione(String tipoCessazionePrestazione) {
		this.tipoCessazionePrestazione = tipoCessazionePrestazione;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public void setUnitOfMeasureDescription(String unitOfMeasureDescription) {
		this.unitOfMeasureDescription = unitOfMeasureDescription;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
}

package it.gov.aifa.invoice_processor.entity.invoice;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class PurchaseLine extends DocumentoCorrelato{
	
	private String administrativeReference;
	
	@NotBlank
	private String itemCode;
	
	@NotBlank
	private String itemCodeType;
	
	@NotBlank
	private String itemDescription;
	
	private String kind;
	
	private String otherManagementDataDataType;
	
	private LocalDate otherManagementDataDate;
	
	private BigDecimal otherManagementDataReferenceNumber;

	private String otherManagementDataReferenceText;

	private LocalDate periodEndDate;

	private LocalDate periodStartDate;

	private BigDecimal quantity;

	private String ritenuta;

	private BigDecimal scontoMaggiorazioneAmount;

	private BigDecimal scontoMaggiorazionePercentage;

	private String scontoMaggiorazioneType;

	private BigDecimal taxRate;

	private String tipoCessazionePrestazione;

	private BigDecimal totalPrice;

	private String unitOfMeasureDescription;

	private BigDecimal unitPrice;

	public PurchaseLine() {
	}
	
	public PurchaseLine(String purchaseLineNumber, Invoice invoice) {
		super(purchaseLineNumber, invoice);
	}
	
	public String getAdministrativeReference() {
		return administrativeReference;
	}
	
	public String getItemCode() {
		return itemCode;
	}

	public String getItemCodeType() {
		return itemCodeType;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public String getKind() {
		return kind;
	}

	public String getOtherManagementDataDataType() {
		return otherManagementDataDataType;
	}

	public LocalDate getOtherManagementDataDate() {
		return otherManagementDataDate;
	}

	public BigDecimal getOtherManagementDataReferenceNumber() {
		return otherManagementDataReferenceNumber;
	}

	public String getOtherManagementDataReferenceText() {
		return otherManagementDataReferenceText;
	}

	public LocalDate getPeriodEndDate() {
		return periodEndDate;
	}

	public LocalDate getPeriodStartDate() {
		return periodStartDate;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}
	
	public String getRitenuta() {
		return ritenuta;
	}
	
	public BigDecimal getScontoMaggiorazioneAmount() {
		return scontoMaggiorazioneAmount;
	}

	public BigDecimal getScontoMaggiorazionePercentage() {
		return scontoMaggiorazionePercentage;
	}

	public String getScontoMaggiorazioneType() {
		return scontoMaggiorazioneType;
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

	public void setOtherManagementDataDataType(String otherManagementDataDataType) {
		this.otherManagementDataDataType = otherManagementDataDataType;
	}

	public void setOtherManagementDataDate(LocalDate otherManagementDataDate) {
		this.otherManagementDataDate = otherManagementDataDate;
	}

	public void setOtherManagementDataReferenceNumber(BigDecimal otherManagementDataReferenceNumber) {
		this.otherManagementDataReferenceNumber = otherManagementDataReferenceNumber;
	}

	public void setOtherManagementDataReferenceText(String otherManagementDataReferenceText) {
		this.otherManagementDataReferenceText = otherManagementDataReferenceText;
	}

	public void setPeriodEndDate(LocalDate periodEndDate) {
		this.periodEndDate = periodEndDate;
	}

	public void setPeriodStartDate(LocalDate periodStartDate) {
		this.periodStartDate = periodStartDate;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public void setRitenuta(String ritenuta) {
		this.ritenuta = ritenuta;
	}

	public void setScontoMaggiorazioneAmount(BigDecimal scontoMaggiorazioneAmount) {
		this.scontoMaggiorazioneAmount = scontoMaggiorazioneAmount;
	}

	public void setScontoMaggiorazionePercentage(BigDecimal scontoMaggiorazionePercentage) {
		this.scontoMaggiorazionePercentage = scontoMaggiorazionePercentage;
	}

	public void setScontoMaggiorazioneType(String scontoMaggiorazioneType) {
		this.scontoMaggiorazioneType = scontoMaggiorazioneType;
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

package it.gov.aifa.invoice_processor.entity.invoice;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class PurchaseLine extends AbstractInvoiceReferenceDocument{
	@EmbeddedId
	@NotNull
	private IdAndInvoiceIdPrimaryKey id;
	
	@NotBlank
	private String itemCode;
	
	@NotBlank
	private String itemCodeType;
	
	@NotBlank
	private String itemDescription;

	private double quantity;

	private double taxRate;
	
	private double totalPrice;

	@NotBlank
	private String unitOfMeasureDescription;

	private double unitPrice;

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof PurchaseLine) == false) {
			return false;
		}
		PurchaseLine rhs = ((PurchaseLine) other);
		return new EqualsBuilder()
				.append(id, rhs.id)
				.append(itemCode, rhs.itemCode)
				.append(itemCodeType, rhs.itemCodeType)
				.append(itemDescription, rhs.itemDescription)
				.append(taxRate, rhs.taxRate)
				.append(totalPrice, rhs.totalPrice)
				.append(unitOfMeasureDescription, rhs.unitOfMeasureDescription)
				.append(unitPrice, rhs.unitPrice)
				.isEquals();
	}

	public IdAndInvoiceIdPrimaryKey getId() {
		return id;
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

	public double getQuantity() {
		return quantity;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public String getUnitOfMeasureDescription() {
		return unitOfMeasureDescription;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(id)
				.append(itemCode)
				.append(itemCodeType)
				.append(itemDescription)
				.append(taxRate)
				.append(totalPrice)
				.append(unitOfMeasureDescription)
				.append(unitPrice)
				.toHashCode();
	}

	public void setId(IdAndInvoiceIdPrimaryKey id) {
		this.id = id;
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

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setUnitOfMeasureDescription(String unitOfMeasureDescription) {
		this.unitOfMeasureDescription = unitOfMeasureDescription;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

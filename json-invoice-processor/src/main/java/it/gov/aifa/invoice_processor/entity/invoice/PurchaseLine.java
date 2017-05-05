package it.gov.aifa.invoice_processor.entity.invoice;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class PurchaseLine {
	@EmbeddedId
	@Id
	@NotNull
	private PurchaseLinePrimaryKey id;
	
    @JoinColumn(name = "invoiceId", referencedColumnName = "number")
    @ManyToOne
    @MapsId("invoiceId")
	private Invoice invoice;
	
	@JoinColumn(name = "itemId", referencedColumnName = "id")
	@ManyToOne
	@NotNull
	private InvoiceItem item;

	private double quantity;

	@JoinColumn(name = "taxId", referencedColumnName = "id")
	@ManyToOne
	@NotNull
	private InvoiceTax tax;
	
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
				.append(item, rhs.item)
				.append(tax, rhs.tax)
				.append(totalPrice, rhs.totalPrice)
				.append(unitOfMeasureDescription, rhs.unitOfMeasureDescription)
				.append(unitPrice, rhs.unitPrice)
				.isEquals();
	}

	public PurchaseLinePrimaryKey getId() {
		return id;
	}

	public Invoice getInvoice() {
		return invoice;
	}
	
	public InvoiceItem getItem() {
		return item;
	}

	public double getQuantity() {
		return quantity;
	}
	
	public InvoiceTax getTax() {
		return tax;
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
				.append(item)
				.append(tax)
				.append(totalPrice)
				.append(unitOfMeasureDescription)
				.append(unitPrice)
				.toHashCode();
	}

	public void setId(PurchaseLinePrimaryKey id) {
		this.id = id;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public void setItem(InvoiceItem item) {
		this.item = item;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	public void setTax(InvoiceTax tax) {
		this.tax = tax;
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

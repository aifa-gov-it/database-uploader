package it.gov.aifa.invoice_processor.entity.invoice;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class PurchaseOrder extends LinkedInvoice{
	private String cigCode;
	
	@JoinColumns({
		@JoinColumn(name = "purchaseLineInvoiceId", referencedColumnName = "invoiceId")
		, @JoinColumn(name = "purchaseLineNumber", referencedColumnName = "number")
	})
	@OneToOne(optional = true)
	private PurchaseLine purchaseLine;
	
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof PurchaseOrder) == false) {
			return false;
		}
		PurchaseOrder rhs = ((PurchaseOrder) other);
		return new EqualsBuilder()
				.append(cigCode, rhs.cigCode)
				.append(purchaseLine, rhs.purchaseLine)
				.appendSuper(super.equals(other))
				.isEquals();
	}

	public String getCigCode() {
		return cigCode;
	}

	public PurchaseLine getPurchaseLine() {
		return purchaseLine;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(cigCode)
				.append(purchaseLine)
				.appendSuper(super.hashCode())
				.toHashCode();
	}
	
	public void setCigCode(String cigCode) {
		this.cigCode = cigCode;
	}
	
	public void setPurchaseLine(PurchaseLine purchaseLine) {
		this.purchaseLine = purchaseLine;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

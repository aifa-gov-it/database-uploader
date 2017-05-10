package it.gov.aifa.invoice_processor.entity.invoice;

import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class PurchaseOrder extends AbstractInvoiceReferenceDocument{

	private String cigCode;

	@NotNull
	private LocalDate date;

	@NotBlank
	private String documentId;

	@EmbeddedId
	@NotNull
	private IdAndInvoiceIdPrimaryKey id;

	@JoinColumns({
		@JoinColumn(name = "purchaseLineInvoiceId", referencedColumnName = "invoiceId")
		, @JoinColumn(name = "purchaseLineNumber", referencedColumnName = "id")
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
				.append(date, rhs.date)
				.append(documentId, rhs.documentId)
				.append(getId(), rhs.getId())
				.isEquals();
	}

	public String getCigCode() {
		return cigCode;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getDocumentId() {
		return documentId;
	}

	public IdAndInvoiceIdPrimaryKey getId() {
		if(id == null) {
			StringBuilder builder = new StringBuilder();
			builder.append(StringUtils.defaultString(cigCode));
			if(date != null) {
				builder.append("_");
				builder.append(date.toString());
			}
			
			if(!StringUtils.isBlank(documentId)) {
				builder.append(StringUtils.defaultString("_"));
				builder.append(StringUtils.defaultString(documentId));
			}
			
			if(purchaseLine != null) {
				builder.append(StringUtils.defaultString("_"));
				builder.append(StringUtils.defaultString(purchaseLine.getId().getInvoiceId()));
				builder.append(StringUtils.defaultString("_"));
				builder.append(StringUtils.defaultString(purchaseLine.getId().getId()));
				builder.append(StringUtils.defaultString("_"));
			}
			id = new IdAndInvoiceIdPrimaryKey(getInvoice().getNumber(), builder.toString());
		}
		return id;
	}

	public PurchaseLine getPurchaseLine() {
		return purchaseLine;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(date)
				.append(documentId)
				.append(getId())
				.toHashCode();
	}

	public void setCigCode(String cigCode) {
		this.cigCode = cigCode;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public void setPurchaseLine(PurchaseLine purchaseLine) {
		this.purchaseLine = purchaseLine;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

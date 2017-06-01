package it.gov.aifa.invoice_processor.entity.invoice;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.impl.AbstractInvoiceReferenceEntity;

@Entity
@Validated
public class DocumentoCorrelato extends AbstractInvoiceReferenceEntity {

	private static final long serialVersionUID = -3186740429054516900L;

	private String cigCode;

	private String codiceCommessaConvenzione;

	private String codiceCUP;

	private Date data;

	private String documentId;

	private String documentoCorrelatoType;

	private String numItem;

	private Set<PurchaseLine> purchaseLine;

	public DocumentoCorrelato() {
		super();
	}

	public DocumentoCorrelato(
			@NotNull Date data
			, @NotBlank String documentId
			, @NotBlank String documentoCorrelatoType
			, @NotNull Invoice invoice
			, Set<PurchaseLine> purchaseLine
			) {
		this(documentId, documentoCorrelatoType, invoice);
		this.data = data;
		this.purchaseLine = purchaseLine;
	}

	public DocumentoCorrelato(@NotBlank String documentoCorrelatoType, @NotNull Invoice invoice) {
		super(invoice);
		this.documentoCorrelatoType = documentoCorrelatoType;
	}

	public DocumentoCorrelato(
			@NotBlank String documentId
			, @NotBlank String documentoCorrelatoType
			, @NotNull Invoice invoice
			) {
		this(documentoCorrelatoType, invoice);
		this.documentId = documentId;
		this.documentoCorrelatoType = documentoCorrelatoType;
	}

	public DocumentoCorrelato(
			String cigCode
			, String codiceCommessaConvenzione
			, String codiceCUP
			, Date data
			, @NotBlank String documentoCorrelatoType
			, @NotBlank String documentId
			, @NotNull Invoice invoice
			, String numItem
			, Set<PurchaseLine> purchaseLines
			) {
		this(data, documentId, documentoCorrelatoType, invoice, purchaseLines);
		this.cigCode = cigCode;
		this.codiceCommessaConvenzione = codiceCommessaConvenzione;
		this.codiceCUP = codiceCUP;
		this.numItem = numItem;
	}
	
	@Override
	@Transient
	protected List<String> getAdditionalIdValues() {
		List<String> additionalIdValues = new ArrayList<>();
		additionalIdValues.add(documentId);
		additionalIdValues.add(documentoCorrelatoType.toString());
		if(StringUtils.isNotBlank(cigCode))
			additionalIdValues.add(cigCode);
		if(StringUtils.isNotBlank(codiceCommessaConvenzione))
			additionalIdValues.add(codiceCommessaConvenzione);
		if(StringUtils.isNotBlank(codiceCUP))
			additionalIdValues.add(codiceCUP);
		if(data != null)
			additionalIdValues.add(data.toString());
		if(purchaseLine != null)
			for(PurchaseLine purchaseLine : purchaseLine) 
				if(StringUtils.isNotBlank(purchaseLine.getDocumentId()))
					additionalIdValues.add(purchaseLine.getDocumentId());
		return Collections.unmodifiableList(additionalIdValues);
	}

	public String getCigCode() {
		return cigCode;
	}

	public String getCodiceCommessaConvenzione() {
		return codiceCommessaConvenzione;
	}

	public String getCodiceCUP() {
		return codiceCUP;
	}

	public Date getData() {
		return data;
	}

	public String getDocumentId() {
		return documentId;
	}

	public String getDocumentoCorrelatoType() {
		return documentoCorrelatoType;
	}
	public String getNumItem() {
		return numItem;
	}
	
	@JoinTable(name = "documento_corr_purchase_line")
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	public Set<PurchaseLine> getPurchaseLine() {
		return purchaseLine;
	}

	public void setCigCode(String cigCode) {
		this.cigCode = cigCode;
	}

	public void setCodiceCommessaConvenzione(String codiceCommessaConvenzione) {
		this.codiceCommessaConvenzione = codiceCommessaConvenzione;
	}

	public void setCodiceCUP(String codiceCUP) {
		this.codiceCUP = codiceCUP;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setDocumentId(@NotBlank String documentId) {
		this.documentId = documentId;
	}

	public void setDocumentoCorrelatoType(@NotBlank String documentoCorrelatoType) {
		this.documentoCorrelatoType = documentoCorrelatoType;
	}

	public void setNumItem(String numItem) {
		this.numItem = numItem;
	}

	public void setPurchaseLine(Set<PurchaseLine> purchaseLine) {
		this.purchaseLine = purchaseLine;
	}
}

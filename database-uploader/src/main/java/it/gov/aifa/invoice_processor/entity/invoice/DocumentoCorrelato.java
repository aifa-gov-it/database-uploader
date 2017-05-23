package it.gov.aifa.invoice_processor.entity.invoice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.impl.AbstractInvoiceReferenceEntity;

// TODO: setup inheritance
@Entity
@Validated
public class DocumentoCorrelato extends AbstractInvoiceReferenceEntity {

	private String cigCode;

	private String codiceCommessaConvenzione;

	private String codiceCUP;

	private LocalDate data;

	@NotBlank
	private String documentId;

	@Id
	@NotBlank
	private String id;

	private String numItem;

	@OneToMany
	private List<PurchaseLine> relatedPurchaseLines;

	public DocumentoCorrelato() {}

	public DocumentoCorrelato(
			@NotNull LocalDate data
			, @NotBlank String documentId
			, @NotNull Invoice invoice
			, List<PurchaseLine> relatedPurchaseLines
			) {
		this(documentId, invoice);
		this.data = data;
		this.relatedPurchaseLines = relatedPurchaseLines;
	}

	public DocumentoCorrelato(
			@NotBlank String documentId
			, @NotNull Invoice invoice
			) {
		super(invoice);
		this.documentId = documentId;
	}

	public DocumentoCorrelato(
			String cigCode
			, String codiceCommessaConvenzione
			, String codiceCUP
			, @NotNull LocalDate data
			, @NotBlank String documentId
			, @NotNull Invoice invoice
			, String numItem
			, List<PurchaseLine> relatedPurchaseLines
			) {
		this(data, documentId, invoice, relatedPurchaseLines);
		this.cigCode = cigCode;
		this.codiceCommessaConvenzione = codiceCommessaConvenzione;
		this.codiceCUP = codiceCUP;
		this.numItem = numItem;
	}

	@Override
	protected List<String> getAdditionalIdValues() {
		List<String> additionalIdValues = new ArrayList<>();
		additionalIdValues.add(documentId);
		additionalIdValues.add(cigCode);
		additionalIdValues.add(codiceCommessaConvenzione);
		additionalIdValues.add(codiceCUP);
		additionalIdValues.add(data.toString());
		if(relatedPurchaseLines != null)
			for(PurchaseLine purchaseLine : relatedPurchaseLines) 
				if(StringUtils.isBlank(purchaseLine.getDocumentId()))
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

	public LocalDate getData() {
		return data;
	}
	public String getDocumentId() {
		return documentId;
	}

	public String getId() {
		return id;
	}

	public String getNumItem() {
		return numItem;
	}

	public List<PurchaseLine> getRelatedPurchaseLines() {
		return relatedPurchaseLines;
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

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNumItem(String numItem) {
		this.numItem = numItem;
	}

	public void setRelatedPurchaseLines(List<PurchaseLine> relatedPurchaseLines) {
		this.relatedPurchaseLines = relatedPurchaseLines;
	}
}

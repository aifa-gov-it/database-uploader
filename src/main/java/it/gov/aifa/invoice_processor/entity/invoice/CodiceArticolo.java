package it.gov.aifa.invoice_processor.entity.invoice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.impl.AbstractInvoiceReferenceEntity;

@Entity
@Table(name = "MEF_CODICE_ARTICOLO_FATTURA")
@Validated
public class CodiceArticolo extends AbstractInvoiceReferenceEntity {
	
	private static final long serialVersionUID = 8085336139874894622L;
	private String itemCode;
	private String itemCodeType;
	private PurchaseLine purchaseLine;
		
	
    public CodiceArticolo() {
        super();
    }
    
    public CodiceArticolo(Invoice invoice, @NotNull PurchaseLine purchaseLine) {
        super(invoice);
        this.purchaseLine = purchaseLine;
    }
    
    @Override
	@Transient
	protected List<String> getAdditionalIdValues() {
		List<String> additionalIdValues = new ArrayList<>();
		additionalIdValues.add(purchaseLine.getId());
		additionalIdValues.add(itemCodeType);
		additionalIdValues.add(itemCode);
		return Collections.unmodifiableList(additionalIdValues);
	}
	
	public String getItemCode() {
		return itemCode;
	}
	
	public String getItemCodeType() {
		return itemCodeType;
	}

	@JoinColumn(name = "purchaseLineId", referencedColumnName = "id")
	@ManyToOne
	public PurchaseLine getPurchaseLine() {
		return purchaseLine;
	}
	
    public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
    
    
    public void setItemCodeType(String itemCodeType) {
		this.itemCodeType = itemCodeType;
	}


	public void setPurchaseLine(@NotNull PurchaseLine purchaseLine) {
		this.purchaseLine = purchaseLine;
	}
    
}

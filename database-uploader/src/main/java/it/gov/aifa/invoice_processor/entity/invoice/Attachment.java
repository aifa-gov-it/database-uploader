package it.gov.aifa.invoice_processor.entity.invoice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.impl.AbstractInvoiceReferenceEntity;

@Entity
@Validated
public class Attachment extends AbstractInvoiceReferenceEntity {
	
	private String compressionAlgorithm;
	
	@NotEmpty
	private byte[] data;
	
	private String description;
	
	private String format;
	
	@NotBlank
	private String name;
	
	public Attachment() {
		super();
	}

	public Attachment(Invoice invoice) {
		super(invoice);
	}

	@Override
	@Transient
	protected List<String> getAdditionalIdValues() {
		List<String> additionalIdValues = new ArrayList<>();
		additionalIdValues.add(name);
		return Collections.unmodifiableList(additionalIdValues);
	}
	
	public String getCompressionAlgorithm() {
		return compressionAlgorithm;
	}
	
	public byte[] getData() {
		return data;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getFormat() {
		return format;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCompressionAlgorithm(String compressionAlgorithm) {
		this.compressionAlgorithm = compressionAlgorithm;
	}
	
	public void setData(byte[] data) {
		this.data = data;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

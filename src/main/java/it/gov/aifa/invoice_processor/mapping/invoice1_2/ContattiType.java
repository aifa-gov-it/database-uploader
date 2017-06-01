package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContattiType", propOrder = { "telefono", "fax", "email" })
public class ContattiType {

	@XmlElement(name = "Email")
	protected String email;

	@XmlElement(name = "Fax")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String fax;

	@XmlElement(name = "Telefono")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String telefono;
	
	public ContattiType() {
	}
	
	public ContattiType(String email, String fax, String telefono) {
		this.email = email;
		this.fax = fax;
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public String getFax() {
		return fax;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setEmail(String value) {
		this.email = value;
	}

	public void setFax(String value) {
		this.fax = value;
	}

	public void setTelefono(String value) {
		this.telefono = value;
	}

}

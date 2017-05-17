package it.gov.aifa.invoice_processor.mapping.org.w3._2000._09.xmldsig_;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignaturePropertiesType", propOrder = { "signatureProperty" })
public class SignaturePropertiesType {

	@XmlElement(name = "SignatureProperty", required = true)
	protected List<SignaturePropertyType> signatureProperty;
	@XmlAttribute(name = "Id")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;

	public List<SignaturePropertyType> getSignatureProperty() {
		if (signatureProperty == null) {
			signatureProperty = new ArrayList<SignaturePropertyType>();
		}
		return this.signatureProperty;
	}

	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

}

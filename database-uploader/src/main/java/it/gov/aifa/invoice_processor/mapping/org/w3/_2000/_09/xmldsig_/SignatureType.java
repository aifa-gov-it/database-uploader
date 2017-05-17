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
@XmlType(name = "SignatureType", propOrder = { "signedInfo", "signatureValue", "keyInfo", "object" })
public class SignatureType {

	@XmlElement(name = "SignedInfo", required = true)
	protected SignedInfoType signedInfo;
	@XmlElement(name = "SignatureValue", required = true)
	protected SignatureValueType signatureValue;
	@XmlElement(name = "KeyInfo")
	protected KeyInfoType keyInfo;
	@XmlElement(name = "Object")
	protected List<ObjectType> object;
	@XmlAttribute(name = "Id")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;

	public SignedInfoType getSignedInfo() {
		return signedInfo;
	}

	public void setSignedInfo(SignedInfoType value) {
		this.signedInfo = value;
	}

	public SignatureValueType getSignatureValue() {
		return signatureValue;
	}

	public void setSignatureValue(SignatureValueType value) {
		this.signatureValue = value;
	}

	public KeyInfoType getKeyInfo() {
		return keyInfo;
	}

	public void setKeyInfo(KeyInfoType value) {
		this.keyInfo = value;
	}

	public List<ObjectType> getObject() {
		if (object == null) {
			object = new ArrayList<ObjectType>();
		}
		return this.object;
	}

	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

}

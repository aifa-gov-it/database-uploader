package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

import it.gov.aifa.invoice_processor.constant.InvoiceVersion;

@XmlType(name = "FormatoTrasmissioneType")
@XmlEnum
public enum FormatoTrasmissioneType {
	
	@XmlEnumValue("FPA12")
	FPA_12("FPA12", InvoiceVersion.VERSION_1_2),

	@XmlEnumValue("FPR12")
	FPR_12("FPR12", InvoiceVersion.VERSION_1_2),

	@XmlEnumValue("SDI11")
    SDI_11("SDI11", InvoiceVersion.VERSION_1_1),
	
	@XmlEnumValue("1.1")
    LEGACY_1_1("1.1", InvoiceVersion.VERSION_1_1);
	
	
	public static FormatoTrasmissioneType fromValue(String v) {
		for (FormatoTrasmissioneType c : FormatoTrasmissioneType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

	private final String value;
	private final String version;

	FormatoTrasmissioneType(String value, String version) {
		this.value = value;
		this.version = version;
	}

	public String value() {
		return value;
	}
	
	public String version() {
		return version;
	}

}

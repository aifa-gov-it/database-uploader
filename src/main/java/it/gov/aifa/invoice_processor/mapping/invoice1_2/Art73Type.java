package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Art73Type")
@XmlEnum
public enum Art73Type {

	SI;

	public static Art73Type fromValue(String v) {
		return valueOf(v);
	}

	public String value() {
		return name();
	}

}

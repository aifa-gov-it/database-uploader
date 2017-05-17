package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "BolloVirtualeType")
@XmlEnum
public enum BolloVirtualeType {

	SI;

	public String value() {
		return name();
	}

	public static BolloVirtualeType fromValue(String v) {
		return valueOf(v);
	}

}

package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "SocioUnicoType")
@XmlEnum
public enum SocioUnicoType {

	SM,

	SU;

	public static SocioUnicoType fromValue(String v) {
		return valueOf(v);
	}

	public String value() {
		return name();
	}

}

package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "CondizioniPagamentoType")
@XmlEnum
public enum CondizioniPagamentoType {

	@XmlEnumValue("TP01")
	TP_01("TP01"),

	@XmlEnumValue("TP02")
	TP_02("TP02"),

	@XmlEnumValue("TP03")
	TP_03("TP03");
	private final String value;

	CondizioniPagamentoType(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static CondizioniPagamentoType fromValue(String v) {
		for (CondizioniPagamentoType c : CondizioniPagamentoType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}

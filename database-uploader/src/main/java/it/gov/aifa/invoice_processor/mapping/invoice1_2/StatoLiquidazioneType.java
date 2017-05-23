package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "StatoLiquidazioneType")
@XmlEnum
public enum StatoLiquidazioneType {

	LN,

	LS;

	public static StatoLiquidazioneType fromValue(String v) {
		return valueOf(v);
	}

	public String value() {
		return name();
	}

}

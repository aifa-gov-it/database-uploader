//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.16 at 02:40:54 PM UTC 
//

package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "RegimeFiscaleType")
@XmlEnum
public enum RegimeFiscaleType {

	@XmlEnumValue("RF01")
	RF_01("RF01"),

	@XmlEnumValue("RF02")
	RF_02("RF02"),

	@XmlEnumValue("RF03")
	RF_03("RF03"),

	@XmlEnumValue("RF04")
	RF_04("RF04"),

	@XmlEnumValue("RF05")
	RF_05("RF05"),

	@XmlEnumValue("RF06")
	RF_06("RF06"),

	@XmlEnumValue("RF07")
	RF_07("RF07"),

	@XmlEnumValue("RF08")
	RF_08("RF08"),

	@XmlEnumValue("RF09")
	RF_09("RF09"),

	@XmlEnumValue("RF10")
	RF_10("RF10"),

	@XmlEnumValue("RF11")
	RF_11("RF11"),

	@XmlEnumValue("RF12")
	RF_12("RF12"),

	@XmlEnumValue("RF13")
	RF_13("RF13"),

	@XmlEnumValue("RF14")
	RF_14("RF14"),

	@XmlEnumValue("RF15")
	RF_15("RF15"),

	@XmlEnumValue("RF16")
	RF_16("RF16"),

	@XmlEnumValue("RF17")
	RF_17("RF17"),

	@XmlEnumValue("RF18")
	RF_18("RF18"),

	@XmlEnumValue("RF19")
	RF_19("RF19");
	public static RegimeFiscaleType fromValue(String v) {
		for (RegimeFiscaleType c : RegimeFiscaleType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

	private final String value;

	RegimeFiscaleType(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

}

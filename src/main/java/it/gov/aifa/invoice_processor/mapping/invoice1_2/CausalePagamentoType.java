package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "CausalePagamentoType")
@XmlEnum
public enum CausalePagamentoType {

	A("A"), B("B"), C("C"), D("D"), E("E"), G("G"), H("H"), I("I"), L("L"), @XmlEnumValue("L1")
L_1("L1"), M("M"), @XmlEnumValue("M1")
	M_1("M1"), N("N"), O("O"), @XmlEnumValue("O1")
	O_1("O1"), P("P"), Q("Q"), R(
					"R"), S("S"), T("T"), U("U"), V("V"), @XmlEnumValue("V1")
			V_1("V1"), W("W"), X("X"), Y("Y"), Z("Z");
	public static CausalePagamentoType fromValue(String v) {
		for (CausalePagamentoType c : CausalePagamentoType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

	private final String value;

	CausalePagamentoType(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

}

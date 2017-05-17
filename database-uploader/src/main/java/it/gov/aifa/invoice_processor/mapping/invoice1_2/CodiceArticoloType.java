package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CodiceArticoloType", propOrder = { "codiceTipo", "codiceValore" })
public class CodiceArticoloType {

	@XmlElement(name = "CodiceTipo", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String codiceTipo;
	@XmlElement(name = "CodiceValore", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String codiceValore;

	public String getCodiceTipo() {
		return codiceTipo;
	}

	public void setCodiceTipo(String value) {
		this.codiceTipo = value;
	}

	public String getCodiceValore() {
		return codiceValore;
	}

	public void setCodiceValore(String value) {
		this.codiceValore = value;
	}

}

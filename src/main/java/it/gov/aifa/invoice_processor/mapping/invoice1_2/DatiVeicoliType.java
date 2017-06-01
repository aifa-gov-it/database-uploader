package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiVeicoliType", propOrder = { "data", "totalePercorso" })
public class DatiVeicoliType {

	@XmlElement(name = "Data", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar data;

	@XmlElement(name = "TotalePercorso", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String totalePercorso;

	public DatiVeicoliType() {
	}
	public DatiVeicoliType(XMLGregorianCalendar data, String totalePercorso) {
		this.data = data;
		this.totalePercorso = totalePercorso;
	}

	public XMLGregorianCalendar getData() {
		return data;
	}

	public String getTotalePercorso() {
		return totalePercorso;
	}

	public void setData(XMLGregorianCalendar value) {
		this.data = value;
	}

	public void setTotalePercorso(String value) {
		this.totalePercorso = value;
	}

}

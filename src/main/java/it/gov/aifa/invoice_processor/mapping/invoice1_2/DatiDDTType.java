package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiDDTType", propOrder = { "numeroDDT", "dataDDT", "riferimentoNumeroLinea" })
public class DatiDDTType {

	@XmlElement(name = "DataDDT", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dataDDT;

	@XmlElement(name = "NumeroDDT", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String numeroDDT;

	@XmlElement(name = "RiferimentoNumeroLinea", type = Integer.class)
	@XmlSchemaType(name = "integer")
	protected List<Integer> riferimentoNumeroLinea;
	public DatiDDTType() {
	}
	public DatiDDTType(XMLGregorianCalendar dataDDT, String numeroDDT, List<Integer> riferimentoNumeroLinea) {
		this.dataDDT = dataDDT;
		this.numeroDDT = numeroDDT;
		this.riferimentoNumeroLinea = riferimentoNumeroLinea;
	}

	public XMLGregorianCalendar getDataDDT() {
		return dataDDT;
	}

	public String getNumeroDDT() {
		return numeroDDT;
	}

	public List<Integer> getRiferimentoNumeroLinea() {
		if (riferimentoNumeroLinea == null) {
			riferimentoNumeroLinea = new ArrayList<Integer>();
		}
		return this.riferimentoNumeroLinea;
	}

	public void setDataDDT(XMLGregorianCalendar value) {
		this.dataDDT = value;
	}

	public void setNumeroDDT(String value) {
		this.numeroDDT = value;
	}

}

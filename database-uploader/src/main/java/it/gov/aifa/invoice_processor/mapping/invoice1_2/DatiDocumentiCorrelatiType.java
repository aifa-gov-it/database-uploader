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
@XmlType(name = "DatiDocumentiCorrelatiType", propOrder = { "riferimentoNumeroLinea", "idDocumento", "data", "numItem",
		"codiceCommessaConvenzione", "codiceCUP", "codiceCIG" })
public class DatiDocumentiCorrelatiType {

	@XmlElement(name = "RiferimentoNumeroLinea", type = Integer.class)
	@XmlSchemaType(name = "integer")
	protected List<Integer> riferimentoNumeroLinea;
	@XmlElement(name = "IdDocumento", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String idDocumento;
	@XmlElement(name = "Data")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar data;
	@XmlElement(name = "NumItem")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String numItem;
	@XmlElement(name = "CodiceCommessaConvenzione")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String codiceCommessaConvenzione;
	@XmlElement(name = "CodiceCUP")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String codiceCUP;
	@XmlElement(name = "CodiceCIG")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String codiceCIG;

	public List<Integer> getRiferimentoNumeroLinea() {
		if (riferimentoNumeroLinea == null) {
			riferimentoNumeroLinea = new ArrayList<Integer>();
		}
		return this.riferimentoNumeroLinea;
	}

	public String getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(String value) {
		this.idDocumento = value;
	}

	public XMLGregorianCalendar getData() {
		return data;
	}

	public void setData(XMLGregorianCalendar value) {
		this.data = value;
	}

	public String getNumItem() {
		return numItem;
	}

	public void setNumItem(String value) {
		this.numItem = value;
	}

	public String getCodiceCommessaConvenzione() {
		return codiceCommessaConvenzione;
	}

	public void setCodiceCommessaConvenzione(String value) {
		this.codiceCommessaConvenzione = value;
	}

	public String getCodiceCUP() {
		return codiceCUP;
	}

	public void setCodiceCUP(String value) {
		this.codiceCUP = value;
	}

	public String getCodiceCIG() {
		return codiceCIG;
	}

	public void setCodiceCIG(String value) {
		this.codiceCIG = value;
	}

}

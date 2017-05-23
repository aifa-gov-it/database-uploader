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

	@XmlElement(name = "CodiceCIG")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String codiceCIG;

	@XmlElement(name = "CodiceCommessaConvenzione")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String codiceCommessaConvenzione;

	@XmlElement(name = "CodiceCUP")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String codiceCUP;
	@XmlElement(name = "Data")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar data;
	@XmlElement(name = "IdDocumento", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String idDocumento;
	@XmlElement(name = "NumItem")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String numItem;
	@XmlElement(name = "RiferimentoNumeroLinea", type = Integer.class)
	@XmlSchemaType(name = "integer")
	protected List<Integer> riferimentoNumeroLinea;
	public DatiDocumentiCorrelatiType() {
	}
	public DatiDocumentiCorrelatiType(String codiceCIG, String codiceCommessaConvenzione, String codiceCUP,
			XMLGregorianCalendar data, String idDocumento, String numItem, List<Integer> riferimentoNumeroLinea) {
		this.codiceCIG = codiceCIG;
		this.codiceCommessaConvenzione = codiceCommessaConvenzione;
		this.codiceCUP = codiceCUP;
		this.data = data;
		this.idDocumento = idDocumento;
		this.numItem = numItem;
		this.riferimentoNumeroLinea = riferimentoNumeroLinea;
	}

	public String getCodiceCIG() {
		return codiceCIG;
	}

	public String getCodiceCommessaConvenzione() {
		return codiceCommessaConvenzione;
	}

	public String getCodiceCUP() {
		return codiceCUP;
	}

	public XMLGregorianCalendar getData() {
		return data;
	}

	public String getIdDocumento() {
		return idDocumento;
	}

	public String getNumItem() {
		return numItem;
	}

	public List<Integer> getRiferimentoNumeroLinea() {
		if (riferimentoNumeroLinea == null) {
			riferimentoNumeroLinea = new ArrayList<Integer>();
		}
		return this.riferimentoNumeroLinea;
	}

	public void setCodiceCIG(String value) {
		this.codiceCIG = value;
	}

	public void setCodiceCommessaConvenzione(String value) {
		this.codiceCommessaConvenzione = value;
	}

	public void setCodiceCUP(String value) {
		this.codiceCUP = value;
	}

	public void setData(XMLGregorianCalendar value) {
		this.data = value;
	}

	public void setIdDocumento(String value) {
		this.idDocumento = value;
	}

	public void setNumItem(String value) {
		this.numItem = value;
	}

}

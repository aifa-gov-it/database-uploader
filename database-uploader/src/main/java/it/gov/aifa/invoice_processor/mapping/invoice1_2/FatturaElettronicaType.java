package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import it.gov.aifa.invoice_processor.mapping.InvoiceMapping;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FatturaElettronicaType", propOrder = { "fatturaElettronicaHeader", "fatturaElettronicaBody" })
public class FatturaElettronicaType implements InvoiceMapping<String>{
	@XmlElement(name = "FatturaElettronicaBody", required = true)
	protected List<FatturaElettronicaBodyType> fatturaElettronicaBody;
	@XmlElement(name = "FatturaElettronicaHeader", required = true)
	protected FatturaElettronicaHeaderType fatturaElettronicaHeader;
	@XmlAttribute(name = "versione", required = true)
	protected FormatoTrasmissioneType versione;

	public FatturaElettronicaType() {
	}

	public FatturaElettronicaType(List<FatturaElettronicaBodyType> fatturaElettronicaBody,
			FatturaElettronicaHeaderType fatturaElettronicaHeader,
			FormatoTrasmissioneType versione) {
		this.fatturaElettronicaBody = fatturaElettronicaBody;
		this.fatturaElettronicaHeader = fatturaElettronicaHeader;
		this.versione = versione;
	}

	public List<FatturaElettronicaBodyType> getFatturaElettronicaBody() {
		if (fatturaElettronicaBody == null) {
			fatturaElettronicaBody = new ArrayList<FatturaElettronicaBodyType>();
		}
		return this.fatturaElettronicaBody;
	}

	public FatturaElettronicaHeaderType getFatturaElettronicaHeader() {
		return fatturaElettronicaHeader;
	}

	@Override
	public String getId() {
		String id;
		try {
			if(this.getFatturaElettronicaBody().size() > 1)
				throw new RuntimeException("Invoice has more than one body");
			id = this
					.getFatturaElettronicaBody().get(0)
					.getDatiGenerali()
					.getDatiGeneraliDocumento()
					.getNumero();
		} catch (NullPointerException e) {
			id = null;
		}
		return id;
	}
	
	public FormatoTrasmissioneType getVersione() {
		return versione;
	}

	public void setFatturaElettronicaHeader(FatturaElettronicaHeaderType value) {
		this.fatturaElettronicaHeader = value;
	}

	public void setVersione(FormatoTrasmissioneType value) {
		this.versione = value;
	}

}

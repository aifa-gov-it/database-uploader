package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiSALType", propOrder = { "riferimentoFase" })
public class DatiSALType {

	@XmlElement(name = "RiferimentoFase")
	@XmlSchemaType(name = "integer")
	protected int riferimentoFase;

	public DatiSALType() {
	}

	public DatiSALType(int riferimentoFase) {
		this.riferimentoFase = riferimentoFase;
	}

	public int getRiferimentoFase() {
		return riferimentoFase;
	}

	public void setRiferimentoFase(int value) {
		this.riferimentoFase = value;
	}

}

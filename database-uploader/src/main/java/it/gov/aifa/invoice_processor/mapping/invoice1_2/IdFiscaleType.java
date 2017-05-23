package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdFiscaleType", propOrder = { "idPaese", "idCodice" })
public class IdFiscaleType {

	@XmlElement(name = "IdCodice", required = true)
	protected String idCodice;
	@XmlElement(name = "IdPaese", required = true)
	protected String idPaese;

	public IdFiscaleType() {
	}

	public IdFiscaleType(String idCodice, String idPaese) {
		this.idCodice = idCodice;
		this.idPaese = idPaese;
	}

	public String getIdCodice() {
		return idCodice;
	}

	public String getIdPaese() {
		return idPaese;
	}

	public void setIdCodice(String value) {
		this.idCodice = value;
	}

	public void setIdPaese(String value) {
		this.idPaese = value;
	}

}

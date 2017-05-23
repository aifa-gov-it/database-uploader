package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AltriDatiGestionaliType", propOrder = { "tipoDato", "riferimentoTesto", "riferimentoNumero",
		"riferimentoData" })
public class AltriDatiGestionaliType {

	@XmlElement(name = "RiferimentoData")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar riferimentoData;

	@XmlElement(name = "RiferimentoNumero")
	protected BigDecimal riferimentoNumero;

	@XmlElement(name = "RiferimentoTesto")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String riferimentoTesto;
	@XmlElement(name = "TipoDato", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String tipoDato;
	public AltriDatiGestionaliType() {
	}
	public AltriDatiGestionaliType(XMLGregorianCalendar riferimentoData, BigDecimal riferimentoNumero,
			String riferimentoTesto, String tipoDato) {
		this.riferimentoData = riferimentoData;
		this.riferimentoNumero = riferimentoNumero;
		this.riferimentoTesto = riferimentoTesto;
		this.tipoDato = tipoDato;
	}

	public XMLGregorianCalendar getRiferimentoData() {
		return riferimentoData;
	}

	public BigDecimal getRiferimentoNumero() {
		return riferimentoNumero;
	}

	public String getRiferimentoTesto() {
		return riferimentoTesto;
	}

	public String getTipoDato() {
		return tipoDato;
	}

	public void setRiferimentoData(XMLGregorianCalendar value) {
		this.riferimentoData = value;
	}

	public void setRiferimentoNumero(BigDecimal value) {
		this.riferimentoNumero = value;
	}

	public void setRiferimentoTesto(String value) {
		this.riferimentoTesto = value;
	}

	public void setTipoDato(String value) {
		this.tipoDato = value;
	}

}

package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiAnagraficiRappresentanteType", propOrder = { "idFiscaleIVA", "codiceFiscale", "anagrafica" })
public class DatiAnagraficiRappresentanteType {

	@XmlElement(name = "Anagrafica", required = true)
	protected AnagraficaType anagrafica;

	@XmlElement(name = "CodiceFiscale")
	protected String codiceFiscale;

	@XmlElement(name = "IdFiscaleIVA", required = true)
	protected IdFiscaleType idFiscaleIVA;
	public DatiAnagraficiRappresentanteType() {
	}
	public DatiAnagraficiRappresentanteType(AnagraficaType anagrafica, String codiceFiscale,
			IdFiscaleType idFiscaleIVA) {
		this.anagrafica = anagrafica;
		this.codiceFiscale = codiceFiscale;
		this.idFiscaleIVA = idFiscaleIVA;
	}

	public AnagraficaType getAnagrafica() {
		return anagrafica;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public IdFiscaleType getIdFiscaleIVA() {
		return idFiscaleIVA;
	}

	public void setAnagrafica(AnagraficaType value) {
		this.anagrafica = value;
	}

	public void setCodiceFiscale(String value) {
		this.codiceFiscale = value;
	}

	public void setIdFiscaleIVA(IdFiscaleType value) {
		this.idFiscaleIVA = value;
	}

}

package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IscrizioneREAType", propOrder = { "ufficio", "numeroREA", "capitaleSociale", "socioUnico",
		"statoLiquidazione" })
public class IscrizioneREAType {

	@XmlElement(name = "CapitaleSociale")
	protected BigDecimal capitaleSociale;

	@XmlElement(name = "NumeroREA", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String numeroREA;

	@XmlElement(name = "SocioUnico")
	@XmlSchemaType(name = "string")
	protected SocioUnicoType socioUnico;
	@XmlElement(name = "StatoLiquidazione", required = true)
	@XmlSchemaType(name = "string")
	protected StatoLiquidazioneType statoLiquidazione;
	@XmlElement(name = "Ufficio", required = true)
	protected String ufficio;
	public IscrizioneREAType() {
	}
	public IscrizioneREAType(BigDecimal capitaleSociale, String numeroREA, SocioUnicoType socioUnico,
			StatoLiquidazioneType statoLiquidazione, String ufficio) {
		this.capitaleSociale = capitaleSociale;
		this.numeroREA = numeroREA;
		this.socioUnico = socioUnico;
		this.statoLiquidazione = statoLiquidazione;
		this.ufficio = ufficio;
	}

	public BigDecimal getCapitaleSociale() {
		return capitaleSociale;
	}

	public String getNumeroREA() {
		return numeroREA;
	}

	public SocioUnicoType getSocioUnico() {
		return socioUnico;
	}

	public StatoLiquidazioneType getStatoLiquidazione() {
		return statoLiquidazione;
	}

	public String getUfficio() {
		return ufficio;
	}

	public void setCapitaleSociale(BigDecimal value) {
		this.capitaleSociale = value;
	}

	public void setNumeroREA(String value) {
		this.numeroREA = value;
	}

	public void setSocioUnico(SocioUnicoType value) {
		this.socioUnico = value;
	}

	public void setStatoLiquidazione(StatoLiquidazioneType value) {
		this.statoLiquidazione = value;
	}

	public void setUfficio(String value) {
		this.ufficio = value;
	}

}

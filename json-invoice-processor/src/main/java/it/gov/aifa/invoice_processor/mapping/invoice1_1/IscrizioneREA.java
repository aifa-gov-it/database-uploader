
package it.gov.aifa.invoice_processor.mapping.invoice1_1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Ufficio", "NumeroREA", "CapitaleSociale", "SocioUnico", "StatoLiquidazione" })
public class IscrizioneREA implements Serializable {

	@JsonProperty("Ufficio")
	private String ufficio;
	@JsonProperty("NumeroREA")
	private String numeroREA;
	@JsonProperty("CapitaleSociale")
	private String capitaleSociale;
	@JsonProperty("SocioUnico")
	private String socioUnico;
	@JsonProperty("StatoLiquidazione")
	private String statoLiquidazione;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 4350821463523555194L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public IscrizioneREA() {
	}

	/**
	 * 
	 * @param socioUnico
	 * @param statoLiquidazione
	 * @param ufficio
	 * @param capitaleSociale
	 * @param numeroREA
	 */
	public IscrizioneREA(String ufficio, String numeroREA, String capitaleSociale, String socioUnico,
			String statoLiquidazione) {
		super();
		this.ufficio = ufficio;
		this.numeroREA = numeroREA;
		this.capitaleSociale = capitaleSociale;
		this.socioUnico = socioUnico;
		this.statoLiquidazione = statoLiquidazione;
	}

	@JsonProperty("Ufficio")
	public String getUfficio() {
		return ufficio;
	}

	@JsonProperty("Ufficio")
	public void setUfficio(String ufficio) {
		this.ufficio = ufficio;
	}

	@JsonProperty("NumeroREA")
	public String getNumeroREA() {
		return numeroREA;
	}

	@JsonProperty("NumeroREA")
	public void setNumeroREA(String numeroREA) {
		this.numeroREA = numeroREA;
	}

	@JsonProperty("CapitaleSociale")
	public String getCapitaleSociale() {
		return capitaleSociale;
	}

	@JsonProperty("CapitaleSociale")
	public void setCapitaleSociale(String capitaleSociale) {
		this.capitaleSociale = capitaleSociale;
	}

	@JsonProperty("SocioUnico")
	public String getSocioUnico() {
		return socioUnico;
	}

	@JsonProperty("SocioUnico")
	public void setSocioUnico(String socioUnico) {
		this.socioUnico = socioUnico;
	}

	@JsonProperty("StatoLiquidazione")
	public String getStatoLiquidazione() {
		return statoLiquidazione;
	}

	@JsonProperty("StatoLiquidazione")
	public void setStatoLiquidazione(String statoLiquidazione) {
		this.statoLiquidazione = statoLiquidazione;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(ufficio).append(numeroREA).append(capitaleSociale).append(socioUnico)
				.append(statoLiquidazione).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof IscrizioneREA) == false) {
			return false;
		}
		IscrizioneREA rhs = ((IscrizioneREA) other);
		return new EqualsBuilder().append(ufficio, rhs.ufficio).append(numeroREA, rhs.numeroREA)
				.append(capitaleSociale, rhs.capitaleSociale).append(socioUnico, rhs.socioUnico)
				.append(statoLiquidazione, rhs.statoLiquidazione).append(additionalProperties, rhs.additionalProperties)
				.isEquals();
	}

}

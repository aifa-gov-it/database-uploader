
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
@JsonPropertyOrder({ "IdFiscaleIVA", "CodiceFiscale", "Anagrafica", "RegimeFiscale" })
public class DatiAnagrafici implements Serializable {

	@JsonProperty("IdFiscaleIVA")
	@Valid
	private IdFiscaleIVA idFiscaleIVA;
	@JsonProperty("CodiceFiscale")
	private String codiceFiscale;
	@JsonProperty("Anagrafica")
	@Valid
	private Anagrafica anagrafica;
	@JsonProperty("RegimeFiscale")
	private String regimeFiscale;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -320967289236174221L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public DatiAnagrafici() {
	}

	/**
	 * 
	 * @param anagrafica
	 * @param regimeFiscale
	 * @param codiceFiscale
	 * @param idFiscaleIVA
	 */
	public DatiAnagrafici(IdFiscaleIVA idFiscaleIVA, String codiceFiscale, Anagrafica anagrafica,
			String regimeFiscale) {
		super();
		this.idFiscaleIVA = idFiscaleIVA;
		this.codiceFiscale = codiceFiscale;
		this.anagrafica = anagrafica;
		this.regimeFiscale = regimeFiscale;
	}

	@JsonProperty("IdFiscaleIVA")
	public IdFiscaleIVA getIdFiscaleIVA() {
		return idFiscaleIVA;
	}

	@JsonProperty("IdFiscaleIVA")
	public void setIdFiscaleIVA(IdFiscaleIVA idFiscaleIVA) {
		this.idFiscaleIVA = idFiscaleIVA;
	}

	@JsonProperty("CodiceFiscale")
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	@JsonProperty("CodiceFiscale")
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	@JsonProperty("Anagrafica")
	public Anagrafica getAnagrafica() {
		return anagrafica;
	}

	@JsonProperty("Anagrafica")
	public void setAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
	}

	@JsonProperty("RegimeFiscale")
	public String getRegimeFiscale() {
		return regimeFiscale;
	}

	@JsonProperty("RegimeFiscale")
	public void setRegimeFiscale(String regimeFiscale) {
		this.regimeFiscale = regimeFiscale;
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
		return new HashCodeBuilder().append(idFiscaleIVA).append(codiceFiscale).append(anagrafica).append(regimeFiscale)
				.append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof DatiAnagrafici) == false) {
			return false;
		}
		DatiAnagrafici rhs = ((DatiAnagrafici) other);
		return new EqualsBuilder().append(idFiscaleIVA, rhs.idFiscaleIVA).append(codiceFiscale, rhs.codiceFiscale)
				.append(anagrafica, rhs.anagrafica).append(regimeFiscale, rhs.regimeFiscale)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}

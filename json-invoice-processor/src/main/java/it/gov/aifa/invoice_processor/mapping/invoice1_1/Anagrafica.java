
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
@JsonPropertyOrder({ "Denominazione" })
public class Anagrafica implements Serializable {

	@JsonProperty("Denominazione")
	private String denominazione;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 217794525618922642L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Anagrafica() {
	}

	/**
	 * 
	 * @param denominazione
	 */
	public Anagrafica(String denominazione) {
		super();
		this.denominazione = denominazione;
	}

	@JsonProperty("Denominazione")
	public String getDenominazione() {
		return denominazione;
	}

	@JsonProperty("Denominazione")
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
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
		return new HashCodeBuilder().append(denominazione).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Anagrafica) == false) {
			return false;
		}
		Anagrafica rhs = ((Anagrafica) other);
		return new EqualsBuilder().append(denominazione, rhs.denominazione)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}


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
@JsonPropertyOrder({ "Telefono" })
public class Contatti implements Serializable {

	@JsonProperty("Telefono")
	private String telefono;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 8690514561638339377L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Contatti() {
	}

	/**
	 * 
	 * @param telefono
	 */
	public Contatti(String telefono) {
		super();
		this.telefono = telefono;
	}

	@JsonProperty("Telefono")
	public String getTelefono() {
		return telefono;
	}

	@JsonProperty("Telefono")
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
		return new HashCodeBuilder().append(telefono).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Contatti) == false) {
			return false;
		}
		Contatti rhs = ((Contatti) other);
		return new EqualsBuilder().append(telefono, rhs.telefono).append(additionalProperties, rhs.additionalProperties)
				.isEquals();
	}

}

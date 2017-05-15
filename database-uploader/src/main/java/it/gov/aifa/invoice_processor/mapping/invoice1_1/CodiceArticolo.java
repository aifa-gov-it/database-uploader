
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
@JsonPropertyOrder({ "CodiceTipo", "CodiceValore" })
public class CodiceArticolo implements Serializable {

	@JsonProperty("CodiceTipo")
	private String codiceTipo;
	@JsonProperty("CodiceValore")
	private String codiceValore;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 7159056622265352853L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public CodiceArticolo() {
	}

	/**
	 * 
	 * @param codiceTipo
	 * @param codiceValore
	 */
	public CodiceArticolo(String codiceTipo, String codiceValore) {
		super();
		this.codiceTipo = codiceTipo;
		this.codiceValore = codiceValore;
	}

	@JsonProperty("CodiceTipo")
	public String getCodiceTipo() {
		return codiceTipo;
	}

	@JsonProperty("CodiceTipo")
	public void setCodiceTipo(String codiceTipo) {
		this.codiceTipo = codiceTipo;
	}

	@JsonProperty("CodiceValore")
	public String getCodiceValore() {
		return codiceValore;
	}

	@JsonProperty("CodiceValore")
	public void setCodiceValore(String codiceValore) {
		this.codiceValore = codiceValore;
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
		return new HashCodeBuilder().append(codiceTipo).append(codiceValore).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof CodiceArticolo) == false) {
			return false;
		}
		CodiceArticolo rhs = ((CodiceArticolo) other);
		return new EqualsBuilder().append(codiceTipo, rhs.codiceTipo).append(codiceValore, rhs.codiceValore)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}

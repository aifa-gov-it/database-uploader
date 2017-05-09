package it.gov.aifa.invoice_processor.mapping.invoice1_1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "BolloVirtuale", "ImportoBollo" })
public class DatiBollo implements Serializable {

	private static final long serialVersionUID = 7587921106490674011L;

	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("BolloVirtuale")
	private String bolloVirtuale;

	@JsonProperty("ImportoBollo")
	private String importoBollo;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public DatiBollo() {
	}

	/**
	 * 
	 * @param bolloVirtuale
	 * @param importoBollo
	 */
	public DatiBollo(String bolloVirtuale, String importoBollo) {
		this.bolloVirtuale = bolloVirtuale;
		this.importoBollo = importoBollo;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof DatiBollo) == false) {
			return false;
		}
		DatiBollo rhs = ((DatiBollo) other);
		return new EqualsBuilder().append(bolloVirtuale, rhs.bolloVirtuale).append(importoBollo, rhs.importoBollo)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public String getBolloVirtuale() {
		return bolloVirtuale;
	}

	public String getImportoBollo() {
		return importoBollo;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(bolloVirtuale).append(importoBollo).append(additionalProperties)
				.toHashCode();
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public void setBolloVirtuale(String bolloVirtuale) {
		this.bolloVirtuale = bolloVirtuale;
	}

	public void setImportoBollo(String importoBollo) {
		this.importoBollo = importoBollo;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

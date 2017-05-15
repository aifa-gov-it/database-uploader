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
@JsonPropertyOrder({ "Tipo", "Importo" })
public class ScontoMaggiorazione implements Serializable{
	
	private static final long serialVersionUID = -3124435351861203627L;

	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	@JsonProperty("Importo")
	private String importo;
	
	@JsonProperty("Tipo")
	private String tipo;
	
	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public ScontoMaggiorazione() {
	}
	/**
	 * 
	 * @param tipo
	 * @param importo
	 */
	public ScontoMaggiorazione(String tipo, String importo) {
		this.tipo = tipo;
		this.importo = importo;
	}
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof ScontoMaggiorazione) == false) {
			return false;
		}
		ScontoMaggiorazione rhs = ((ScontoMaggiorazione) other);
		return new EqualsBuilder().append(tipo, rhs.tipo).append(importo, rhs.importo)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}
	
	public String getImporto() {
		return importo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(tipo).append(importo).append(additionalProperties).toHashCode();
	}
	
	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
	
	public void setImporto(String importo) {
		this.importo = importo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

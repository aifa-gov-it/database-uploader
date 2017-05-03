
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
@JsonPropertyOrder({ "CondizioniPagamento", "DettaglioPagamento" })
public class DatiPagamento implements Serializable {

	@JsonProperty("CondizioniPagamento")
	private String condizioniPagamento;
	@JsonProperty("DettaglioPagamento")
	@Valid
	private DettaglioPagamento dettaglioPagamento;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 4423954170645197421L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public DatiPagamento() {
	}

	/**
	 * 
	 * @param dettaglioPagamento
	 * @param condizioniPagamento
	 */
	public DatiPagamento(String condizioniPagamento, DettaglioPagamento dettaglioPagamento) {
		super();
		this.condizioniPagamento = condizioniPagamento;
		this.dettaglioPagamento = dettaglioPagamento;
	}

	@JsonProperty("CondizioniPagamento")
	public String getCondizioniPagamento() {
		return condizioniPagamento;
	}

	@JsonProperty("CondizioniPagamento")
	public void setCondizioniPagamento(String condizioniPagamento) {
		this.condizioniPagamento = condizioniPagamento;
	}

	@JsonProperty("DettaglioPagamento")
	public DettaglioPagamento getDettaglioPagamento() {
		return dettaglioPagamento;
	}

	@JsonProperty("DettaglioPagamento")
	public void setDettaglioPagamento(DettaglioPagamento dettaglioPagamento) {
		this.dettaglioPagamento = dettaglioPagamento;
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
		return new HashCodeBuilder().append(condizioniPagamento).append(dettaglioPagamento).append(additionalProperties)
				.toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof DatiPagamento) == false) {
			return false;
		}
		DatiPagamento rhs = ((DatiPagamento) other);
		return new EqualsBuilder().append(condizioniPagamento, rhs.condizioniPagamento)
				.append(dettaglioPagamento, rhs.dettaglioPagamento)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}

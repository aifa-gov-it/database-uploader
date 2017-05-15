
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
@JsonPropertyOrder({ "DatiGenerali", "DatiBeniServizi", "DatiPagamento" })
public class FatturaElettronicaBody implements Serializable {

	@JsonProperty("DatiGenerali")
	@Valid
	private DatiGenerali datiGenerali;
	@JsonProperty("DatiBeniServizi")
	@Valid
	private DatiBeniServizi datiBeniServizi;
	@JsonProperty("DatiPagamento")
	@Valid
	private DatiPagamento datiPagamento;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -8404751969585509053L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public FatturaElettronicaBody() {
	}

	/**
	 * 
	 * @param datiGenerali
	 * @param datiPagamento
	 * @param datiBeniServizi
	 */
	public FatturaElettronicaBody(DatiGenerali datiGenerali, DatiBeniServizi datiBeniServizi,
			DatiPagamento datiPagamento) {
		super();
		this.datiGenerali = datiGenerali;
		this.datiBeniServizi = datiBeniServizi;
		this.datiPagamento = datiPagamento;
	}

	@JsonProperty("DatiGenerali")
	public DatiGenerali getDatiGenerali() {
		return datiGenerali;
	}

	@JsonProperty("DatiGenerali")
	public void setDatiGenerali(DatiGenerali datiGenerali) {
		this.datiGenerali = datiGenerali;
	}

	@JsonProperty("DatiBeniServizi")
	public DatiBeniServizi getDatiBeniServizi() {
		return datiBeniServizi;
	}

	@JsonProperty("DatiBeniServizi")
	public void setDatiBeniServizi(DatiBeniServizi datiBeniServizi) {
		this.datiBeniServizi = datiBeniServizi;
	}

	@JsonProperty("DatiPagamento")
	public DatiPagamento getDatiPagamento() {
		return datiPagamento;
	}

	@JsonProperty("DatiPagamento")
	public void setDatiPagamento(DatiPagamento datiPagamento) {
		this.datiPagamento = datiPagamento;
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
		return new HashCodeBuilder().append(datiGenerali).append(datiBeniServizi).append(datiPagamento)
				.append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof FatturaElettronicaBody) == false) {
			return false;
		}
		FatturaElettronicaBody rhs = ((FatturaElettronicaBody) other);
		return new EqualsBuilder().append(datiGenerali, rhs.datiGenerali).append(datiBeniServizi, rhs.datiBeniServizi)
				.append(datiPagamento, rhs.datiPagamento).append(additionalProperties, rhs.additionalProperties)
				.isEquals();
	}

}

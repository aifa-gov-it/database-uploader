
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
@JsonPropertyOrder({ "DatiAnagrafici" })
public class TerzoIntermediarioOSoggettoEmittente implements Serializable {

	@JsonProperty("DatiAnagrafici")
	@Valid
	private DatiAnagrafici datiAnagrafici;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -865964892653361806L;

	public TerzoIntermediarioOSoggettoEmittente() {
	}

	public TerzoIntermediarioOSoggettoEmittente(DatiAnagrafici datiAnagrafici) {
		super();
		this.datiAnagrafici = datiAnagrafici;
	}

	@JsonProperty("DatiAnagrafici")
	public DatiAnagrafici getDatiAnagrafici() {
		return datiAnagrafici;
	}

	@JsonProperty("DatiAnagrafici")
	public void setDatiAnagrafici(DatiAnagrafici datiAnagrafici) {
		this.datiAnagrafici = datiAnagrafici;
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
		return new HashCodeBuilder().append(datiAnagrafici).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof TerzoIntermediarioOSoggettoEmittente) == false) {
			return false;
		}
		TerzoIntermediarioOSoggettoEmittente rhs = ((TerzoIntermediarioOSoggettoEmittente) other);
		return new EqualsBuilder().append(datiAnagrafici, rhs.datiAnagrafici)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}

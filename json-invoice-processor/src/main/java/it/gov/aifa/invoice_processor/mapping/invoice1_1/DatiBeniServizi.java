
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
@JsonPropertyOrder({ "DettaglioLinee", "DatiRiepilogo" })
public class DatiBeniServizi implements Serializable {

	@JsonProperty("DettaglioLinee")
	@Valid
	private DettaglioLinee dettaglioLinee;
	@JsonProperty("DatiRiepilogo")
	@Valid
	private DatiRiepilogo datiRiepilogo;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -7585068687936918402L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public DatiBeniServizi() {
	}

	/**
	 * 
	 * @param datiRiepilogo
	 * @param dettaglioLinee
	 */
	public DatiBeniServizi(DettaglioLinee dettaglioLinee, DatiRiepilogo datiRiepilogo) {
		super();
		this.dettaglioLinee = dettaglioLinee;
		this.datiRiepilogo = datiRiepilogo;
	}

	@JsonProperty("DettaglioLinee")
	public DettaglioLinee getDettaglioLinee() {
		return dettaglioLinee;
	}

	@JsonProperty("DettaglioLinee")
	public void setDettaglioLinee(DettaglioLinee dettaglioLinee) {
		this.dettaglioLinee = dettaglioLinee;
	}

	@JsonProperty("DatiRiepilogo")
	public DatiRiepilogo getDatiRiepilogo() {
		return datiRiepilogo;
	}

	@JsonProperty("DatiRiepilogo")
	public void setDatiRiepilogo(DatiRiepilogo datiRiepilogo) {
		this.datiRiepilogo = datiRiepilogo;
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
		return new HashCodeBuilder().append(dettaglioLinee).append(datiRiepilogo).append(additionalProperties)
				.toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof DatiBeniServizi) == false) {
			return false;
		}
		DatiBeniServizi rhs = ((DatiBeniServizi) other);
		return new EqualsBuilder().append(dettaglioLinee, rhs.dettaglioLinee).append(datiRiepilogo, rhs.datiRiepilogo)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}


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
@JsonPropertyOrder({ "Indirizzo", "cap", "Comune", "Provincia", "Nazione" })
public class Sede implements Serializable {

	@JsonProperty("Indirizzo")
	private String indirizzo;
	@JsonProperty("CAP")
	private String cap;
	@JsonProperty("Comune")
	private String comune;
	@JsonProperty("Provincia")
	private String provincia;
	@JsonProperty("Nazione")
	private String nazione;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -1683080394837067438L;

	public Sede() {
	}

	public Sede(String indirizzo, String cap, String comune, String provincia, String nazione) {
		super();
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.comune = comune;
		this.provincia = provincia;
		this.nazione = nazione;
	}

	@JsonProperty("Indirizzo")
	public String getIndirizzo() {
		return indirizzo;
	}

	@JsonProperty("Indirizzo")
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	@JsonProperty("cap")
	public String getCap() {
		return cap;
	}

	@JsonProperty("cap")
	public void setCap(String cap) {
		this.cap = cap;
	}

	@JsonProperty("Comune")
	public String getComune() {
		return comune;
	}

	@JsonProperty("Comune")
	public void setComune(String comune) {
		this.comune = comune;
	}

	@JsonProperty("Provincia")
	public String getProvincia() {
		return provincia;
	}

	@JsonProperty("Provincia")
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@JsonProperty("Nazione")
	public String getNazione() {
		return nazione;
	}

	@JsonProperty("Nazione")
	public void setNazione(String nazione) {
		this.nazione = nazione;
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
		return new HashCodeBuilder().append(indirizzo).append(cap).append(comune).append(provincia).append(nazione)
				.append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Sede) == false) {
			return false;
		}
		Sede rhs = ((Sede) other);
		return new EqualsBuilder().append(indirizzo, rhs.indirizzo).append(cap, rhs.cap).append(comune, rhs.comune)
				.append(provincia, rhs.provincia).append(nazione, rhs.nazione)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}

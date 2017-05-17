
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
@JsonPropertyOrder({ "@versione", "FatturaElettronicaHeader", "FatturaElettronicaBody" })
public class HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica implements Serializable {
	@JsonProperty("@versione")
	private String versione;
	@JsonProperty("FatturaElettronicaHeader")
	@Valid
	private FatturaElettronicaHeader fatturaElettronicaHeader;
	@JsonProperty("FatturaElettronicaBody")
	@Valid
	private FatturaElettronicaBody fatturaElettronicaBody;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 6121622310721955350L;

	public HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica() {
	}

	public HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica(String versione,
			FatturaElettronicaHeader fatturaElettronicaHeader, FatturaElettronicaBody fatturaElettronicaBody) {
		super();
		this.versione = versione;
		this.fatturaElettronicaHeader = fatturaElettronicaHeader;
		this.fatturaElettronicaBody = fatturaElettronicaBody;
	}

	@JsonProperty("@versione")
	public String getVersione() {
		return versione;
	}

	@JsonProperty("@versione")
	public void setVersione(String versione) {
		this.versione = versione;
	}

	@JsonProperty("FatturaElettronicaHeader")
	public FatturaElettronicaHeader getFatturaElettronicaHeader() {
		return fatturaElettronicaHeader;
	}

	@JsonProperty("FatturaElettronicaHeader")
	public void setFatturaElettronicaHeader(FatturaElettronicaHeader fatturaElettronicaHeader) {
		this.fatturaElettronicaHeader = fatturaElettronicaHeader;
	}

	@JsonProperty("FatturaElettronicaBody")
	public FatturaElettronicaBody getFatturaElettronicaBody() {
		return fatturaElettronicaBody;
	}

	@JsonProperty("FatturaElettronicaBody")
	public void setFatturaElettronicaBody(FatturaElettronicaBody fatturaElettronicaBody) {
		this.fatturaElettronicaBody = fatturaElettronicaBody;
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
		return new HashCodeBuilder().append(versione).append(fatturaElettronicaHeader).append(fatturaElettronicaBody)
				.append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica) == false) {
			return false;
		}
		HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica rhs = ((HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica) other);
		return new EqualsBuilder().append(versione, rhs.versione)
				.append(fatturaElettronicaHeader, rhs.fatturaElettronicaHeader)
				.append(fatturaElettronicaBody, rhs.fatturaElettronicaBody)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}

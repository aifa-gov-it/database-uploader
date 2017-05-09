
package it.gov.aifa.invoice_processor.mapping.invoice1_1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Transient;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import it.gov.aifa.invoice_processor.mapping.Invoice;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "{http://www.fatturapa.gov.it/sdi/fatturapa/v1.1}FatturaElettronica" })
public class Invoice1_1 implements Invoice<String>, Serializable {

	@JsonProperty("{http://www.fatturapa.gov.it/sdi/fatturapa/v1.1}FatturaElettronica")
	@Valid
	private HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica httpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -2484260940952002057L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Invoice1_1() {
	}

	/**
	 * 
	 * @param httpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica
	 */
	public Invoice1_1(
			HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica httpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica) {
		super();
		this.httpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica = httpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica;
	}

	@JsonProperty("{http://www.fatturapa.gov.it/sdi/fatturapa/v1.1}FatturaElettronica")
	public HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica getHttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica() {
		return httpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica;
	}

	@JsonProperty("{http://www.fatturapa.gov.it/sdi/fatturapa/v1.1}FatturaElettronica")
	public void setHttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica(
			HttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica httpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica) {
		this.httpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica = httpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica;
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
		return new HashCodeBuilder().append(httpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica)
				.append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Invoice1_1) == false) {
			return false;
		}
		Invoice1_1 rhs = ((Invoice1_1) other);
		return new EqualsBuilder()
				.append(httpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica,
						rhs.httpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}
	
	@JsonIgnore
	@Override
	@Transient
	public String getId() {
		String id;
		try {
			id = this.getHttpWwwFatturapaGovItSdiFatturapaV11FatturaElettronica()
					.getFatturaElettronicaBody()
					.getDatiGenerali()
					.getDatiGeneraliDocumento()
					.getNumero();
		} catch (NullPointerException e) {
			id = null;
		}
		return id;
	}

}

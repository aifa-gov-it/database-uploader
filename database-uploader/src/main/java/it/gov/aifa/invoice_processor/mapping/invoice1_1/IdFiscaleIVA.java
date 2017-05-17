
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
@JsonPropertyOrder({ "IdPaese", "IdCodice" })
public class IdFiscaleIVA implements Serializable {

	@JsonProperty("IdPaese")
	private String idPaese;
	@JsonProperty("IdCodice")
	private String idCodice;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 3830463942248346268L;

	public IdFiscaleIVA() {
	}

	public IdFiscaleIVA(String idPaese, String idCodice) {
		super();
		this.idPaese = idPaese;
		this.idCodice = idCodice;
	}

	@JsonProperty("IdPaese")
	public String getIdPaese() {
		return idPaese;
	}

	@JsonProperty("IdPaese")
	public void setIdPaese(String idPaese) {
		this.idPaese = idPaese;
	}

	@JsonProperty("IdCodice")
	public String getIdCodice() {
		return idCodice;
	}

	@JsonProperty("IdCodice")
	public void setIdCodice(String idCodice) {
		this.idCodice = idCodice;
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
		return new HashCodeBuilder().append(idPaese).append(idCodice).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof IdFiscaleIVA) == false) {
			return false;
		}
		IdFiscaleIVA rhs = ((IdFiscaleIVA) other);
		return new EqualsBuilder().append(idPaese, rhs.idPaese).append(idCodice, rhs.idCodice)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}

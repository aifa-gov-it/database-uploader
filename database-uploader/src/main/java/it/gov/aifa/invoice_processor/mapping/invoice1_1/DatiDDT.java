
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
@JsonPropertyOrder({ "NumeroDDT", "DataDDT" })
public class DatiDDT implements Serializable {

	@JsonProperty("NumeroDDT")
	private String numeroDDT;
	@JsonProperty("DataDDT")
	private String dataDDT;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -2273787351185913261L;

	public DatiDDT() {
	}

	public DatiDDT(String numeroDDT, String dataDDT) {
		super();
		this.numeroDDT = numeroDDT;
		this.dataDDT = dataDDT;
	}

	@JsonProperty("NumeroDDT")
	public String getNumeroDDT() {
		return numeroDDT;
	}

	@JsonProperty("NumeroDDT")
	public void setNumeroDDT(String numeroDDT) {
		this.numeroDDT = numeroDDT;
	}

	@JsonProperty("DataDDT")
	public String getDataDDT() {
		return dataDDT;
	}

	@JsonProperty("DataDDT")
	public void setDataDDT(String dataDDT) {
		this.dataDDT = dataDDT;
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
		return new HashCodeBuilder().append(numeroDDT).append(dataDDT).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof DatiDDT) == false) {
			return false;
		}
		DatiDDT rhs = ((DatiDDT) other);
		return new EqualsBuilder().append(numeroDDT, rhs.numeroDDT).append(dataDDT, rhs.dataDDT)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}

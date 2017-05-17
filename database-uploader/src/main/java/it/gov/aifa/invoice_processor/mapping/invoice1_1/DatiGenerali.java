
package it.gov.aifa.invoice_processor.mapping.invoice1_1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
@JsonPropertyOrder({ "DatiGeneraliDocumento", "DatiOrdineAcquisto", "DatiFattureCollegate", "DatiDDT" })
public class DatiGenerali implements Serializable {

	@JsonProperty("DatiGeneraliDocumento")
	@Valid
	private DatiGeneraliDocumento datiGeneraliDocumento;
	@JsonProperty("DatiOrdineAcquisto")
	@Valid
	private List<DatiOrdineAcquisto> datiOrdineAcquisto = null;
	@JsonProperty("DatiFattureCollegate")
	@Valid
	private List<DatiFattureCollegate> datiFattureCollegate = null;
	@JsonProperty("DatiDDT")
	@Valid
	private DatiDDT datiDDT;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -4879949795987171126L;

	public DatiGenerali() {
	}

	public DatiGenerali(DatiGeneraliDocumento datiGeneraliDocumento, List<DatiOrdineAcquisto> datiOrdineAcquisto,
			List<DatiFattureCollegate> datiFattureCollegate, DatiDDT datiDDT) {
		super();
		this.datiGeneraliDocumento = datiGeneraliDocumento;
		this.datiOrdineAcquisto = datiOrdineAcquisto;
		this.datiFattureCollegate = datiFattureCollegate;
		this.datiDDT = datiDDT;
	}

	@JsonProperty("DatiGeneraliDocumento")
	public DatiGeneraliDocumento getDatiGeneraliDocumento() {
		return datiGeneraliDocumento;
	}

	@JsonProperty("DatiGeneraliDocumento")
	public void setDatiGeneraliDocumento(DatiGeneraliDocumento datiGeneraliDocumento) {
		this.datiGeneraliDocumento = datiGeneraliDocumento;
	}

	@JsonProperty("DatiOrdineAcquisto")
	public List<DatiOrdineAcquisto> getDatiOrdineAcquisto() {
		return datiOrdineAcquisto;
	}

	@JsonProperty("DatiOrdineAcquisto")
	public void setDatiOrdineAcquisto(List<DatiOrdineAcquisto> datiOrdineAcquisto) {
		this.datiOrdineAcquisto = datiOrdineAcquisto;
	}

	@JsonProperty("DatiFattureCollegate")
	public List<DatiFattureCollegate> getDatiFattureCollegate() {
		return datiFattureCollegate;
	}

	@JsonProperty("DatiFattureCollegate")
	public void setDatiFattureCollegate(List<DatiFattureCollegate> datiFattureCollegate) {
		this.datiFattureCollegate = datiFattureCollegate;
	}

	@JsonProperty("DatiDDT")
	public DatiDDT getDatiDDT() {
		return datiDDT;
	}

	@JsonProperty("DatiDDT")
	public void setDatiDDT(DatiDDT datiDDT) {
		this.datiDDT = datiDDT;
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
		return new HashCodeBuilder().append(datiGeneraliDocumento).append(datiOrdineAcquisto)
				.append(datiFattureCollegate).append(datiDDT).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof DatiGenerali) == false) {
			return false;
		}
		DatiGenerali rhs = ((DatiGenerali) other);
		return new EqualsBuilder().append(datiGeneraliDocumento, rhs.datiGeneraliDocumento)
				.append(datiOrdineAcquisto, rhs.datiOrdineAcquisto)
				.append(datiFattureCollegate, rhs.datiFattureCollegate).append(datiDDT, rhs.datiDDT)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}

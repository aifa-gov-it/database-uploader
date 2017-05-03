
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
@JsonPropertyOrder({ "TipoDocumento", "Divisa", "Data", "Numero", "ImportoTotaleDocumento", "Causale" })
public class DatiGeneraliDocumento implements Serializable {

	@JsonProperty("TipoDocumento")
	private String tipoDocumento;
	@JsonProperty("Divisa")
	private String divisa;
	@JsonProperty("Data")
	private String data;
	@JsonProperty("Numero")
	private String numero;
	@JsonProperty("ImportoTotaleDocumento")
	private String importoTotaleDocumento;
	@JsonProperty("Causale")
	@Valid
	private List<String> causale = null;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 9015129899413377938L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public DatiGeneraliDocumento() {
	}

	/**
	 * 
	 * @param divisa
	 * @param data
	 * @param tipoDocumento
	 * @param importoTotaleDocumento
	 * @param causale
	 * @param numero
	 */
	public DatiGeneraliDocumento(String tipoDocumento, String divisa, String data, String numero,
			String importoTotaleDocumento, List<String> causale) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.divisa = divisa;
		this.data = data;
		this.numero = numero;
		this.importoTotaleDocumento = importoTotaleDocumento;
		this.causale = causale;
	}

	@JsonProperty("TipoDocumento")
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	@JsonProperty("TipoDocumento")
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@JsonProperty("Divisa")
	public String getDivisa() {
		return divisa;
	}

	@JsonProperty("Divisa")
	public void setDivisa(String divisa) {
		this.divisa = divisa;
	}

	@JsonProperty("Data")
	public String getData() {
		return data;
	}

	@JsonProperty("Data")
	public void setData(String data) {
		this.data = data;
	}

	@JsonProperty("Numero")
	public String getNumero() {
		return numero;
	}

	@JsonProperty("Numero")
	public void setNumero(String numero) {
		this.numero = numero;
	}

	@JsonProperty("ImportoTotaleDocumento")
	public String getImportoTotaleDocumento() {
		return importoTotaleDocumento;
	}

	@JsonProperty("ImportoTotaleDocumento")
	public void setImportoTotaleDocumento(String importoTotaleDocumento) {
		this.importoTotaleDocumento = importoTotaleDocumento;
	}

	@JsonProperty("Causale")
	public List<String> getCausale() {
		return causale;
	}

	@JsonProperty("Causale")
	public void setCausale(List<String> causale) {
		this.causale = causale;
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
		return new HashCodeBuilder().append(tipoDocumento).append(divisa).append(data).append(numero)
				.append(importoTotaleDocumento).append(causale).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof DatiGeneraliDocumento) == false) {
			return false;
		}
		DatiGeneraliDocumento rhs = ((DatiGeneraliDocumento) other);
		return new EqualsBuilder().append(tipoDocumento, rhs.tipoDocumento).append(divisa, rhs.divisa)
				.append(data, rhs.data).append(numero, rhs.numero)
				.append(importoTotaleDocumento, rhs.importoTotaleDocumento).append(causale, rhs.causale)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}

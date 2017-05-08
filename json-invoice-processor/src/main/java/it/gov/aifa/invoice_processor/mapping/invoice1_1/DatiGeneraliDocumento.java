
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
@JsonPropertyOrder({ "TipoDocumento", "Divisa", "Data", "Numero", "ImportoTotaleDocumento", "ScontoMaggiorazione", "Causale" })
public class DatiGeneraliDocumento implements Serializable {

	private final static long serialVersionUID = 9015129899413377938L;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	@JsonProperty("Causale")
	@Valid
	private List<String> causale = null;
	@JsonProperty("Data")
	private String data;
	@JsonProperty("Divisa")
	private String divisa;
	@JsonProperty("ImportoTotaleDocumento")
	private String importoTotaleDocumento;
	@JsonProperty("Numero")
	private String numero;
	@JsonProperty("ScontoMaggiorazione")
	private ScontoMaggiorazione scontoMaggiorazione;
	@JsonProperty("TipoDocumento")
	private String tipoDocumento;

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
			String importoTotaleDocumento, ScontoMaggiorazione scontoMaggiorazione, List<String> causale) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.divisa = divisa;
		this.data = data;
		this.numero = numero;
		this.importoTotaleDocumento = importoTotaleDocumento;
		this.scontoMaggiorazione = scontoMaggiorazione;
		this.causale = causale;
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
				.append(importoTotaleDocumento, rhs.importoTotaleDocumento).append(scontoMaggiorazione, rhs.scontoMaggiorazione)
				.append(causale, rhs.causale)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonProperty("Causale")
	public List<String> getCausale() {
		return causale;
	}

	@JsonProperty("Data")
	public String getData() {
		return data;
	}

	@JsonProperty("Divisa")
	public String getDivisa() {
		return divisa;
	}

	@JsonProperty("ImportoTotaleDocumento")
	public String getImportoTotaleDocumento() {
		return importoTotaleDocumento;
	}

	@JsonProperty("Numero")
	public String getNumero() {
		return numero;
	}

	public ScontoMaggiorazione getScontoMaggiorazione() {
		return scontoMaggiorazione;
	}

	@JsonProperty("TipoDocumento")
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(tipoDocumento).append(divisa).append(data).append(numero)
				.append(importoTotaleDocumento).append(scontoMaggiorazione).append(causale).append(additionalProperties).toHashCode();
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@JsonProperty("Causale")
	public void setCausale(List<String> causale) {
		this.causale = causale;
	}

	@JsonProperty("Data")
	public void setData(String data) {
		this.data = data;
	}

	@JsonProperty("Divisa")
	public void setDivisa(String divisa) {
		this.divisa = divisa;
	}

	@JsonProperty("ImportoTotaleDocumento")
	public void setImportoTotaleDocumento(String importoTotaleDocumento) {
		this.importoTotaleDocumento = importoTotaleDocumento;
	}

	@JsonProperty("Numero")
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setScontoMaggiorazione(ScontoMaggiorazione scontoMaggiorazione) {
		this.scontoMaggiorazione = scontoMaggiorazione;
	}

	@JsonProperty("TipoDocumento")
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}


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
@JsonPropertyOrder({ "ModalitaPagamento", "GiorniTerminiPagamento", "DataScadenzaPagamento", "ImportoPagamento",
		"IstitutoFinanziario", "IBAN", "ABI", "CAB", "BIC" })
public class DettaglioPagamento implements Serializable {

	@JsonProperty("ModalitaPagamento")
	private String modalitaPagamento;
	@JsonProperty("GiorniTerminiPagamento")
	private String giorniTerminiPagamento;
	@JsonProperty("DataScadenzaPagamento")
	private String dataScadenzaPagamento;
	@JsonProperty("ImportoPagamento")
	private String importoPagamento;
	@JsonProperty("IstitutoFinanziario")
	private String istitutoFinanziario;
	@JsonProperty("IBAN")
	private String iBAN;
	@JsonProperty("ABI")
	private String aBI;
	@JsonProperty("CAB")
	private String cAB;
	@JsonProperty("BIC")
	private String bIC;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 1217256037016190488L;

	public DettaglioPagamento() {
	}

	public DettaglioPagamento(String modalitaPagamento, String giorniTerminiPagamento, String dataScadenzaPagamento,
			String importoPagamento, String istitutoFinanziario, String iBAN, String aBI, String cAB, String bIC) {
		super();
		this.modalitaPagamento = modalitaPagamento;
		this.giorniTerminiPagamento = giorniTerminiPagamento;
		this.dataScadenzaPagamento = dataScadenzaPagamento;
		this.importoPagamento = importoPagamento;
		this.istitutoFinanziario = istitutoFinanziario;
		this.iBAN = iBAN;
		this.aBI = aBI;
		this.cAB = cAB;
		this.bIC = bIC;
	}

	@JsonProperty("ModalitaPagamento")
	public String getModalitaPagamento() {
		return modalitaPagamento;
	}

	@JsonProperty("ModalitaPagamento")
	public void setModalitaPagamento(String modalitaPagamento) {
		this.modalitaPagamento = modalitaPagamento;
	}

	@JsonProperty("GiorniTerminiPagamento")
	public String getGiorniTerminiPagamento() {
		return giorniTerminiPagamento;
	}

	@JsonProperty("GiorniTerminiPagamento")
	public void setGiorniTerminiPagamento(String giorniTerminiPagamento) {
		this.giorniTerminiPagamento = giorniTerminiPagamento;
	}

	@JsonProperty("DataScadenzaPagamento")
	public String getDataScadenzaPagamento() {
		return dataScadenzaPagamento;
	}

	@JsonProperty("DataScadenzaPagamento")
	public void setDataScadenzaPagamento(String dataScadenzaPagamento) {
		this.dataScadenzaPagamento = dataScadenzaPagamento;
	}

	@JsonProperty("ImportoPagamento")
	public String getImportoPagamento() {
		return importoPagamento;
	}

	@JsonProperty("ImportoPagamento")
	public void setImportoPagamento(String importoPagamento) {
		this.importoPagamento = importoPagamento;
	}

	@JsonProperty("IstitutoFinanziario")
	public String getIstitutoFinanziario() {
		return istitutoFinanziario;
	}

	@JsonProperty("IstitutoFinanziario")
	public void setIstitutoFinanziario(String istitutoFinanziario) {
		this.istitutoFinanziario = istitutoFinanziario;
	}

	@JsonProperty("IBAN")
	public String getIBAN() {
		return iBAN;
	}

	@JsonProperty("IBAN")
	public void setIBAN(String iBAN) {
		this.iBAN = iBAN;
	}

	@JsonProperty("ABI")
	public String getABI() {
		return aBI;
	}

	@JsonProperty("ABI")
	public void setABI(String aBI) {
		this.aBI = aBI;
	}

	@JsonProperty("CAB")
	public String getCAB() {
		return cAB;
	}

	@JsonProperty("CAB")
	public void setCAB(String cAB) {
		this.cAB = cAB;
	}

	@JsonProperty("BIC")
	public String getBIC() {
		return bIC;
	}

	@JsonProperty("BIC")
	public void setBIC(String bIC) {
		this.bIC = bIC;
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
		return new HashCodeBuilder().append(modalitaPagamento).append(giorniTerminiPagamento)
				.append(dataScadenzaPagamento).append(importoPagamento).append(istitutoFinanziario).append(iBAN)
				.append(aBI).append(cAB).append(bIC).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof DettaglioPagamento) == false) {
			return false;
		}
		DettaglioPagamento rhs = ((DettaglioPagamento) other);
		return new EqualsBuilder().append(modalitaPagamento, rhs.modalitaPagamento)
				.append(giorniTerminiPagamento, rhs.giorniTerminiPagamento)
				.append(dataScadenzaPagamento, rhs.dataScadenzaPagamento).append(importoPagamento, rhs.importoPagamento)
				.append(istitutoFinanziario, rhs.istitutoFinanziario).append(iBAN, rhs.iBAN).append(aBI, rhs.aBI)
				.append(cAB, rhs.cAB).append(bIC, rhs.bIC).append(additionalProperties, rhs.additionalProperties)
				.isEquals();
	}

}

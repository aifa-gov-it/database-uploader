
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
@JsonPropertyOrder({ "DatiTrasmissione", "CedentePrestatore", "CessionarioCommittente",
		"TerzoIntermediarioOSoggettoEmittente", "SoggettoEmittente" })
public class FatturaElettronicaHeader implements Serializable {

	@JsonProperty("DatiTrasmissione")
	@Valid
	private DatiTrasmissione datiTrasmissione;
	@JsonProperty("CedentePrestatore")
	@Valid
	private CedentePrestatore cedentePrestatore;
	@JsonProperty("CessionarioCommittente")
	@Valid
	private CessionarioCommittente cessionarioCommittente;
	@JsonProperty("TerzoIntermediarioOSoggettoEmittente")
	@Valid
	private TerzoIntermediarioOSoggettoEmittente terzoIntermediarioOSoggettoEmittente;
	@JsonProperty("SoggettoEmittente")
	private String soggettoEmittente;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -8924986684026906725L;

	public FatturaElettronicaHeader() {
	}

	public FatturaElettronicaHeader(DatiTrasmissione datiTrasmissione, CedentePrestatore cedentePrestatore,
			CessionarioCommittente cessionarioCommittente,
			TerzoIntermediarioOSoggettoEmittente terzoIntermediarioOSoggettoEmittente, String soggettoEmittente) {
		super();
		this.datiTrasmissione = datiTrasmissione;
		this.cedentePrestatore = cedentePrestatore;
		this.cessionarioCommittente = cessionarioCommittente;
		this.terzoIntermediarioOSoggettoEmittente = terzoIntermediarioOSoggettoEmittente;
		this.soggettoEmittente = soggettoEmittente;
	}

	@JsonProperty("DatiTrasmissione")
	public DatiTrasmissione getDatiTrasmissione() {
		return datiTrasmissione;
	}

	@JsonProperty("DatiTrasmissione")
	public void setDatiTrasmissione(DatiTrasmissione datiTrasmissione) {
		this.datiTrasmissione = datiTrasmissione;
	}

	@JsonProperty("CedentePrestatore")
	public CedentePrestatore getCedentePrestatore() {
		return cedentePrestatore;
	}

	@JsonProperty("CedentePrestatore")
	public void setCedentePrestatore(CedentePrestatore cedentePrestatore) {
		this.cedentePrestatore = cedentePrestatore;
	}

	@JsonProperty("CessionarioCommittente")
	public CessionarioCommittente getCessionarioCommittente() {
		return cessionarioCommittente;
	}

	@JsonProperty("CessionarioCommittente")
	public void setCessionarioCommittente(CessionarioCommittente cessionarioCommittente) {
		this.cessionarioCommittente = cessionarioCommittente;
	}

	@JsonProperty("TerzoIntermediarioOSoggettoEmittente")
	public TerzoIntermediarioOSoggettoEmittente getTerzoIntermediarioOSoggettoEmittente() {
		return terzoIntermediarioOSoggettoEmittente;
	}

	@JsonProperty("TerzoIntermediarioOSoggettoEmittente")
	public void setTerzoIntermediarioOSoggettoEmittente(
			TerzoIntermediarioOSoggettoEmittente terzoIntermediarioOSoggettoEmittente) {
		this.terzoIntermediarioOSoggettoEmittente = terzoIntermediarioOSoggettoEmittente;
	}

	@JsonProperty("SoggettoEmittente")
	public String getSoggettoEmittente() {
		return soggettoEmittente;
	}

	@JsonProperty("SoggettoEmittente")
	public void setSoggettoEmittente(String soggettoEmittente) {
		this.soggettoEmittente = soggettoEmittente;
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
		return new HashCodeBuilder().append(datiTrasmissione).append(cedentePrestatore).append(cessionarioCommittente)
				.append(terzoIntermediarioOSoggettoEmittente).append(soggettoEmittente).append(additionalProperties)
				.toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof FatturaElettronicaHeader) == false) {
			return false;
		}
		FatturaElettronicaHeader rhs = ((FatturaElettronicaHeader) other);
		return new EqualsBuilder().append(datiTrasmissione, rhs.datiTrasmissione)
				.append(cedentePrestatore, rhs.cedentePrestatore)
				.append(cessionarioCommittente, rhs.cessionarioCommittente)
				.append(terzoIntermediarioOSoggettoEmittente, rhs.terzoIntermediarioOSoggettoEmittente)
				.append(soggettoEmittente, rhs.soggettoEmittente).append(additionalProperties, rhs.additionalProperties)
				.isEquals();
	}

}

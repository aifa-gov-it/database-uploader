
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
@JsonPropertyOrder({ "AliquotaIVA", "ImponibileImporto", "Imposta", "EsigibilitaIVA", "RiferimentoNormativo" })
public class DatiRiepilogo implements Serializable {

	@JsonProperty("AliquotaIVA")
	private String aliquotaIVA;
	@JsonProperty("ImponibileImporto")
	private String imponibileImporto;
	@JsonProperty("Imposta")
	private String imposta;
	@JsonProperty("EsigibilitaIVA")
	private String esigibilitaIVA;
	@JsonProperty("RiferimentoNormativo")
	private String riferimentoNormativo;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 2474686790228474053L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public DatiRiepilogo() {
	}

	/**
	 * 
	 * @param riferimentoNormativo
	 * @param imposta
	 * @param imponibileImporto
	 * @param aliquotaIVA
	 * @param esigibilitaIVA
	 */
	public DatiRiepilogo(String aliquotaIVA, String imponibileImporto, String imposta, String esigibilitaIVA,
			String riferimentoNormativo) {
		super();
		this.aliquotaIVA = aliquotaIVA;
		this.imponibileImporto = imponibileImporto;
		this.imposta = imposta;
		this.esigibilitaIVA = esigibilitaIVA;
		this.riferimentoNormativo = riferimentoNormativo;
	}

	@JsonProperty("AliquotaIVA")
	public String getAliquotaIVA() {
		return aliquotaIVA;
	}

	@JsonProperty("AliquotaIVA")
	public void setAliquotaIVA(String aliquotaIVA) {
		this.aliquotaIVA = aliquotaIVA;
	}

	@JsonProperty("ImponibileImporto")
	public String getImponibileImporto() {
		return imponibileImporto;
	}

	@JsonProperty("ImponibileImporto")
	public void setImponibileImporto(String imponibileImporto) {
		this.imponibileImporto = imponibileImporto;
	}

	@JsonProperty("Imposta")
	public String getImposta() {
		return imposta;
	}

	@JsonProperty("Imposta")
	public void setImposta(String imposta) {
		this.imposta = imposta;
	}

	@JsonProperty("EsigibilitaIVA")
	public String getEsigibilitaIVA() {
		return esigibilitaIVA;
	}

	@JsonProperty("EsigibilitaIVA")
	public void setEsigibilitaIVA(String esigibilitaIVA) {
		this.esigibilitaIVA = esigibilitaIVA;
	}

	@JsonProperty("RiferimentoNormativo")
	public String getRiferimentoNormativo() {
		return riferimentoNormativo;
	}

	@JsonProperty("RiferimentoNormativo")
	public void setRiferimentoNormativo(String riferimentoNormativo) {
		this.riferimentoNormativo = riferimentoNormativo;
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
		return new HashCodeBuilder().append(aliquotaIVA).append(imponibileImporto).append(imposta)
				.append(esigibilitaIVA).append(riferimentoNormativo).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof DatiRiepilogo) == false) {
			return false;
		}
		DatiRiepilogo rhs = ((DatiRiepilogo) other);
		return new EqualsBuilder().append(aliquotaIVA, rhs.aliquotaIVA).append(imponibileImporto, rhs.imponibileImporto)
				.append(imposta, rhs.imposta).append(esigibilitaIVA, rhs.esigibilitaIVA)
				.append(riferimentoNormativo, rhs.riferimentoNormativo)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}

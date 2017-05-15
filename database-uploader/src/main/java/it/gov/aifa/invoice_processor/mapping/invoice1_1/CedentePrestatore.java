
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
@JsonPropertyOrder({ "DatiAnagrafici", "Sede", "IscrizioneREA", "Contatti" })
public class CedentePrestatore implements Serializable {

	@JsonProperty("DatiAnagrafici")
	@Valid
	private DatiAnagrafici datiAnagrafici;
	@JsonProperty("Sede")
	@Valid
	private Sede sede;
	@JsonProperty("IscrizioneREA")
	@Valid
	private IscrizioneREA iscrizioneREA;
	@JsonProperty("Contatti")
	@Valid
	private Contatti contatti;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 7721985433270846175L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public CedentePrestatore() {
	}

	/**
	 * 
	 * @param datiAnagrafici
	 * @param iscrizioneREA
	 * @param sede
	 * @param contatti
	 */
	public CedentePrestatore(DatiAnagrafici datiAnagrafici, Sede sede, IscrizioneREA iscrizioneREA, Contatti contatti) {
		super();
		this.datiAnagrafici = datiAnagrafici;
		this.sede = sede;
		this.iscrizioneREA = iscrizioneREA;
		this.contatti = contatti;
	}

	@JsonProperty("DatiAnagrafici")
	public DatiAnagrafici getDatiAnagrafici() {
		return datiAnagrafici;
	}

	@JsonProperty("DatiAnagrafici")
	public void setDatiAnagrafici(DatiAnagrafici datiAnagrafici) {
		this.datiAnagrafici = datiAnagrafici;
	}

	@JsonProperty("Sede")
	public Sede getSede() {
		return sede;
	}

	@JsonProperty("Sede")
	public void setSede(Sede sede) {
		this.sede = sede;
	}

	@JsonProperty("IscrizioneREA")
	public IscrizioneREA getIscrizioneREA() {
		return iscrizioneREA;
	}

	@JsonProperty("IscrizioneREA")
	public void setIscrizioneREA(IscrizioneREA iscrizioneREA) {
		this.iscrizioneREA = iscrizioneREA;
	}

	@JsonProperty("Contatti")
	public Contatti getContatti() {
		return contatti;
	}

	@JsonProperty("Contatti")
	public void setContatti(Contatti contatti) {
		this.contatti = contatti;
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
		return new HashCodeBuilder().append(datiAnagrafici).append(sede).append(iscrizioneREA).append(contatti)
				.append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof CedentePrestatore) == false) {
			return false;
		}
		CedentePrestatore rhs = ((CedentePrestatore) other);
		return new EqualsBuilder().append(datiAnagrafici, rhs.datiAnagrafici).append(sede, rhs.sede)
				.append(iscrizioneREA, rhs.iscrizioneREA).append(contatti, rhs.contatti)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}

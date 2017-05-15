
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
@JsonPropertyOrder({ "IdTrasmittente", "ProgressivoInvio", "FormatoTrasmissione", "CodiceDestinatario",
		"ContattiTrasmittente" })
public class DatiTrasmissione implements Serializable {

	@JsonProperty("IdTrasmittente")
	@Valid
	private IdTrasmittente idTrasmittente;
	@JsonProperty("ProgressivoInvio")
	private String progressivoInvio;
	@JsonProperty("FormatoTrasmissione")
	private String formatoTrasmissione;
	@JsonProperty("CodiceDestinatario")
	private String codiceDestinatario;
	@JsonProperty("ContattiTrasmittente")
	@Valid
	private ContattiTrasmittente contattiTrasmittente;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -183221925744974485L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public DatiTrasmissione() {
	}

	/**
	 * 
	 * @param progressivoInvio
	 * @param codiceDestinatario
	 * @param formatoTrasmissione
	 * @param idTrasmittente
	 * @param contattiTrasmittente
	 */
	public DatiTrasmissione(IdTrasmittente idTrasmittente, String progressivoInvio, String formatoTrasmissione,
			String codiceDestinatario, ContattiTrasmittente contattiTrasmittente) {
		super();
		this.idTrasmittente = idTrasmittente;
		this.progressivoInvio = progressivoInvio;
		this.formatoTrasmissione = formatoTrasmissione;
		this.codiceDestinatario = codiceDestinatario;
		this.contattiTrasmittente = contattiTrasmittente;
	}

	@JsonProperty("IdTrasmittente")
	public IdTrasmittente getIdTrasmittente() {
		return idTrasmittente;
	}

	@JsonProperty("IdTrasmittente")
	public void setIdTrasmittente(IdTrasmittente idTrasmittente) {
		this.idTrasmittente = idTrasmittente;
	}

	@JsonProperty("ProgressivoInvio")
	public String getProgressivoInvio() {
		return progressivoInvio;
	}

	@JsonProperty("ProgressivoInvio")
	public void setProgressivoInvio(String progressivoInvio) {
		this.progressivoInvio = progressivoInvio;
	}

	@JsonProperty("FormatoTrasmissione")
	public String getFormatoTrasmissione() {
		return formatoTrasmissione;
	}

	@JsonProperty("FormatoTrasmissione")
	public void setFormatoTrasmissione(String formatoTrasmissione) {
		this.formatoTrasmissione = formatoTrasmissione;
	}

	@JsonProperty("CodiceDestinatario")
	public String getCodiceDestinatario() {
		return codiceDestinatario;
	}

	@JsonProperty("CodiceDestinatario")
	public void setCodiceDestinatario(String codiceDestinatario) {
		this.codiceDestinatario = codiceDestinatario;
	}

	@JsonProperty("ContattiTrasmittente")
	public ContattiTrasmittente getContattiTrasmittente() {
		return contattiTrasmittente;
	}

	@JsonProperty("ContattiTrasmittente")
	public void setContattiTrasmittente(ContattiTrasmittente contattiTrasmittente) {
		this.contattiTrasmittente = contattiTrasmittente;
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
		return new HashCodeBuilder().append(idTrasmittente).append(progressivoInvio).append(formatoTrasmissione)
				.append(codiceDestinatario).append(contattiTrasmittente).append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof DatiTrasmissione) == false) {
			return false;
		}
		DatiTrasmissione rhs = ((DatiTrasmissione) other);
		return new EqualsBuilder().append(idTrasmittente, rhs.idTrasmittente)
				.append(progressivoInvio, rhs.progressivoInvio).append(formatoTrasmissione, rhs.formatoTrasmissione)
				.append(codiceDestinatario, rhs.codiceDestinatario)
				.append(contattiTrasmittente, rhs.contattiTrasmittente)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}


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
@JsonPropertyOrder({ "NumeroLinea", "CodiceArticolo", "Descrizione", "Quantita", "UnitaMisura", "PrezzoUnitario",
		"PrezzoTotale", "AliquotaIVA" })
public class DettaglioLinee implements Serializable {

	@JsonProperty("NumeroLinea")
	private String numeroLinea;
	@JsonProperty("CodiceArticolo")
	@Valid
	private CodiceArticolo codiceArticolo;
	@JsonProperty("Descrizione")
	private String descrizione;
	@JsonProperty("Quantita")
	private String quantita;
	@JsonProperty("UnitaMisura")
	private String unitaMisura;
	@JsonProperty("PrezzoUnitario")
	private String prezzoUnitario;
	@JsonProperty("PrezzoTotale")
	private String prezzoTotale;
	@JsonProperty("AliquotaIVA")
	private String aliquotaIVA;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -4390389506146406558L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public DettaglioLinee() {
	}

	/**
	 * 
	 * @param descrizione
	 * @param prezzoTotale
	 * @param aliquotaIVA
	 * @param prezzoUnitario
	 * @param numeroLinea
	 * @param unitaMisura
	 * @param quantita
	 * @param codiceArticolo
	 */
	public DettaglioLinee(String numeroLinea, CodiceArticolo codiceArticolo, String descrizione, String quantita,
			String unitaMisura, String prezzoUnitario, String prezzoTotale, String aliquotaIVA) {
		super();
		this.numeroLinea = numeroLinea;
		this.codiceArticolo = codiceArticolo;
		this.descrizione = descrizione;
		this.quantita = quantita;
		this.unitaMisura = unitaMisura;
		this.prezzoUnitario = prezzoUnitario;
		this.prezzoTotale = prezzoTotale;
		this.aliquotaIVA = aliquotaIVA;
	}

	@JsonProperty("NumeroLinea")
	public String getNumeroLinea() {
		return numeroLinea;
	}

	@JsonProperty("NumeroLinea")
	public void setNumeroLinea(String numeroLinea) {
		this.numeroLinea = numeroLinea;
	}

	@JsonProperty("CodiceArticolo")
	public CodiceArticolo getCodiceArticolo() {
		return codiceArticolo;
	}

	@JsonProperty("CodiceArticolo")
	public void setCodiceArticolo(CodiceArticolo codiceArticolo) {
		this.codiceArticolo = codiceArticolo;
	}

	@JsonProperty("Descrizione")
	public String getDescrizione() {
		return descrizione;
	}

	@JsonProperty("Descrizione")
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@JsonProperty("Quantita")
	public String getQuantita() {
		return quantita;
	}

	@JsonProperty("Quantita")
	public void setQuantita(String quantita) {
		this.quantita = quantita;
	}

	@JsonProperty("UnitaMisura")
	public String getUnitaMisura() {
		return unitaMisura;
	}

	@JsonProperty("UnitaMisura")
	public void setUnitaMisura(String unitaMisura) {
		this.unitaMisura = unitaMisura;
	}

	@JsonProperty("PrezzoUnitario")
	public String getPrezzoUnitario() {
		return prezzoUnitario;
	}

	@JsonProperty("PrezzoUnitario")
	public void setPrezzoUnitario(String prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

	@JsonProperty("PrezzoTotale")
	public String getPrezzoTotale() {
		return prezzoTotale;
	}

	@JsonProperty("PrezzoTotale")
	public void setPrezzoTotale(String prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}

	@JsonProperty("AliquotaIVA")
	public String getAliquotaIVA() {
		return aliquotaIVA;
	}

	@JsonProperty("AliquotaIVA")
	public void setAliquotaIVA(String aliquotaIVA) {
		this.aliquotaIVA = aliquotaIVA;
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
		return new HashCodeBuilder().append(numeroLinea).append(codiceArticolo).append(descrizione).append(quantita)
				.append(unitaMisura).append(prezzoUnitario).append(prezzoTotale).append(aliquotaIVA)
				.append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof DettaglioLinee) == false) {
			return false;
		}
		DettaglioLinee rhs = ((DettaglioLinee) other);
		return new EqualsBuilder().append(numeroLinea, rhs.numeroLinea).append(codiceArticolo, rhs.codiceArticolo)
				.append(descrizione, rhs.descrizione).append(quantita, rhs.quantita)
				.append(unitaMisura, rhs.unitaMisura).append(prezzoUnitario, rhs.prezzoUnitario)
				.append(prezzoTotale, rhs.prezzoTotale).append(aliquotaIVA, rhs.aliquotaIVA)
				.append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}

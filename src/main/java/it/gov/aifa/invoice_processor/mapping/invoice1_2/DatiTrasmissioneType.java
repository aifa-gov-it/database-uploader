package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiTrasmissioneType", propOrder = { "idTrasmittente", "progressivoInvio", "formatoTrasmissione",
		"codiceDestinatario", "contattiTrasmittente", "pecDestinatario" })
public class DatiTrasmissioneType {

	@XmlElement(name = "CodiceDestinatario", required = true)
	protected String codiceDestinatario;

	@XmlElement(name = "ContattiTrasmittente")
	protected ContattiTrasmittenteType contattiTrasmittente;

	@XmlElement(name = "FormatoTrasmissione", required = true)
	@XmlSchemaType(name = "string")
	protected FormatoTrasmissioneType formatoTrasmissione;
	@XmlElement(name = "IdTrasmittente", required = true)
	protected IdFiscaleType idTrasmittente;
	@XmlElement(name = "PECDestinatario")
	protected String pecDestinatario;
	@XmlElement(name = "ProgressivoInvio", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String progressivoInvio;
	public DatiTrasmissioneType() {
	}
	public DatiTrasmissioneType(String codiceDestinatario, ContattiTrasmittenteType contattiTrasmittente,
			FormatoTrasmissioneType formatoTrasmissione, IdFiscaleType idTrasmittente, String pecDestinatario,
			String progressivoInvio) {
		this.codiceDestinatario = codiceDestinatario;
		this.contattiTrasmittente = contattiTrasmittente;
		this.formatoTrasmissione = formatoTrasmissione;
		this.idTrasmittente = idTrasmittente;
		this.pecDestinatario = pecDestinatario;
		this.progressivoInvio = progressivoInvio;
	}

	public String getCodiceDestinatario() {
		return codiceDestinatario;
	}

	public ContattiTrasmittenteType getContattiTrasmittente() {
		return contattiTrasmittente;
	}

	public FormatoTrasmissioneType getFormatoTrasmissione() {
		return formatoTrasmissione;
	}

	public IdFiscaleType getIdTrasmittente() {
		return idTrasmittente;
	}

	public String getPECDestinatario() {
		return pecDestinatario;
	}

	public String getProgressivoInvio() {
		return progressivoInvio;
	}

	public void setCodiceDestinatario(String value) {
		this.codiceDestinatario = value;
	}

	public void setContattiTrasmittente(ContattiTrasmittenteType value) {
		this.contattiTrasmittente = value;
	}

	public void setFormatoTrasmissione(FormatoTrasmissioneType value) {
		this.formatoTrasmissione = value;
	}

	public void setIdTrasmittente(IdFiscaleType value) {
		this.idTrasmittente = value;
	}

	public void setPECDestinatario(String value) {
		this.pecDestinatario = value;
	}

	public void setProgressivoInvio(String value) {
		this.progressivoInvio = value;
	}

}

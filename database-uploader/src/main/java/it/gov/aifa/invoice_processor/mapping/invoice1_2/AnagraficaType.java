package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnagraficaType", propOrder = { "denominazione", "nome", "cognome", "titolo", "codEORI" })
public class AnagraficaType {

	@XmlElement(name = "CodEORI")
	protected String codEORI;

	@XmlElement(name = "Cognome")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String cognome;

	@XmlElement(name = "Denominazione")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String denominazione;
	@XmlElement(name = "Nome")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String nome;
	@XmlElement(name = "Titolo")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String titolo;
	public AnagraficaType() {
	}
	public AnagraficaType(String codEORI, String cognome, String denominazione, String nome, String titolo) {
		this.codEORI = codEORI;
		this.cognome = cognome;
		this.denominazione = denominazione;
		this.nome = nome;
		this.titolo = titolo;
	}

	public String getCodEORI() {
		return codEORI;
	}

	public String getCognome() {
		return cognome;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public String getNome() {
		return nome;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setCodEORI(String value) {
		this.codEORI = value;
	}

	public void setCognome(String value) {
		this.cognome = value;
	}

	public void setDenominazione(String value) {
		this.denominazione = value;
	}

	public void setNome(String value) {
		this.nome = value;
	}

	public void setTitolo(String value) {
		this.titolo = value;
	}

}

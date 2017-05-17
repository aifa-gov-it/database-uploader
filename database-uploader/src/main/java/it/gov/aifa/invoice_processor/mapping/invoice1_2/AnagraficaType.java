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

	@XmlElement(name = "Denominazione")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String denominazione;
	@XmlElement(name = "Nome")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String nome;
	@XmlElement(name = "Cognome")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String cognome;
	@XmlElement(name = "Titolo")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String titolo;
	@XmlElement(name = "CodEORI")
	protected String codEORI;

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String value) {
		this.denominazione = value;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String value) {
		this.nome = value;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String value) {
		this.cognome = value;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String value) {
		this.titolo = value;
	}

	public String getCodEORI() {
		return codEORI;
	}

	public void setCodEORI(String value) {
		this.codEORI = value;
	}

}

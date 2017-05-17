package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AllegatiType", propOrder = { "nomeAttachment", "algoritmoCompressione", "formatoAttachment",
		"descrizioneAttachment", "attachment" })
public class AllegatiType {

	@XmlElement(name = "NomeAttachment", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String nomeAttachment;
	@XmlElement(name = "AlgoritmoCompressione")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String algoritmoCompressione;
	@XmlElement(name = "FormatoAttachment")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String formatoAttachment;
	@XmlElement(name = "DescrizioneAttachment")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String descrizioneAttachment;
	@XmlElement(name = "Attachment", required = true)
	protected byte[] attachment;

	public String getNomeAttachment() {
		return nomeAttachment;
	}

	public void setNomeAttachment(String value) {
		this.nomeAttachment = value;
	}

	public String getAlgoritmoCompressione() {
		return algoritmoCompressione;
	}

	public void setAlgoritmoCompressione(String value) {
		this.algoritmoCompressione = value;
	}

	public String getFormatoAttachment() {
		return formatoAttachment;
	}

	public void setFormatoAttachment(String value) {
		this.formatoAttachment = value;
	}

	public String getDescrizioneAttachment() {
		return descrizioneAttachment;
	}

	public void setDescrizioneAttachment(String value) {
		this.descrizioneAttachment = value;
	}

	public byte[] getAttachment() {
		return attachment;
	}

	public void setAttachment(byte[] value) {
		this.attachment = value;
	}

}

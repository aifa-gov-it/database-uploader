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

	@XmlElement(name = "AlgoritmoCompressione")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String algoritmoCompressione;

	@XmlElement(name = "Attachment", required = true)
	protected byte[] attachment;

	@XmlElement(name = "DescrizioneAttachment")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String descrizioneAttachment;
	@XmlElement(name = "FormatoAttachment")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String formatoAttachment;
	@XmlElement(name = "NomeAttachment", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String nomeAttachment;
	public AllegatiType() {
	}
	public AllegatiType(String algoritmoCompressione, byte[] attachment, String descrizioneAttachment,
			String formatoAttachment, String nomeAttachment) {
		this.algoritmoCompressione = algoritmoCompressione;
		this.attachment = attachment;
		this.descrizioneAttachment = descrizioneAttachment;
		this.formatoAttachment = formatoAttachment;
		this.nomeAttachment = nomeAttachment;
	}

	public String getAlgoritmoCompressione() {
		return algoritmoCompressione;
	}

	public byte[] getAttachment() {
		return attachment;
	}

	public String getDescrizioneAttachment() {
		return descrizioneAttachment;
	}

	public String getFormatoAttachment() {
		return formatoAttachment;
	}

	public String getNomeAttachment() {
		return nomeAttachment;
	}

	public void setAlgoritmoCompressione(String value) {
		this.algoritmoCompressione = value;
	}

	public void setAttachment(byte[] value) {
		this.attachment = value;
	}

	public void setDescrizioneAttachment(String value) {
		this.descrizioneAttachment = value;
	}

	public void setFormatoAttachment(String value) {
		this.formatoAttachment = value;
	}

	public void setNomeAttachment(String value) {
		this.nomeAttachment = value;
	}

}

package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiPagamentoType", propOrder = { "condizioniPagamento", "dettaglioPagamento" })
public class DatiPagamentoType {

	@XmlElement(name = "CondizioniPagamento", required = true)
	@XmlSchemaType(name = "string")
	protected CondizioniPagamentoType condizioniPagamento;

	@XmlElement(name = "DettaglioPagamento", required = true)
	protected List<DettaglioPagamentoType> dettaglioPagamento;

	public DatiPagamentoType() {
	}
	public DatiPagamentoType(CondizioniPagamentoType condizioniPagamento,
			List<DettaglioPagamentoType> dettaglioPagamento) {
		this.condizioniPagamento = condizioniPagamento;
		this.dettaglioPagamento = dettaglioPagamento;
	}

	public CondizioniPagamentoType getCondizioniPagamento() {
		return condizioniPagamento;
	}

	public List<DettaglioPagamentoType> getDettaglioPagamento() {
		if (dettaglioPagamento == null) {
			dettaglioPagamento = new ArrayList<DettaglioPagamentoType>();
		}
		return this.dettaglioPagamento;
	}

	public void setCondizioniPagamento(CondizioniPagamentoType value) {
		this.condizioniPagamento = value;
	}

}

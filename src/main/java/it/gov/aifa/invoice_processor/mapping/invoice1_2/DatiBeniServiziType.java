package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiBeniServiziType", propOrder = { "dettaglioLinee", "datiRiepilogo" })
public class DatiBeniServiziType {

	@XmlElement(name = "DatiRiepilogo", required = true)
	protected List<DatiRiepilogoType> datiRiepilogo;

	@XmlElement(name = "DettaglioLinee", required = true)
	protected List<DettaglioLineeType> dettaglioLinee;

	public DatiBeniServiziType() {
	}
	public DatiBeniServiziType(List<DatiRiepilogoType> datiRiepilogo, List<DettaglioLineeType> dettaglioLinee) {
		this.datiRiepilogo = datiRiepilogo;
		this.dettaglioLinee = dettaglioLinee;
	}

	public List<DatiRiepilogoType> getDatiRiepilogo() {
		if (datiRiepilogo == null) {
			datiRiepilogo = new ArrayList<DatiRiepilogoType>();
		}
		return this.datiRiepilogo;
	}

	public List<DettaglioLineeType> getDettaglioLinee() {
		if (dettaglioLinee == null) {
			dettaglioLinee = new ArrayList<DettaglioLineeType>();
		}
		return this.dettaglioLinee;
	}

}

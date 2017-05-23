package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiGeneraliType", propOrder = { "datiGeneraliDocumento", "datiOrdineAcquisto", "datiContratto",
		"datiConvenzione", "datiRicezione", "datiFattureCollegate", "datiSAL", "datiDDT", "datiTrasporto",
		"fatturaPrincipale" })
public class DatiGeneraliType {

	@XmlElement(name = "DatiContratto")
	protected List<DatiDocumentiCorrelatiType> datiContratto;

	@XmlElement(name = "DatiConvenzione")
	protected List<DatiDocumentiCorrelatiType> datiConvenzione;

	@XmlElement(name = "DatiDDT")
	protected List<DatiDDTType> datiDDT;
	@XmlElement(name = "DatiFattureCollegate")
	protected List<DatiDocumentiCorrelatiType> datiFattureCollegate;
	@XmlElement(name = "DatiGeneraliDocumento", required = true)
	protected DatiGeneraliDocumentoType datiGeneraliDocumento;
	@XmlElement(name = "DatiOrdineAcquisto")
	protected List<DatiDocumentiCorrelatiType> datiOrdineAcquisto;
	@XmlElement(name = "DatiRicezione")
	protected List<DatiDocumentiCorrelatiType> datiRicezione;
	@XmlElement(name = "DatiSAL")
	protected List<DatiSALType> datiSAL;
	@XmlElement(name = "DatiTrasporto")
	protected DatiTrasportoType datiTrasporto;
	@XmlElement(name = "FatturaPrincipale")
	protected FatturaPrincipaleType fatturaPrincipale;
	public DatiGeneraliType() {
	}
	public DatiGeneraliType(List<DatiDocumentiCorrelatiType> datiContratto,
			List<DatiDocumentiCorrelatiType> datiConvenzione, List<DatiDDTType> datiDDT,
			List<DatiDocumentiCorrelatiType> datiFattureCollegate, DatiGeneraliDocumentoType datiGeneraliDocumento,
			List<DatiDocumentiCorrelatiType> datiOrdineAcquisto, List<DatiDocumentiCorrelatiType> datiRicezione,
			List<DatiSALType> datiSAL, DatiTrasportoType datiTrasporto, FatturaPrincipaleType fatturaPrincipale) {
		this.datiContratto = datiContratto;
		this.datiConvenzione = datiConvenzione;
		this.datiDDT = datiDDT;
		this.datiFattureCollegate = datiFattureCollegate;
		this.datiGeneraliDocumento = datiGeneraliDocumento;
		this.datiOrdineAcquisto = datiOrdineAcquisto;
		this.datiRicezione = datiRicezione;
		this.datiSAL = datiSAL;
		this.datiTrasporto = datiTrasporto;
		this.fatturaPrincipale = fatturaPrincipale;
	}

	public List<DatiDocumentiCorrelatiType> getDatiContratto() {
		if (datiContratto == null) {
			datiContratto = new ArrayList<DatiDocumentiCorrelatiType>();
		}
		return this.datiContratto;
	}

	public List<DatiDocumentiCorrelatiType> getDatiConvenzione() {
		if (datiConvenzione == null) {
			datiConvenzione = new ArrayList<DatiDocumentiCorrelatiType>();
		}
		return this.datiConvenzione;
	}

	public List<DatiDDTType> getDatiDDT() {
		if (datiDDT == null) {
			datiDDT = new ArrayList<DatiDDTType>();
		}
		return this.datiDDT;
	}

	public List<DatiDocumentiCorrelatiType> getDatiFattureCollegate() {
		if (datiFattureCollegate == null) {
			datiFattureCollegate = new ArrayList<DatiDocumentiCorrelatiType>();
		}
		return this.datiFattureCollegate;
	}

	public DatiGeneraliDocumentoType getDatiGeneraliDocumento() {
		return datiGeneraliDocumento;
	}

	public List<DatiDocumentiCorrelatiType> getDatiOrdineAcquisto() {
		if (datiOrdineAcquisto == null) {
			datiOrdineAcquisto = new ArrayList<DatiDocumentiCorrelatiType>();
		}
		return this.datiOrdineAcquisto;
	}

	public List<DatiDocumentiCorrelatiType> getDatiRicezione() {
		if (datiRicezione == null) {
			datiRicezione = new ArrayList<DatiDocumentiCorrelatiType>();
		}
		return this.datiRicezione;
	}

	public List<DatiSALType> getDatiSAL() {
		if (datiSAL == null) {
			datiSAL = new ArrayList<DatiSALType>();
		}
		return this.datiSAL;
	}

	public DatiTrasportoType getDatiTrasporto() {
		return datiTrasporto;
	}

	public FatturaPrincipaleType getFatturaPrincipale() {
		return fatturaPrincipale;
	}

	public void setDatiGeneraliDocumento(DatiGeneraliDocumentoType value) {
		this.datiGeneraliDocumento = value;
	}

	public void setDatiTrasporto(DatiTrasportoType value) {
		this.datiTrasporto = value;
	}

	public void setFatturaPrincipale(FatturaPrincipaleType value) {
		this.fatturaPrincipale = value;
	}

}

package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiCassaPrevidenzialeType", propOrder = { "tipoCassa", "alCassa", "importoContributoCassa",
		"imponibileCassa", "aliquotaIVA", "ritenuta", "natura", "riferimentoAmministrazione" })
public class DatiCassaPrevidenzialeType {

	@XmlElement(name = "AlCassa", required = true)
	protected BigDecimal alCassa;

	@XmlElement(name = "AliquotaIVA", required = true)
	protected BigDecimal aliquotaIVA;

	@XmlElement(name = "ImponibileCassa")
	protected BigDecimal imponibileCassa;
	@XmlElement(name = "ImportoContributoCassa", required = true)
	protected BigDecimal importoContributoCassa;
	@XmlElement(name = "Natura")
	@XmlSchemaType(name = "string")
	protected NaturaType natura;
	@XmlElement(name = "RiferimentoAmministrazione")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	@XmlSchemaType(name = "normalizedString")
	protected String riferimentoAmministrazione;
	@XmlElement(name = "Ritenuta")
	@XmlSchemaType(name = "string")
	protected RitenutaType ritenuta;
	@XmlElement(name = "TipoCassa", required = true)
	@XmlSchemaType(name = "string")
	protected TipoCassaType tipoCassa;
	public DatiCassaPrevidenzialeType() {
	}
	public DatiCassaPrevidenzialeType(BigDecimal alCassa, BigDecimal aliquotaIVA, BigDecimal imponibileCassa,
			BigDecimal importoContributoCassa, NaturaType natura, String riferimentoAmministrazione,
			RitenutaType ritenuta, TipoCassaType tipoCassa) {
		this.alCassa = alCassa;
		this.aliquotaIVA = aliquotaIVA;
		this.imponibileCassa = imponibileCassa;
		this.importoContributoCassa = importoContributoCassa;
		this.natura = natura;
		this.riferimentoAmministrazione = riferimentoAmministrazione;
		this.ritenuta = ritenuta;
		this.tipoCassa = tipoCassa;
	}

	public BigDecimal getAlCassa() {
		return alCassa;
	}

	public BigDecimal getAliquotaIVA() {
		return aliquotaIVA;
	}

	public BigDecimal getImponibileCassa() {
		return imponibileCassa;
	}

	public BigDecimal getImportoContributoCassa() {
		return importoContributoCassa;
	}

	public NaturaType getNatura() {
		return natura;
	}

	public String getRiferimentoAmministrazione() {
		return riferimentoAmministrazione;
	}

	public RitenutaType getRitenuta() {
		return ritenuta;
	}

	public TipoCassaType getTipoCassa() {
		return tipoCassa;
	}

	public void setAlCassa(BigDecimal value) {
		this.alCassa = value;
	}

	public void setAliquotaIVA(BigDecimal value) {
		this.aliquotaIVA = value;
	}

	public void setImponibileCassa(BigDecimal value) {
		this.imponibileCassa = value;
	}

	public void setImportoContributoCassa(BigDecimal value) {
		this.importoContributoCassa = value;
	}

	public void setNatura(NaturaType value) {
		this.natura = value;
	}

	public void setRiferimentoAmministrazione(String value) {
		this.riferimentoAmministrazione = value;
	}

	public void setRitenuta(RitenutaType value) {
		this.ritenuta = value;
	}

	public void setTipoCassa(TipoCassaType value) {
		this.tipoCassa = value;
	}

}

package it.gov.aifa.invoice_processor.mapping.invoice1_2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiBolloType", propOrder = { "bolloVirtuale", "importoBollo" })
public class DatiBolloType {

	@XmlElement(name = "BolloVirtuale", required = true)
	@XmlSchemaType(name = "string")
	protected BolloVirtualeType bolloVirtuale;

	@XmlElement(name = "ImportoBollo", required = true)
	protected BigDecimal importoBollo;

	public DatiBolloType() {
	}
	public DatiBolloType(BolloVirtualeType bolloVirtuale, BigDecimal importoBollo) {
		this.bolloVirtuale = bolloVirtuale;
		this.importoBollo = importoBollo;
	}

	public BolloVirtualeType getBolloVirtuale() {
		return bolloVirtuale;
	}

	public BigDecimal getImportoBollo() {
		return importoBollo;
	}

	public void setBolloVirtuale(BolloVirtualeType value) {
		this.bolloVirtuale = value;
	}

	public void setImportoBollo(BigDecimal value) {
		this.importoBollo = value;
	}

}

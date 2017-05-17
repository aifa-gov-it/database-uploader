package it.gov.aifa.invoice_processor.mapping.org.w3._2000._09.xmldsig_;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SPKIDataType", propOrder = { "spkiSexpAndAny" })
public class SPKIDataType {

	@XmlElementRef(name = "SPKISexp", namespace = "http://www.w3.org/2000/09/xmldsig#", type = JAXBElement.class)
	@XmlAnyElement(lax = true)
	protected List<Object> spkiSexpAndAny;

	public List<Object> getSPKISexpAndAny() {
		if (spkiSexpAndAny == null) {
			spkiSexpAndAny = new ArrayList<Object>();
		}
		return this.spkiSexpAndAny;
	}

}

package it.gov.aifa.invoice_processor.mapping.invoice1_1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import it.gov.aifa.invoice_processor.mapping.invoice1_2.FatturaElettronicaType;

@XmlRegistry
public class ObjectFactory extends it.gov.aifa.invoice_processor.mapping.invoice1_2.ObjectFactory{

    private final static QName _FatturaElettronica_QNAME = new QName("http://www.fatturapa.gov.it/sdi/fatturapa/v1.1", "FatturaElettronica");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.gov.fatturapa.sdi.fatturapa.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FatturaElettronicaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.fatturapa.gov.it/sdi/fatturapa/v1.1", name = "FatturaElettronica")
    public JAXBElement<FatturaElettronicaType> createFatturaElettronica(FatturaElettronicaType value) {
        return new JAXBElement<FatturaElettronicaType>(_FatturaElettronica_QNAME, FatturaElettronicaType.class, null, value);
    }

}

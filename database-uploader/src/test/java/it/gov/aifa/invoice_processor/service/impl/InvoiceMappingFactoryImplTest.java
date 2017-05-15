package it.gov.aifa.invoice_processor.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.AbstractTest;
import it.gov.aifa.invoice_processor.constant.TestConstant;
import it.gov.aifa.invoice_processor.mapping.invoice1_1.Invoice1_1;
import it.gov.aifa.invoice_processor.service.MappingObjectFactory;

public class InvoiceMappingFactoryImplTest extends AbstractTest{
	
	@Test
	public void buildInvoice1_1Test() throws IOException {
		MappingObjectFactory<Invoice1_1> dataExtractService = new InvoiceMappingFactoryImpl<>();
		Invoice1_1 invoice = dataExtractService.buildFromJson(TestConstant.INVOICE1_1_JSON, Invoice1_1.class);
		assertThat(invoice).isNotNull();
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
        assertThat(validator.validate(invoice)).isEmpty();
	}
}
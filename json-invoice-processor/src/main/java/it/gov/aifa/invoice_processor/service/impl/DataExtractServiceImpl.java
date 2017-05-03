package it.gov.aifa.invoice_processor.service.impl;

import java.util.EnumSet;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import it.gov.aifa.invoice_processor.mapping.Invoice;
import it.gov.aifa.invoice_processor.service.DataExtractService;

@Service
@Validated
public class DataExtractServiceImpl implements DataExtractService {
	private Configuration configuration;

	public DataExtractServiceImpl() {
		configuration = Configuration.builder()
				.jsonProvider(new JacksonJsonProvider())
				.mappingProvider(new JacksonMappingProvider())
				.options(EnumSet.noneOf(Option.class))
				.build();
	}
	
	@Override
	public <T extends Invoice> T buildInvoice(@NotBlank String json, Class<T> invoiceClass) {
		return JsonPath.parse(json, configuration).read("$", invoiceClass);
	}
}

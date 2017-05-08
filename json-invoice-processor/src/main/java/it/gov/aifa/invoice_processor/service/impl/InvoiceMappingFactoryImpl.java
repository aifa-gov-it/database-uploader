package it.gov.aifa.invoice_processor.service.impl;

import java.util.EnumSet;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import it.gov.aifa.invoice_processor.mapping.Invoice;
import it.gov.aifa.invoice_processor.service.MappingObjectFactory;

@Service
@Validated
public class InvoiceMappingFactoryImpl<T extends Invoice> implements MappingObjectFactory<T> {
	private Configuration configuration;

	public InvoiceMappingFactoryImpl() {
		configuration = Configuration.builder()
				.jsonProvider(new JacksonJsonProvider())
				.mappingProvider(new JacksonMappingProvider())
				.options(EnumSet.noneOf(Option.class))
				.build();
	}
	
	@Override
	public T buildFromJson(@NotBlank String json, @NotNull Class<T> destinationClass) {
		return JsonPath.parse(json, configuration).read("$", destinationClass);
	}
}

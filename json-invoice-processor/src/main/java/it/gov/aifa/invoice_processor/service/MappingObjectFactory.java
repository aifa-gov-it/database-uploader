package it.gov.aifa.invoice_processor.service;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public interface MappingObjectFactory <T> {
	T buildFromJson(@NotBlank String json, @NotNull Class<T> destinationClass);
}

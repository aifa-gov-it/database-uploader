package it.gov.aifa.invoice_processor.service.impl;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.slf4j.Logger;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.entity.movement.Movement;

public class MovementProcessorTest {
	@Test
	public void processTest() throws Exception {
		Logger logger = mock(Logger.class);
		Field field = AbstractInvoiceProcessorEntityProcessor.class.getDeclaredField("log");
		field.setAccessible(true);
		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
		field.set(null, logger);
		MovementProcessor movementProcessor = new MovementProcessor();
		Movement movement = new Movement("aic", "documentNumber", "documentTypeCode", "2017-05-25", "08:55:45");
		movementProcessor.process(movement);
		verify(logger, times(1)).info(anyString(), eq(movement.getClass().toGenericString()), eq(movement.getId()));
	}
}

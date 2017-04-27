package it.gov.aifa.invoice_processor.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableValidator;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.gov.aifa.invoice_processor.service.JsonService;
import it.gov.aifa.invoice_processor.service.constant.JsonKey;
import it.gov.aifa.invoice_processor.service.constant.TestConstant;

public class JsonServiceTest {
	@Test
	public void loadJsonFromFilesystemTest() throws Exception{
		JsonService service = new JsonServiceImpl(new ObjectMapper());
		Map<String,Object> result = service.loadJsonFromFilesystem(TestConstant.TEST_FILE_PATH);
		assertThat(result.containsKey(JsonKey.INVOICE_ROOT)).isTrue();
		assertThat(result).hasSize(1);
	}

	@Test
	public void loadJsonFromFilesystemNullPathTest() throws Exception{
		JsonService object = new JsonServiceImpl(new ObjectMapper());
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		ExecutableValidator executableValidator = factory.getValidator().forExecutables();
		Method method = JsonService.class.getMethod( "loadJsonFromFilesystem", Path.class );
		Object[] parameterValues = { null };
		Set<ConstraintViolation<JsonService>> violations = executableValidator.validateParameters(
				object,
				method,
				parameterValues
				);
		assertThat(violations).hasSize(1);
		Class<? extends Annotation> constraintType = violations.iterator()
				.next()
				.getConstraintDescriptor()
				.getAnnotation()
				.annotationType();
		assertThat(constraintType).isEqualTo(NotNull.class);
	}
}

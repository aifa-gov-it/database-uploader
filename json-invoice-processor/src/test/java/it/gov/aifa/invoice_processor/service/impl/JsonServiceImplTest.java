package it.gov.aifa.invoice_processor.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Path;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.gov.aifa.invoice_processor.AbstractTest;
import it.gov.aifa.invoice_processor.constant.TestConstant;
import it.gov.aifa.invoice_processor.service.JsonService;

public class JsonServiceImplTest extends AbstractTest{
	@Test
	public void loadJsonFromFilesystemTest() throws Exception{
		JsonService service = new JsonServiceImpl(new ObjectMapper());
		Map<String,Object> result = service.loadJsonFromFilesystem(TestConstant.TEST_FILE_PATH_INVOICE1_1);
		assertThat(result.containsKey(TestConstant.INVOICE_ROOT)).isTrue();
		assertThat(result).hasSize(1);
	}

	@Test
	public void loadJsonFromFilesystemNullPathTest() throws Exception{
		validationTest(
				ValidationType.METHOD
				, "loadJsonFromFilesystem"
				, new Class<?>[]{ Path.class }
				, new JsonServiceImpl(new ObjectMapper())
				, JsonServiceImpl.class
				, new Object[]{ null }
				, NotNull.class
				);
	}
}

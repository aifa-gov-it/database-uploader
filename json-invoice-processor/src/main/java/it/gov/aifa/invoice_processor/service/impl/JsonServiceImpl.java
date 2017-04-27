package it.gov.aifa.invoice_processor.service.impl;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import it.gov.aifa.invoice_processor.service.JsonService;

@Service
@Validated
public class JsonServiceImpl implements JsonService {
	private static final Logger log = LoggerFactory.getLogger(JsonServiceImpl.class);

	private MapType mapType;
	private ObjectMapper objectMapper;

	public JsonServiceImpl(ObjectMapper objectMapper) {
		mapType = TypeFactory.defaultInstance().constructMapType(Map.class, String.class, Object.class);
		this.objectMapper = objectMapper;
	}

	@Override
	public Map<String, Object> loadJsonFromFilesystem(@NotNull Path path) throws IOException {
		log.info("Loading JSON from {}", path.toString());
		return objectMapper.readValue(path.toFile(), mapType);
	}

}

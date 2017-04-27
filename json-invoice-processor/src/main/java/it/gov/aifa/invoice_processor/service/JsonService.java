package it.gov.aifa.invoice_processor.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

import javax.validation.constraints.NotNull;

public interface JsonService {
	Map<String,Object> loadJsonFromFilesystem(@NotNull Path path) throws IOException;
}

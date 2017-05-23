package it.gov.aifa.invoice_processor.constant;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TestConstant {
	private static final Logger log = LoggerFactory.getLogger(TestConstant.class);
	private TestConstant() { }
	
	public static final String TEST_DIRECTORY_NAME = "input";
	public static final Path TEST_DIRECTORY_PATH = getPath(TEST_DIRECTORY_NAME);
	public static final String TEST_FILE_PATH_MOVEMENT_DSV = "src/test/resources/input/movement-dsv/movements.dsv";
	
	public static Path getPath(String path){
		try {
			return Paths.get(TestConstant.class.getClassLoader().getResource(path).toURI());
		} catch (URISyntaxException e) {
			log.error("Error while getting {} path", path, e);
			throw new RuntimeException("Cannot get path " + path);
		}
	}
}

package it.gov.aifa.invoice_processor.constant;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.gov.aifa.invoice_processor.entity.invoice.IdAndInvoiceIdPrimaryKey;
import it.gov.aifa.invoice_processor.entity.invoice.LinkedInvoicePrimaryKey;

public final class TestConstant {
	private static final Logger log = LoggerFactory.getLogger(TestConstant.class);
	private TestConstant() { }
	
	public static final String BOOTSTRAP_FINANCIAL_INSTITUTION_ID = "IT123";
	public static final Long BOOTSTRAP_INVOICE_ITEM_ID = 456L;
	public static final String BOOTSTRAP_INVOICE_VERSION = "0.1";
	public static final String BOOTSTRAP_INVOICE_ID = "1234567890";
	public static final String BOOTSTRAP_INVOICE_PARTICIPANT_ID = "invoiceParticipantId";
	public static final Long BOOTSTRAP_INVOICE_TAX_ID = 321L;
	public static final LinkedInvoicePrimaryKey BOOTSTRAP_LINKED_INVOICE_ID = new LinkedInvoicePrimaryKey(LocalDate.of(2017, 5, 5),"321654", BOOTSTRAP_INVOICE_ID);
	public static final IdAndInvoiceIdPrimaryKey BOOTSTRAP_PURCHASE_LINE_ID = new IdAndInvoiceIdPrimaryKey(BOOTSTRAP_INVOICE_ID, "1");
	public static final String BOOTSTRAP_PURCHASE_ORDER_ID = "cigCode_2017-05-06_purchaseOrderId_1234567890_1";
	
	public static final String TEST_DIRECTORY_NAME = "input";
	public static final Path TEST_DIRECTORY_PATH = getPath(TEST_DIRECTORY_NAME);
	public static final Path TEST_FILE_PATH_INVOICE1_1 = getPath(TEST_DIRECTORY_NAME + File.separator + "invoice1_1.json");
	
	public static final String INVOICE1_1_JSON = getInvoiceJson(TEST_FILE_PATH_INVOICE1_1);

	private static Path getPath(String path){
		try {
			return Paths.get(TestConstant.class.getClassLoader().getResource(path).toURI());
		} catch (URISyntaxException e) {
			log.error("Error while getting {} path", path, e);
			throw new RuntimeException("Cannot get path " + path);
		}
	}
	
	private static String getInvoiceJson(Path path) {
		try {
			return Files.lines(path).collect(Collectors.joining());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

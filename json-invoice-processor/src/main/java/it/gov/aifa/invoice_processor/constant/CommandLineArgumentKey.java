package it.gov.aifa.invoice_processor.constant;

public final class CommandLineArgumentKey {
	private CommandLineArgumentKey(){ }
	
	public static final String IMPORT_MOV_CSV = "import-mov-delimited-file";
	public static final String IMPORT_MOV_CSV_WITH_PREFIX = "--" + IMPORT_MOV_CSV;
	public static final String UPLOAD_JSON_TO_DB = "--upload-json-to-db";
	public static final String PATH = "path";
	public static final String PATH_WITH_PREFIX = "--" + PATH;
}

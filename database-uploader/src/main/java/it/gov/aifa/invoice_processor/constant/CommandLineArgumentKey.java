package it.gov.aifa.invoice_processor.constant;

public final class CommandLineArgumentKey {
	public static final String HELP = "--help";
	public static final String IMPORT_INVOICES_WITH_PREFIX = "--import-invoices";
	public static final String IMPORT_MOV_DSV = "import-mov-delimited-file";
	public static final String IMPORT_MOV_DSV_WITH_PREFIX = "--" + IMPORT_MOV_DSV;
	public static final String PATH = "path";
	public static final String PATH_WITH_PREFIX = "--" + PATH;
	private CommandLineArgumentKey(){ }
}

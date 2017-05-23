package it.gov.aifa.invoice_processor.runner;

import it.gov.aifa.invoice_processor.constant.CommandLineArgumentKey;

public enum CommandLineTask {
	HELP(CommandLineArgumentKey.HELP, "Shows this help text.")
	, IMPORT_MOV_DSV(CommandLineArgumentKey.IMPORT_MOV_DSV_WITH_PREFIX
			, "Uploads data from a Delimiter Separated Value (DSV) file. Specify a path with the --path argument. "
					+ "Supports the parsing files with ';' as delimiter and the following header: "
					+ "CODICE_TIPO_MITTENTE;CODICE_MITTENTE;CODICE_TIPO_DESTINATARIO;CODICE_DESTINATARIO;"
					+ "CODICE_TIPO_COMMITTENTE;CODICE_COMMITTENTE;CODICE_TIPO_INTESTAT_FATTURA;"
					+ "CODICE_INTESTAT_FATTURA;CODICE_TIPO_DOCUMENTO;NUMERO_DOCUMENTO;DATA_TRASMISSIONE;"
					+ "ORA_TRASMISSIONE;CODICE_MOVIMENTO;AIC;LOTTO;DATA_SCADENZA;QUANTITA;VALORE")
	, UPLOAD_INVOICES_TO_DB_WITH_PREFIX(CommandLineArgumentKey.UPLOAD_INVOICES_TO_DB_WITH_PREFIX
			, "Uploads data from XML files to the Database. Specify a path with the --path argument.");
	
	private String argumentKey;
	private String description;
	
	private CommandLineTask(String argumentKey, String description){
		this.argumentKey = argumentKey;
		this.description = description;
	}

	public String getArgumentKey() {
		return argumentKey;
	}

	public String getDescription() {
		return description;
	}
}

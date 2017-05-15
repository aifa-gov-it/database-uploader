package it.gov.aifa.invoice_processor.runner;

import it.gov.aifa.invoice_processor.constant.CommandLineArgumentKey;

public enum CommandLineTask {
	JSON_TO_DB_UPLOADER(CommandLineArgumentKey.UPLOAD_JSON_TO_DB, JsonToDbUploader.class);
	
	private String argumentKey;
	private Class<? extends CliRunner> cliRunnerClass;
	
	private CommandLineTask(String argumentKey, Class<? extends CliRunner> cliRunnerClass){
		this.argumentKey = argumentKey;
		this.cliRunnerClass = cliRunnerClass;
	}

	public String getArgumentKey() {
		return argumentKey;
	}

	public Class<? extends CliRunner> getCliRunnerClass() {
		return cliRunnerClass;
	}
}

package it.gov.aifa.invoice_processor.runner;

import java.util.Properties;

public interface CliRunner {
	void run();
	void setArguments(Properties arguments);
}

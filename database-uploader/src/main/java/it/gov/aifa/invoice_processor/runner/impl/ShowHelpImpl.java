package it.gov.aifa.invoice_processor.runner.impl;

import org.springframework.stereotype.Service;

import it.gov.aifa.invoice_processor.runner.CommandLineTask;
import it.gov.aifa.invoice_processor.runner.ShowHelp;

@Service
public class ShowHelpImpl extends AbstractCliRunner implements ShowHelp{
	
	@Override
	public void run() {
		StringBuilder message = new StringBuilder();
		message.append("Database Uploader: upload data from source data files to the configured database.");
		message.append(System.lineSeparator());
		message.append("OPTIONS");
		message.append(System.lineSeparator());
		for(CommandLineTask commandLineTask : CommandLineTask.values()) {
			message.append("   ");
			message.append(commandLineTask.getArgumentKey());
			message.append(" ");
			message.append(commandLineTask.getDescription());
			message.append(System.lineSeparator());
			message.append(System.lineSeparator());
		}
		System.out.println(message.toString());
	}

}

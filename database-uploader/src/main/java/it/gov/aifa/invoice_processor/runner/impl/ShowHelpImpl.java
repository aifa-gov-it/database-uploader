package it.gov.aifa.invoice_processor.runner.impl;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import it.gov.aifa.invoice_processor.runner.CommandLineTask;

@Service
public class ShowHelpImpl implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		if(args == null || ArrayUtils.isEmpty(args)) {
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
}

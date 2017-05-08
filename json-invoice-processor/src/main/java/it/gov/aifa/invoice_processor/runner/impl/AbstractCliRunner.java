package it.gov.aifa.invoice_processor.runner.impl;

import java.util.Properties;

import it.gov.aifa.invoice_processor.runner.CliRunner;

public abstract class AbstractCliRunner implements CliRunner {
	protected Properties arguments;

	@Override
	public void setArguments(Properties arguments) {
		this.arguments = arguments;
	}
}
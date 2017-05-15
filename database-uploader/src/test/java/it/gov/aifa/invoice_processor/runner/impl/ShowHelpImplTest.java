package it.gov.aifa.invoice_processor.runner.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.runner.CommandLineTask;
import it.gov.aifa.invoice_processor.runner.ShowHelp;

public class ShowHelpImplTest {
	
	@Test
	public void runTest() {
		OutputStream outContent = new ByteArrayOutputStream();
		PrintStream originalStream = System.out;
		System.setOut(new PrintStream(outContent));
		ShowHelp showHelp = new ShowHelpImpl();
		showHelp.run();
		String sysoutContent = outContent.toString();
	    assertThat(sysoutContent).isNotEmpty();
	    for(CommandLineTask commandLineTask : CommandLineTask.values())
	    	assertThat(sysoutContent).contains(commandLineTask.getArgumentKey());
	    System.setOut(originalStream);
	}
}

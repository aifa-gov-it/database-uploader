package it.gov.aifa.invoice_processor.runner.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.springframework.boot.CommandLineRunner;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.runner.CommandLineTask;

public class ShowHelpImplTest {
	
	@Test
	public void runNullArgumentsTest() throws Exception {
		OutputStream outContent = new ByteArrayOutputStream();
		PrintStream originalStream = System.out;
		System.setOut(new PrintStream(outContent));
		CommandLineRunner showHelp = new ShowHelpImpl();
		showHelp.run(new String[0]);
		String sysoutContent = outContent.toString();
	    assertThat(sysoutContent).isNotEmpty();
	    for(CommandLineTask commandLineTask : CommandLineTask.values())
	    	assertThat(sysoutContent).contains(commandLineTask.getArgumentKey());
	    System.setOut(originalStream);
	}
}

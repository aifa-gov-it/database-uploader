package it.gov.aifa.invoice_processor.runner;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.AbstractIT;

public class CommandLineTaskIT extends AbstractIT{
	
	@Test
	public void checkTaskImplementationTest() throws Exception{
		for(CommandLineTask task : CommandLineTask.values()){
			assertThat(applicationContext.getBean(task.getCliRunnerClass())).isNotNull();
		}
	}
}
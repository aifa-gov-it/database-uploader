package it.gov.aifa.invoice_processor.runner.impl;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Properties;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.runner.CliRunner;
import it.gov.aifa.invoice_processor.runner.CommandLineTask;

public class CommandLineRunnerImplTest {
	
	@Test
	public void runFilenetFilesystemCrawlerTest() throws Exception{
		runTestForTask(CommandLineTask.JSON_TO_DB_UPLOADER);
	}
	
	private void runTestForTask(CommandLineTask task) throws Exception{
		CliRunner cliRunner = mock(task.getCliRunnerClass());
		ApplicationContext applicationContext = mock(ApplicationContext.class);
		when(applicationContext.getBean(task.getCliRunnerClass())).thenAnswer(new Answer<CliRunner>() {
			public CliRunner answer(InvocationOnMock invocation) {
		         return cliRunner;
		     }
		 });
		CommandLineRunner commandLineRunner = new CommandLineRunnerImpl(applicationContext);
		commandLineRunner.run(task.getArgumentKey());
		verify(applicationContext, times(1)).getBean(task.getCliRunnerClass());
		verify(cliRunner, times(1)).setArguments(any(Properties.class));
		verify(cliRunner, times(1)).run();
	}
}
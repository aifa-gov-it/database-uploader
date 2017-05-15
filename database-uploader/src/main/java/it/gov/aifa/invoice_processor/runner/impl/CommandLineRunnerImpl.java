package it.gov.aifa.invoice_processor.runner.impl;

import java.util.Properties;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import it.gov.aifa.invoice_processor.constant.CommandLineArgumentKey;
import it.gov.aifa.invoice_processor.runner.CliRunner;
import it.gov.aifa.invoice_processor.runner.CommandLineTask;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner{
	private ApplicationContext applicationContext;
	private static final Logger log = LoggerFactory.getLogger(CommandLineRunnerImpl.class);
	private Properties arguments;

	public CommandLineRunnerImpl(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public boolean checkIfShouldRun(String[] args, CommandLineTask task) throws Exception {
		String argumentKey = task.getArgumentKey();
		log.debug("Checking if {} runner should run.", argumentKey);
		return args != null
				&& (ArrayUtils.contains(args, argumentKey)
						|| (arguments != null && arguments.containsKey(argumentKey)));
	}

	@Override
	public void run(String... args) throws Exception {
		if(args != null && args.length > 0){
			log.debug("Processing command line arguments");
			arguments = StringUtils.splitArrayElementsIntoProperties(args, "=");
		}else
			args = new String[] { CommandLineArgumentKey.HELP };

		for(CommandLineTask task : CommandLineTask.values()){
			if(checkIfShouldRun(args, task)){
				log.debug("Running {} runner with args: {}", task.getArgumentKey(), args);
				if(task.getCliRunnerClass() != null) {
					CliRunner cliRunner = applicationContext.getBean(task.getCliRunnerClass());
					cliRunner.setArguments(arguments);
					cliRunner.run();
				}else
					log.debug("{} runner does not have a custom implementation so there is no need to instantiate it manually", task.getArgumentKey());
			}else{
				log.debug("Skipped {} runner.", task.getArgumentKey());
			}
		}
	}
}

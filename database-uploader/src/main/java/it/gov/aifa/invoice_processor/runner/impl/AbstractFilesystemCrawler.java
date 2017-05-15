package it.gov.aifa.invoice_processor.runner.impl;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.gov.aifa.invoice_processor.constant.CommandLineArgumentKey;

public abstract class AbstractFilesystemCrawler extends AbstractCliRunner {
	private static final Logger log = LoggerFactory.getLogger(AbstractFilesystemCrawler.class);
	
	@Override
	public void run(){
		String pathToCrawl = arguments.getProperty(CommandLineArgumentKey.PATH_WITH_PREFIX);
		if(StringUtils.isBlank(pathToCrawl))
			throw new IllegalArgumentException("Path to crawl argument cannot be null nor empty");
		log.info("Crawling {}", pathToCrawl);
		Path path = Paths.get(pathToCrawl);
		try (final Stream<Path> pathStream = Files.walk(path, FileVisitOption.FOLLOW_LINKS)) {
			pathStream
			.filter((p) -> !p.toFile().isDirectory())
			.forEach(p -> actionOnFile(p));
		} catch (final IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	protected abstract void actionOnFile(final Path file);
}
package it.gov.aifa.invoice_processor;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ActiveProfiles(profiles = { "embeddedDatabase"})
@SpringBootTest(
        classes = {ContextConfig.class}
        , properties = { "liquibase.change-log=db/changelog/db.changelog-integration-test-master.yaml" }
        ,webEnvironment = WebEnvironment.NONE
        )
public abstract class AbstractIT extends AbstractTestNGSpringContextTests{
    public AbstractIT() {
        super();
    }
}

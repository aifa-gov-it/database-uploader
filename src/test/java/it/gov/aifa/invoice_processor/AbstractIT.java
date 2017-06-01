package it.gov.aifa.invoice_processor;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SpringBootTest(
        classes = {ContextConfig.class}
        ,webEnvironment = WebEnvironment.NONE
        )
public abstract class AbstractIT extends AbstractTestNGSpringContextTests{
    public AbstractIT() {
        super();
    }
}

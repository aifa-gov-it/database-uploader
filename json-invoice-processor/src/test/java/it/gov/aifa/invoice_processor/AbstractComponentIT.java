package it.gov.aifa.invoice_processor;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public abstract class AbstractComponentIT extends AbstractIT {
	
	public AbstractComponentIT() {
		super();
	}
	
	@Test
	public void componentNotNullTest(){
		assertThat(getComponent()).isNotNull();
	}
	
	public abstract Object getComponent();

}
package it.gov.aifa.invoice_processor.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public abstract class AbstractEntityTest<T extends InvoiceProcessorEntity<String>> {
	
	protected abstract T buildEntityForIdTest();
	
	protected abstract int getExpectedIdValuesSize();
	
	@Test
	public void idValuesTest() throws Exception {
		T entity = buildEntityForIdTest();
		assertThat(entity.getIdValues()).doesNotContainNull();
		assertThat(entity.getIdValues()).hasSize(getExpectedIdValuesSize());
		for(String idValue : entity.getIdValues())
			assertThat(entity.getId()).contains(idValue);
	}
}

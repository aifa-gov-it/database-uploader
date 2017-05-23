package it.gov.aifa.invoice_processor.aspect;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import it.gov.aifa.invoice_processor.entity.InvoiceProcessorEntity;

@Aspect
public class UpdateEntityIdInterceptor {
	
	@AfterReturning(""
			+ "execution(public void set*(*))"
			+ " && !execution(public void setId(*))"
			+ " && within(it.gov.aifa.invoice_processor.entity..*)"
			+ " && target(it.gov.aifa.invoice_processor.entity.InvoiceProcessorEntity)"
			+ " && target(instance)"
			)
	public void updateEntityId(InvoiceProcessorEntity<String> instance) {
		StringBuilder builder = new StringBuilder();
		for(String idValue : instance.getIdValues())
			if(StringUtils.isNotBlank(idValue)) {
				builder.append(idValue);
				builder.append("_");
			}
		
		// Remove the last _
		builder.setLength(builder.length() - 1);
		
		instance.setId(builder.toString());
	}
}

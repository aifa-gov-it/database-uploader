package it.gov.aifa.invoice_processor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.Test;

import it.gov.aifa.invoice_processor.constant.CommandLineArgumentKey;
import it.gov.aifa.invoice_processor.constant.TestConstant;
import it.gov.aifa.invoice_processor.entity.invoice.Invoice;
import it.gov.aifa.invoice_processor.service.persistence.InvoiceRepository;

@TestPropertySource(properties = { CommandLineArgumentKey.IMPORT_INVOICES_WITH_PREFIX, CommandLineArgumentKey.PATH + "=" + TestConstant.TEST_DIRECTORY_PATH_INVOICE_XML })
public class ImportInvoiceJobIT extends AbstractIT{
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Test
	public void invoiceProcessTest() {
		Iterable<Invoice> invoices = invoiceRepository.findAll();
		List<Invoice> invoiceList = new ArrayList<>();
		invoices.forEach(m -> invoiceList.add(m));
		assertThat(invoiceList).hasSize(2);
		for(Invoice invoice : invoiceList) {
			assertThat(invoice.getInvoiceParticipants()).hasSize(3);
		}
	}
}

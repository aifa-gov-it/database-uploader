package it.gov.aifa.invoice_processor.entity.invoice;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import it.gov.aifa.invoice_processor.constant.DocumentoCorrelatoType;
import it.gov.aifa.invoice_processor.entity.AbstractEntityTest;

public class DocumentoCorrelatoTest extends AbstractEntityTest<DocumentoCorrelato>{

	@Override
	protected DocumentoCorrelato buildEntityForIdTest() {
		Invoice invoice = new Invoice("123456");
		Set<PurchaseLine> purchaseLines = new HashSet<>();
		purchaseLines.add(new PurchaseLine("10", invoice));
		return new DocumentoCorrelato(
				"cigCode"
				, "codiceCommessaConvenzione"
				, "codiceCUP"
				, Date.valueOf(LocalDate.parse("2017-05-30"))
				, DocumentoCorrelatoType.CONTRATTO
				, "documentId"
				, invoice
				, "numItem"
				, purchaseLines
				);
	}

	@Override
	protected int getExpectedIdValuesSize() {
		return 8;
	}
}

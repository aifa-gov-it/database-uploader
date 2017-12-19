package it.gov.aifa.invoice_processor.entity.invoice;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.validation.annotation.Validated;

import it.gov.aifa.invoice_processor.entity.impl.AbstractInvoiceReferenceEntity;

@Entity
@Table(name = "MEF_DATI_PAGAMENTO_FATTURA")
@Validated
public class DatiPagamento extends AbstractInvoiceReferenceEntity {
	private static final long serialVersionUID = 3928788589828828163L;
	
	private String beneficiarioPag;
	private String cfQuietanzantePag;
	private String codicePag;
	private String codUfficioPostalePag;
	private String cognomeQuietanzantePag;
	private Date dataDecorrenzaPenalePag;
    private Date dataLimitePagAnticipato;
    private Date dataRiferimentoTerminiPag;
    private String nomeQuietanzantePag;
    private BigDecimal paymentAmount;
    private String paymentConditions;
    private Date paymentExpirationDate;
    private String paymentMode;
    private Integer paymentTermDays;
    private BigDecimal penalitaPagamentiRitardati;
    private BigDecimal scontoPagAnticipatoPag;
    private String titoloQuietanzantePag;
	
    public DatiPagamento(Invoice invoice) {
        super(invoice);
    }
    
    @Override
	@Transient
	protected List<String> getAdditionalIdValues() {
		List<String> additionalIdValues = new ArrayList<>();
		additionalIdValues.add(paymentAmount.toString());
		return Collections.unmodifiableList(additionalIdValues);
	}
    
    public String getBeneficiarioPag() {
        return beneficiarioPag;
    }
    
    public String getCfQuietanzantePag() {
        return cfQuietanzantePag;
    }
    
    public String getCodicePag() {
        return codicePag;
    }
    
    public String getCodUfficioPostalePag() {
        return codUfficioPostalePag;
    }
    
    public String getCognomeQuietanzantePag() {
        return cognomeQuietanzantePag;
    }
    
    public Date getDataDecorrenzaPenalePag() {
        return dataDecorrenzaPenalePag;
    }
    
    public Date getDataLimitePagAnticipato() {
        return dataLimitePagAnticipato;
    }
    
    public Date getDataRiferimentoTerminiPag() {
        return dataRiferimentoTerminiPag;
    }
    
    public String getNomeQuietanzantePag() {
        return nomeQuietanzantePag;
    }
    
    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public String getPaymentConditions() {
        return paymentConditions;
    }

    public Date getPaymentExpirationDate() {
        return paymentExpirationDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public Integer getPaymentTermDays() {
        return paymentTermDays;
    }
    
    public BigDecimal getPenalitaPagamentiRitardati() {
        return penalitaPagamentiRitardati;
    }
    
    public BigDecimal getScontoPagAnticipatoPag() {
        return scontoPagAnticipatoPag;
    }
    
    public String getTitoloQuietanzantePag() {
        return titoloQuietanzantePag;
    }
    
    public void setBeneficiarioPag(String beneficiarioPag) {
        this.beneficiarioPag = beneficiarioPag;
    }

    public void setCfQuietanzantePag(String cfQuietanzantePag) {
        this.cfQuietanzantePag = cfQuietanzantePag;
    }
    
    public void setCodicePag(String codicePag) {
        this.codicePag = codicePag;
    }

    public void setCodUfficioPostalePag(String codUfficioPostalePag) {
        this.codUfficioPostalePag = codUfficioPostalePag;
    }
    
    public void setCognomeQuietanzantePag(String cognomeQuietanzantePag) {
        this.cognomeQuietanzantePag = cognomeQuietanzantePag;
    }
    
    public void setDataDecorrenzaPenalePag(Date dataDecorrenzaPenalePag) {
        this.dataDecorrenzaPenalePag = dataDecorrenzaPenalePag;
    }
    
    public void setDataLimitePagAnticipato(Date dataLimitePagAnticipato) {
        this.dataLimitePagAnticipato = dataLimitePagAnticipato;
    }
    
    public void setDataRiferimentoTerminiPag(Date dataRiferimentoTerminiPag) {
        this.dataRiferimentoTerminiPag = dataRiferimentoTerminiPag;
    }
    
    public void setNomeQuietanzantePag(String nomeQuietanzantePag) {
        this.nomeQuietanzantePag = nomeQuietanzantePag;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public void setPaymentConditions(String paymentConditions) {
        this.paymentConditions = paymentConditions;
    }

    public void setPaymentExpirationDate(Date paymentExpirationDate) {
        this.paymentExpirationDate = paymentExpirationDate;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public void setPaymentTermDays(Integer paymentTermDays) {
        this.paymentTermDays = paymentTermDays;
    }
    
    public void setPenalitaPagamentiRitardati(BigDecimal penalitaPagamentiRitardati) {
        this.penalitaPagamentiRitardati = penalitaPagamentiRitardati;
    }
    
    public void setScontoPagAnticipatoPag(BigDecimal scontoPagAnticipatoPag) {
        this.scontoPagAnticipatoPag = scontoPagAnticipatoPag;
    }
    
	public void setTitoloQuietanzantePag(String titoloQuietanzantePag) {
        this.titoloQuietanzantePag = titoloQuietanzantePag;
    }
}

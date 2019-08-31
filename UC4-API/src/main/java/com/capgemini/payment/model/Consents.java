package com.capgemini.payment.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CONSENTS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Consents implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
	@SequenceGenerator(name = "seq_gen", sequenceName = "mySeq", initialValue = 7401, allocationSize = 100)
	private Integer consentId;
	private String permission;
	private String status;
	private Timestamp creationDateTime;
	private Timestamp statusUpdateDateTime;
	private Timestamp requestedExecutionDate;
	private Double amount;
	private String currency;
	private String reference;
	private String unstructured;
	private String paymentContextCode;
	@OneToOne(cascade=CascadeType.REFRESH,fetch = FetchType.LAZY)
	@JoinColumn(name = "debtorId")
	private Account debtorAccount;
	@OneToOne(cascade=CascadeType.REFRESH,fetch = FetchType.LAZY)
	@JoinColumn(name = "creditorId")
	private Account creditorAccount;

	public Integer getConsentId() {
		return consentId;
	}

	public void setConsentId(Integer consentId) {
		this.consentId = consentId;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(Timestamp creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public Timestamp getStatusUpdateDateTime() {
		return statusUpdateDateTime;
	}

	public void setStatusUpdateDateTime(Timestamp statusUpdateDateTime) {
		this.statusUpdateDateTime = statusUpdateDateTime;
	}

	public Timestamp getRequestedExecutionDate() {
		return requestedExecutionDate;
	}

	public void setRequestedExecutionDate(Timestamp requestedExecutionDate) {
		this.requestedExecutionDate = requestedExecutionDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getUnstructured() {
		return unstructured;
	}

	public void setUnstructured(String unstructured) {
		this.unstructured = unstructured;
	}

	public String getPaymentContextCode() {
		return paymentContextCode;
	}

	public void setPaymentContextCode(String paymentContextCode) {
		this.paymentContextCode = paymentContextCode;
	}

	public Account getDebtorAccount() {
		return debtorAccount;
	}

	public void setDebtorAccount(Account debtorAccount) {
		this.debtorAccount = debtorAccount;
	}

	public Account getCreditorAccount() {
		return creditorAccount;
	}

	public void setCreditorAccount(Account creditorAccount) {
		this.creditorAccount = creditorAccount;
	}

}

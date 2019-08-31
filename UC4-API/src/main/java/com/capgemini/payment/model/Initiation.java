package com.capgemini.payment.model;

import java.sql.Timestamp;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Initiation {
	@NotNull(message = "requestedExecutionDate is mandatory field")
	private Timestamp requestedExecutionDate;
	@Valid
	private InstructedAmount instructedAmount;
	@Valid
	private Account debtorAccount;
	@Valid
	private Account creditorAccount;
	@Valid
	private RemittanceInformation remittanceInformation;

	public Initiation() {
		super();
	}

	public Initiation(Timestamp requestedExecutionDate, InstructedAmount instructedAmount, Account debtorAccount,
			Account creditorAccount, RemittanceInformation remittanceInformation) {
		super();
		this.requestedExecutionDate = requestedExecutionDate;
		this.instructedAmount = instructedAmount;
		this.debtorAccount = debtorAccount;
		this.creditorAccount = creditorAccount;
		this.remittanceInformation = remittanceInformation;
	}

	public Timestamp getRequestedExecutionDate() {
		return requestedExecutionDate;
	}

	public void setRequestedExecutionDate(Timestamp requestedExecutionDate) {
		this.requestedExecutionDate = requestedExecutionDate;
	}

	public InstructedAmount getInstructedAmount() {
		return instructedAmount;
	}

	public void setInstructedAmount(InstructedAmount instructedAmount) {
		this.instructedAmount = instructedAmount;
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

	public RemittanceInformation getRemittanceInformation() {
		return remittanceInformation;
	}

	public void setRemittanceInformation(RemittanceInformation remittanceInformation) {
		this.remittanceInformation = remittanceInformation;
	}

}

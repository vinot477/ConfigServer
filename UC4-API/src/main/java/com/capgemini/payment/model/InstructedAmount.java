package com.capgemini.payment.model;

import javax.validation.constraints.NotNull;

public class InstructedAmount {
	@NotNull(message="amount is mandatory field")
	private Double amount;
	@NotNull(message="currency is mandatory field")
	private String currency;

	public InstructedAmount() {
		super();
	}

	public InstructedAmount(Double amount, String currency) {
		super();
		this.amount = amount;
		this.currency = currency;
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

}

package com.capgemini.payment.model;

import javax.validation.constraints.NotNull;

public class Risk {
	@NotNull(message="paymentContextCode is mandatory field")
	private String paymentContextCode;

	public Risk() {
		super();
	}

	public Risk(String paymentContextCode) {
		super();
		this.paymentContextCode = paymentContextCode;
	}

	public String getPaymentContextCode() {
		return paymentContextCode;
	}

	public void setPaymentContextCode(String paymentContextCode) {
		this.paymentContextCode = paymentContextCode;
	}

}

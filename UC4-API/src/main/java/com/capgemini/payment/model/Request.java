package com.capgemini.payment.model;

import javax.validation.Valid;


public class Request {
	@Valid
	private Data data;
	@Valid
	private Risk risk;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Risk getRisk() {
		return risk;
	}

	public void setRisk(Risk risk) {
		this.risk = risk;
	}
}

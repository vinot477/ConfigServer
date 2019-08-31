package com.capgemini.payment.model;

import javax.validation.constraints.NotNull;


public class RemittanceInformation {
	@NotNull(message="reference is mandatory field")
	private String reference;
	@NotNull(message="unstructured is mandatory field")
	private String unstructured;

	public RemittanceInformation() {
		super();
	}

	public RemittanceInformation(String reference, String unstructured) {
		super();
		this.reference = reference;
		this.unstructured = unstructured;
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

}

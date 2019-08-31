package com.capgemini.payment.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull(message = "schemeName is mandatory")
	private String schemeName;
	@Id
	@Pattern(regexp = "[0-9]{14}", message = "identification should be of 14 digits")
	private String identification;
	@NotNull(message = "schemeName is mandatory")
	private String name;

	public Account() {
		super();
	}

	public Account(String schemeName, String identification, String name) {
		super();
		this.schemeName = schemeName;
		this.identification = identification;
		this.name = name;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

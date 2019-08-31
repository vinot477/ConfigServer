package com.capgemini.payment.model;

import java.sql.Timestamp;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


public class Data {

	private Integer consentId;
	@NotNull(message="permission is mandatory field")
	private String permission;
	private String status;
	private Timestamp creationDateTime;
	private Timestamp statusUpdateDateTime;
	@Valid
	private Initiation initiation;

	public Data() {
		super();
	}

	public Data(Integer consentId, String permission, String status, Timestamp creationDateTime,
			Timestamp statusUpdateDateTime, Initiation initiation) {
		super();
		this.consentId = consentId;
		this.permission = permission;
		this.status = status;
		this.creationDateTime = creationDateTime;
		this.statusUpdateDateTime = statusUpdateDateTime;
		this.initiation = initiation;
	}

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

	public Initiation getInitiation() {
		return initiation;
	}

	public void setInitiation(Initiation initiation) {
		this.initiation = initiation;
	}
}

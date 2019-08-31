package com.capgemini.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomPaymentException extends RuntimeException {
	public CustomPaymentException(String exception) {
	    super(exception);
	  }
}

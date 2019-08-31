package com.capgemini.payment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.payment.Repository.PaymentRepository;
import com.capgemini.payment.model.Request;

@RestController
@RefreshScope
@Validated
public class PaymentsController {
	@Autowired
	private PaymentRepository paymentRepository;

	@PostMapping(value = "/domestic-scheduled-payment-consents", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Request> savePayment(@Valid @RequestBody Request request) {
		Request response = paymentRepository.savePayment(request);
		System.out.println("payments controller");
		return new ResponseEntity<Request>(response, HttpStatus.CREATED);

	}

	@GetMapping(value = "/app-name")
	public void getApplicationName() {
		System.out.print("PaymentsController******App Name ********"+name);
	}

	@Value("${spring.application.name:Default}")
	private String name;

}

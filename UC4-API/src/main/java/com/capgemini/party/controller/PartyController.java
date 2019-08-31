package com.capgemini.party.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.party.configuration.PartyClient;
import com.capgemini.payment.exception.CustomPaymentException;
import com.party.GetPartyRequest;
import com.party.GetPartyResponse;
	
@RestController
@Validated
public class PartyController {
	@Autowired
	public PartyClient partyClient;

	@RequestMapping(value = "/party", produces = "application/json")
	public ResponseEntity<GetPartyResponse> getPartyDetails(
			@Valid @Pattern(regexp = "[0-9]+", message = "accountId should be of digits only") @NotBlank(message = "accountId cannot not be blank or null") @RequestParam(value = "accountId", required = true) String accountId) {
		GetPartyRequest request=new GetPartyRequest();
		GetPartyResponse response=new GetPartyResponse();
		request.setAccountid(accountId);
		try {
		 response = (GetPartyResponse) partyClient
				.callWebService("http://partydetailssoap.cfapps.io:80/ws", request);}
		catch(Exception ex) {
			throw new CustomPaymentException("Party Details not found for the accound Id :"+accountId);
		}
		
			return new ResponseEntity<GetPartyResponse>(response, HttpStatus.OK);
		
	}
}

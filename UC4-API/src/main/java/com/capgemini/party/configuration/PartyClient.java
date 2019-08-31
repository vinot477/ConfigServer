package com.capgemini.party.configuration;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class PartyClient extends WebServiceGatewaySupport {
	 public Object callWebService(String url, Object request){
	        return getWebServiceTemplate().marshalSendAndReceive(url, request);
	    }
}

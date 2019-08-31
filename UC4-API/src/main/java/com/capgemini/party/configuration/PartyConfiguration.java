package com.capgemini.party.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class PartyConfiguration {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();		
		marshaller.setContextPath("com.party");
		return marshaller;
	}
	
	@Bean
	public PartyClient partyClient(Jaxb2Marshaller marshaller) {
		PartyClient client = new PartyClient();
		client.setDefaultUri("http://partydetailssoap.cfapps.io:80/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}

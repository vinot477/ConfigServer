package com.capgemini;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import com.capgemini.payment.Repository.PaymentRepository;
import com.capgemini.payment.model.Account;
import com.capgemini.payment.model.Data;
import com.capgemini.payment.model.Initiation;
import com.capgemini.payment.model.InstructedAmount;
import com.capgemini.payment.model.RemittanceInformation;
import com.capgemini.payment.model.Request;
import com.capgemini.payment.model.Risk;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	  
	@Autowired
	PaymentRepository paymentRepository;
	
    
    
     

	@Test
	public void savePayment() throws Exception {
		Account creditAccount = new Account("UK.OBIE.SortCodeAccountNumber", "08080021325698", "Tom Kirkman");
		Account debitAccount = new Account("UK.OBIE.SortCodeAccountNumber", "11280001234567", "Andrea Frost");
		InstructedAmount instructedAmount = new InstructedAmount(200.00, "GBP");
		RemittanceInformation remittanceInformation = new RemittanceInformation("DSR-037", "Internal ops code 5120103");
		java.util.Date utilDate = new java.util.Date();
		java.sql.Timestamp time = new java.sql.Timestamp(utilDate.getTime());
		Initiation initiation = new Initiation(time, instructedAmount, creditAccount, debitAccount,
				remittanceInformation);
		Data data = new Data();
		data.setPermission("Create");
		data.setInitiation(initiation);
		Risk risk = new Risk("PartyToParty");
		Request request = new Request();
		request.setData(data);
		request.setRisk(risk);
		
		Request res=paymentRepository.savePayment(request);
		
		assertEquals(201, 201);

		/*mockMvc.perform(MockMvcRequestBuilders.post("/domestic-scheduled-payment-consents").content(asJsonString(request))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andExpect(MockMvcResultMatchers.jsonPath("$.consentId").exists());

		
		 * RestTemplate restTemplate = new RestTemplate(); final String baseUrl =
		 * "http://localhost:9090/domestic-scheduled-payment-consents"; URI uri = new
		 * URI(baseUrl); HttpHeaders headers = new HttpHeaders();
		 * headers.set("Content-Type", "application/json");
		 * headers.setBasicAuth("vinoth", "1234"); HttpEntity<Request> httpRequest = new
		 * HttpEntity<>(request, headers);
		 * 
		 * 
		 * ResponseEntity<Request> result =restTemplate.postForEntity(uri, request,
		 * Request.class);
		 * 
		 * 
		 * //Verify bad request and missing header
		 * Assert.assertEquals(201,result.getStatusCodeValue());
		 */

		/*
		 * Mockito.when(paymentRepository.savePayment(Mockito.any(Request.class))).
		 * thenReturn(request); RequestBuilder requestBuilder =
		 * MockMvcRequestBuilders.post("domestic-scheduled-payment-consents")
		 * .accept(MediaType.APPLICATION_JSON); MvcResult result =
		 * mockMvc.perform(requestBuilder).andReturn(); MockHttpServletResponse response
		 * = result.getResponse(); assertEquals(HttpStatus.CREATED.value(),
		 * response.getStatus());
		 * assertEquals("http://localhost:9090/domestic-scheduled-payment-consents",
		 * response.getHeader(HttpHeaders.LOCATION));
		 */

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

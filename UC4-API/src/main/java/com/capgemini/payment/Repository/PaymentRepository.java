package com.capgemini.payment.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.payment.model.Account;
import com.capgemini.payment.model.Consents;
import com.capgemini.payment.model.Request;

@Repository
public class PaymentRepository {
	private static Logger logger = LoggerFactory.getLogger(PaymentRepository.class);

	@Autowired
	private ConsentsRepository consentsRepository;

	@Autowired
	private AccountRepository accountRepository;

	public Request savePayment(Request request) {
		logger.info("*************Posting Data for domestic Payments****************");

		Consents consents = setRequestToConsents(request);
		Account creditorAcc = accountRepository.save(request.getData().getInitiation().getCreditorAccount());
		Account debtorAcc = accountRepository.save(request.getData().getInitiation().getDebtorAccount());
		consents.setCreditorAccount(creditorAcc);
		consents.setDebtorAccount(debtorAcc);
		Consents responseConsents = consentsRepository.save(consents);

		request.getData().setConsentId(responseConsents.getConsentId());

		logger.info("*************Payments saved successfully**********************");

		Request response = new Request();
		response.setData(request.getData());
		response.setRisk(request.getRisk());
		return response;

	}

	public Consents setRequestToConsents(Request request) {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Timestamp time = new java.sql.Timestamp(utilDate.getTime());
		request.getData().setCreationDateTime(time);
		request.getData().setStatusUpdateDateTime(time);
		request.getData().setStatus("AwaitingAuthorisation");
		Consents consents = new Consents();
		consents.setPermission(request.getData().getPermission());
		consents.setStatus(request.getData().getStatus());
		consents.setCreationDateTime(request.getData().getCreationDateTime());
		consents.setStatusUpdateDateTime(request.getData().getStatusUpdateDateTime());
		consents.setRequestedExecutionDate(request.getData().getInitiation().getRequestedExecutionDate());
		consents.setAmount(request.getData().getInitiation().getInstructedAmount().getAmount());
		consents.setCurrency(request.getData().getInitiation().getInstructedAmount().getCurrency());
		consents.setReference(request.getData().getInitiation().getRemittanceInformation().getReference());
		consents.setUnstructured(request.getData().getInitiation().getRemittanceInformation().getUnstructured());
		consents.setPaymentContextCode(request.getRisk().getPaymentContextCode());
		return consents;
	}

}

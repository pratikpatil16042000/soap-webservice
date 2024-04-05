package com.example.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.loaneligibility.Acknowledgement;
import com.example.demo.loaneligibility.CustomerRequest;
import com.example.demo.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {
	
	private static final String NAMESPACE = "http://www.example.com/demo/loanEligibility";
	
	@Autowired
	private LoanEligibilityService service;
	
	@PayloadRoot(namespace = NAMESPACE,localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest req) {
		return service.checkLoanEligibility(req);
	}
	
	
}

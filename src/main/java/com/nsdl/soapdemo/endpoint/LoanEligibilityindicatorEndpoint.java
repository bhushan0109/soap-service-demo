package com.nsdl.soapdemo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.nsdl.soapdemo.api.loaneligibility.Acknowledgement;
import com.nsdl.soapdemo.api.loaneligibility.CustomerRequest;
import com.nsdl.soapdemo.service.LoanEligibilityService;



@Endpoint
public class LoanEligibilityindicatorEndpoint {

	private static final String NAMESPACE = "http://www.nsdl.com/soapdemo/api/loanEligibility";
	// ----------------------------- this above url in xsd file copy that one first paste above
	@Autowired
	private LoanEligibilityService service;

	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	//---------------------------------------------- above local part is customer request
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		return service.checkLoanEligibility(request);
	}

}

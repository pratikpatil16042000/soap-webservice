package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.loaneligibility.Acknowledgement;
import com.example.demo.loaneligibility.CustomerRequest;

@Service
public class LoanEligibilityService {
	
	public Acknowledgement checkLoanEligibility(CustomerRequest req) {
		Acknowledgement acknowledgement = new Acknowledgement();
		List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();
		
		if(!(req.getAge()>30 && req.getAge()<60)) {
			mismatchCriteriaList.add("Person age should be between 30 and 60");
		}
		if(!(req.getYearlyIncome()>=200000)) {
			mismatchCriteriaList.add("minimum income should be 200000");
		}
		if(!(req.getCibilScore()>=500)) {
			mismatchCriteriaList.add("Low Cibil Score, please try after 6 months");
		}
		if(mismatchCriteriaList.size()>0) {
			acknowledgement.setApprovedAmount(0);
			acknowledgement.setIsEligible(false);
		}
		else {
			acknowledgement.setApprovedAmount(500000);
			acknowledgement.setIsEligible(true);
			mismatchCriteriaList.clear();
		}
		return acknowledgement;
		
	}

}

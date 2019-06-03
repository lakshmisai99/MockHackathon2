package com.ing.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ing.domain.BankInfo;
import com.ing.domain.CustomerInfo;
import com.ing.service.TransactionService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin
@RestController
@EnableSwagger2
@RequestMapping("api/")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	Optional<BankInfo> bankinfo;
	

	
	@RequestMapping(value = "/transferAmount", method = RequestMethod.POST, consumes = "application/json")
	public BankInfo transferAmount(@RequestBody BankInfo bankInfo) {
		
		return transactionService.getCustomerBankAcc(bankInfo.getCustId(), bankInfo.getAmount(),bankInfo.getToCustId());
		
		
	}

}

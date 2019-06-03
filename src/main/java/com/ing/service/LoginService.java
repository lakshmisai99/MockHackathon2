package com.ing.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.domain.BankInfo;
import com.ing.domain.CustomerInfo;
import com.ing.repository.CreateRepository;
import com.ing.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;

	@Autowired 
	CreateRepository createRepository;
	
	
	public CustomerInfo login(int custId, String password, String role) {
		// TODO Auto-generated method stub
		
		CustomerInfo cust=new CustomerInfo();
		try {
		
		CustomerInfo customerInfo = loginRepository.findByCustId(custId);
		
		if (customerInfo.getCustId() == custId && customerInfo.getPassword().equals(password)
				&& customerInfo.getRole().equals(role)) {
			customerInfo.setMessage("Success Login");
			customerInfo.setSuccess("true");
			return customerInfo;

		} else {

			customerInfo.setMessage("Invalid Login");
			customerInfo.setSuccess("false");

			return customerInfo;
		}
		}catch(NullPointerException e) {
			cust.setMessage("Invalid Login");
			cust.setSuccess("false");
			cust.setCustId(custId);
			return cust;
			
		}
		// return null;
	}

	public BankInfo createAccount(CustomerInfo customerInfo) {
		// TODO Auto-generated method stub
		
		Random r = new Random( System.currentTimeMillis() );
		int accid= ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
		BankInfo bankInfo=new BankInfo(accid,accid,(double) 1000,new Date(),"Saving");
		customerInfo.setCustId(accid);
		customerInfo.setPassword("test");	
		customerInfo.setRole("customer");
		loginRepository.save(customerInfo);
		BankInfo returnObj=createRepository.save(bankInfo);
		returnObj.setMessage("Account created successfully for "+customerInfo.getName());
		returnObj.setSuccess("true");
		return returnObj;
	}

	public BankInfo getAccountInfo(BankInfo bankInput) {
		BankInfo bankInput1 = createRepository.findByCustId(bankInput.getCustId());
		CustomerInfo customerInfo = loginRepository.findByCustId(bankInput.getCustId());
		bankInput1.setName(customerInfo.getName());
		// TODO Auto-generated method stub
		return bankInput1;
	}

}

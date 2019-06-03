package com.ing.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.domain.BankInfo;
import com.ing.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionrepo;

	public BankInfo getCustomerBankAcc(int custId, Double amt, int toCustId) {
		//System.out.println("!!!!!__________--------------------------------------");
		Double acc_balance = null;
		Double to_balance = null;
		BankInfo bankinfo = transactionrepo.findByCustId(custId);
		BankInfo toBankinfo = transactionrepo.findByCustId(toCustId);
		 //System.out.println("toBankinfo "+toBankinfo);

		to_balance = toBankinfo.getBalance() + amt;
		acc_balance = bankinfo.getBalance() - amt;

		toBankinfo.setCustId(toCustId);
		toBankinfo.setBalance(to_balance);
		
		bankinfo.setCustId(custId);
		bankinfo.setBalance(acc_balance);
		transactionrepo.save(toBankinfo);
		transactionrepo.save(bankinfo);

		return bankinfo;
	}

}

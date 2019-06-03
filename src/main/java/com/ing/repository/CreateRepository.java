package com.ing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.domain.BankInfo;
import com.ing.domain.CustomerInfo;

public interface CreateRepository extends JpaRepository<BankInfo, Integer>{

	
	BankInfo findByCustId(int custId);
}

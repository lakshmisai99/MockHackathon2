package com.ing.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.domain.BankInfo;
import com.ing.domain.CustomerInfo;

@Repository
public interface TransactionRepository extends JpaRepository<BankInfo, Integer>{

	//void save(Optional<BankInfo> bankinfo);
	
	BankInfo findByCustId(int custId);
	
}

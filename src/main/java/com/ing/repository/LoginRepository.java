package com.ing.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.ing.domain.CustomerInfo;


@Repository
public interface LoginRepository extends JpaRepository<CustomerInfo, Integer>{
	
	CustomerInfo findByCustId(int custId);
}

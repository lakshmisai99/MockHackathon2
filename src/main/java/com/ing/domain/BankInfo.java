package com.ing.domain;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Bank_Acc")
public class BankInfo {

	@Id
	
	private int accid;
	@Column(name="custId")
	private int custId;
	private Double balance;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime=new Date();
	private String type;
	
	@Transient
	private Double amount;
	
	@Transient
	private String name;
	
	
	@Transient
	private int toCustId;
	
	@Transient
	String message ;
	@Transient
	String success;
	
	
	
	public int getToCustId() {
		return toCustId;
	}

	public void setToCustId(int toCustId) {
		this.toCustId = toCustId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public BankInfo() {}
	
	public BankInfo(int accid, int custId, Double balance, Date dateTime, String type) {
		super();
		this.accid = accid;
		this.custId = custId;
		this.balance = balance;
		this.dateTime = dateTime;
		this.type = type;
	}
	public int getAccid() {
		return accid;
	}
	public void setAccid(int accid) {
		this.accid = accid;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	} 
	
	
	
	
		
	
}

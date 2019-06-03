package com.ing.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "Customer_Info")
public class CustomerInfo {
	
	@Id
	
	private int custId ;
	@Column(name="custname")
	private String name;
	private String password;
	private String pan;
	private String aadhar;
	private String gender;
	private String email;
	@Column(name="phone")
	private String phoneNo;
	private String role;
	
	@Transient
	String message ;
	@Transient
	String success;
	
	
	
	
	public CustomerInfo(String name, String password, String pan, String aadhar, String gender, String email,
			String phoneNo, String role) {
		super();
		this.name = name;
		this.password = password;
		this.pan = pan;
		this.aadhar = aadhar;
		this.gender = gender;
		this.email = email;
		this.phoneNo = phoneNo;
		this.role = role;
	}



	public CustomerInfo(int custId, String password, String role) {
		super();
		this.custId = custId;
		this.password = password;
		this.role = role;
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



	public CustomerInfo() {
		super();
	}



	public int getCustId() {
		return custId;
	}



	public void setCustId(int custId) {
		this.custId = custId;
	}






	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPan() {
		return pan;
	}



	public void setPan(String pan) {
		this.pan = pan;
	}



	public String getAadhar() {
		return aadhar;
	}



	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}





	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPhoneNo() {
		return phoneNo;
	}



	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	}

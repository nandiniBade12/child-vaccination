package com.capg.ChildVaccination.Dto;

public class ParentDto {
	
	private String userName;
	private String password;
	private String email;
	private String address;
	private long mobileNo;
	
	
	
	public ParentDto(String userName, String password, String email, String address, long mobileNo) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.mobileNo = mobileNo;
	}
	public ParentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	

}

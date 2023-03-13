package com.capg.ChildVaccination.Dto;

public class AdminDto {
	
private String adminName;
	
	private String email;
	
	private String password;
	
	private String mobileNumber;

	public AdminDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminDto(String adminName, String email, String password, String mobileNumber) {
		super();
		this.adminName = adminName;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	
}

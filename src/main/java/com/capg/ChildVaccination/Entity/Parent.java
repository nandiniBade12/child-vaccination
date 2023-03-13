package com.capg.ChildVaccination.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Parent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int parentid;
	private String userName;
	private String password;
	private String email;
	private String address;
	private long mobileNo;
	
	
	
	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	




	public Parent(int parentid, String userName, String password, String email, String address, long mobileNo
			) {
		super();
		this.parentid = parentid;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.mobileNo = mobileNo;
		
	}



	public int getUserId() {
		return parentid;
	}
	public void setUserId(int userId) {
		this.parentid = userId;
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







	public int getParentid() {
		return parentid;
	}







	public void setParentid(int parentid) {
		this.parentid = parentid;
	}







	
	
	
	

}

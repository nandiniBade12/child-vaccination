package com.capg.ChildVaccination.Entity;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;





@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String adminName;
	
	@NotEmpty(message="Please Enter a Password")
	@Length(min=6,max=20)
	private String password;
	
	private String mobileNumber;
	
	@Email(message="Enter valid email address")
	private String email;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String adminName, String password, String mobileNumber, String email) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName + ", password=" + password + ", mobileNumber="
				+ mobileNumber + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adminName, email, id, mobileNumber, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(adminName, other.adminName) && Objects.equals(email, other.email) && id == other.id
				&& mobileNumber == other.mobileNumber && Objects.equals(password, other.password);
	}
	
	
	

}

package com.capg.ChildVaccination.Dto;


public class BookingDto {
	
	//private float bill;
	
	private int hospitalId;
	
	private String userName;
	
	private int vaccineId;

	public BookingDto() {
		super();
	}

	
public BookingDto(int hospitalId, String userName, int vaccineId) {
		super();
		this.hospitalId = hospitalId;
		this.userName = userName;
		this.vaccineId = vaccineId;
	}


//	public float getBill() {
//		return bill;
//	}
//
//	public void setBill(float bill) {
//		this.bill = bill;
//	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}
	
	

}


package com.capg.ChildVaccination.Dto;

public class HospitalDto {
	
	private String hospitalName;
	private String hospitalAddress;
	private String startingTime;
	private String endingTime;
	
	
	public HospitalDto(String hospitalName, String address, String startingTime, String endingTime) {
		super();
		this.hospitalName = hospitalName;
		hospitalAddress = address;
		this.startingTime = startingTime;
		this.endingTime = endingTime;
	}
	public HospitalDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public void setStartingTime(String startingTime) {
		this.startingTime = startingTime;
	}
	public String getEndingTime() {
		return endingTime;
	}
	public void setEndingTime(String endingTime) {
		this.endingTime = endingTime;
	}
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}
	public String getStartingTime() {
		return startingTime;
	}
	
	
	

}

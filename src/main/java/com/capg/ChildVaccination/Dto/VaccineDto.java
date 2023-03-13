package com.capg.ChildVaccination.Dto;

public class VaccineDto {
	
	private String vaccineName;
	private String vaccineDescription;
	private int agelimit;
	private int totaldoses;	
	private float price;
	private String hospitalName;
	public VaccineDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public VaccineDto(String vaccineName, String vaccineDescription, int agelimit, int totaldoses, float price,
			String hospitalName) {
		super();
		this.vaccineName = vaccineName;
		this.vaccineDescription = vaccineDescription;
		this.agelimit = agelimit;
		this.totaldoses = totaldoses;
		this.price = price;
		this.hospitalName = hospitalName;
	}

	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	public String getVaccineDescription() {
		return vaccineDescription;
	}
	public void setVaccineDescription(String vaccineDescription) {
		this.vaccineDescription = vaccineDescription;
	}
	public int getAgelimit() {
		return agelimit;
	}
	public void setAgelimit(int agelimit) {
		this.agelimit = agelimit;
	}
	public int getTotaldoses() {
		return totaldoses;
	}
	public void setTotaldoses(int totaldoses) {
		this.totaldoses = totaldoses;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	
	

}

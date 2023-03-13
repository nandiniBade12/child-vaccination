package com.capg.ChildVaccination.Dto;

public class VaccineDto2 {
	private String vaccineName;
	private String vaccineDescription;
	private int agelimit;
	private int totaldoses;	
	private float price;
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
	
	
}

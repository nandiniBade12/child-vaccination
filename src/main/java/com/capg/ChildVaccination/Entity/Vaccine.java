package com.capg.ChildVaccination.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Vaccine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vaccineId;
	private String vaccineName;
	private String vaccineDescription;
	private int agelimit;
	private int totaldoses;	
	private float price;
	
	@ManyToOne
	@JoinColumn(name = "hospitalid")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Hospital hospital;
	
	public Vaccine() {
		super();
		
	}	
	
	public Vaccine(int vaccineId, String vaccineName, String vaccineDescription, int agelimit, int totaldoses,
			float price, Hospital hospital) {
		super();
		this.vaccineId = vaccineId;
		this.vaccineName = vaccineName;
		this.vaccineDescription = vaccineDescription;
		this.agelimit = agelimit;
		this.totaldoses = totaldoses;
		this.price = price;
		this.hospital = hospital;
	}

	public int getVaccineId() {
		return vaccineId;
	}
	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
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
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}	
	

}

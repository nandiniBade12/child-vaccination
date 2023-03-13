package com.capg.ChildVaccination.Entity;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int hospitalid;
	private String hospitalName;
	private String hospitalAddress;
	
	private LocalTime startingTime;
	
//	@OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = false)
//	@JsonProperty("Vaccines")
//	private List<Vaccine> vaccines;
	
	
	private LocalTime endingTime;
	public Hospital() {
		super();
		
	}
	
	




	public Hospital(int hospitalid, String hospitalName, String hospitalAddress, LocalTime startingTime,
			 LocalTime endingTime) {
		super();
		this.hospitalid = hospitalid;
		this.hospitalName = hospitalName;
		this.hospitalAddress = hospitalAddress;
		this.startingTime = startingTime;
		//this.vaccines = vaccines;
		this.endingTime = endingTime;
	}











	public int getHospitalid() {
		return hospitalid;
	}
	public void setHospitalid(int hospitalid) {
		this.hospitalid = hospitalid;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}





	public LocalTime getStartingTime() {
		return startingTime;
	}





	public void setStartingTime(LocalTime t1) {
		this.startingTime = t1;
	}





	public LocalTime getEndingTime() {
		return endingTime;
	}





	public void setEndingTime(LocalTime t2) {
		this.endingTime = t2;
	}





//	public List<Vaccine> getVaccines() {
//		return vaccines;
//	}
//
//
//
//
//
//	public void setVaccines(List<Vaccine> vaccines) {
//		this.vaccines = vaccines;
//	}
	
	
	
	
}

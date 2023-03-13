package com.capg.ChildVaccination.Entity;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="booking_id")
	private int bookingId;
	
	@Column(name="childname")
	private String name;
	
	@Column(name="bill")
	private float bill;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hospitalid", referencedColumnName = "hospitalId")
	private Hospital hospital;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parentid", referencedColumnName = "parentId")
	private Parent parent;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vaccineid", referencedColumnName = "vaccineId")
	private Vaccine vaccine;
	
	@Column(name="time")
	private LocalTime billingTime = LocalTime.now();
	//System.out.println(billingTime);
	
	@Column(name="date")
	private LocalDate billingDate = LocalDate.now();
	//System.out.println(billingDate);

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Booking(int bookingId, String name, float bill, Hospital hospital, Parent parent, Vaccine vaccine,
			LocalTime billingTime, LocalDate billingDate) {
		super();
		this.bookingId = bookingId;
		this.name = name;
		this.bill = bill;
		this.hospital = hospital;
		this.parent = parent;
		this.vaccine = vaccine;
		this.billingTime = billingTime;
		this.billingDate = billingDate;
	}



	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBill() {
		return bill;
	}

	public void setBill(float bill) {
		this.bill = bill;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public LocalTime getBillingTime() {
		return billingTime;
	}

	public void setBillingTime(LocalTime billingTime) {
		this.billingTime = billingTime;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}
	
}
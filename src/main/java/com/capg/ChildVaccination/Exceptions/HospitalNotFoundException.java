package com.capg.ChildVaccination.Exceptions;

@SuppressWarnings("serial")
public class HospitalNotFoundException  extends RuntimeException{
	
	public HospitalNotFoundException(String msg) {
		super(msg);
	}

}

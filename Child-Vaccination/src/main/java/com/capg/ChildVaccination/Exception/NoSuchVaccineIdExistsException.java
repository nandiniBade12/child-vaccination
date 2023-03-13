package com.capg.ChildVaccination.Exception;

@SuppressWarnings("serial")
public class NoSuchVaccineIdExistsException extends RuntimeException{
	
	public NoSuchVaccineIdExistsException() {
	}	
	public NoSuchVaccineIdExistsException(String msg) {
		super(msg);
	}
}



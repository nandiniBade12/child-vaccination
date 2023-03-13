package com.capg.ChildVaccination.Exceptions;

@SuppressWarnings("serial")
public class VaccineIdAlreadyExistsException extends RuntimeException {

	public VaccineIdAlreadyExistsException()
	{
	
	}		
	public VaccineIdAlreadyExistsException(String msg) {
			super(msg);
			
		}
}

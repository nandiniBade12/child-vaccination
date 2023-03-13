package com.capg.ChildVaccination.Exception;
@SuppressWarnings("serial")
public class VaccineIdAlreadyExistsException extends RuntimeException {

	public VaccineIdAlreadyExistsException()
	{
	
	}		
	public VaccineIdAlreadyExistsException(String msg) {
			super(msg);
			
		}
}

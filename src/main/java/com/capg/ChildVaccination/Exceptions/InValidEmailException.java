package com.capg.ChildVaccination.Exceptions;

@SuppressWarnings("serial")
public class InValidEmailException extends RuntimeException{
	
	public InValidEmailException(String msg) {
		super(msg);
	}
}
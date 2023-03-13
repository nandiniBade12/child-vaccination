package com.capg.ChildVaccination.Exceptions;

@SuppressWarnings("serial")
public class ParentAlreadyExistsException extends RuntimeException{
	
	public ParentAlreadyExistsException(String msg) {
		super(msg);
	} 
}

package com.capg.ChildVaccination.Exceptions;

@SuppressWarnings("serial")
public class AdminNotExistException extends RuntimeException{
	
	public AdminNotExistException(String msg) {
		super(msg);
	}
}

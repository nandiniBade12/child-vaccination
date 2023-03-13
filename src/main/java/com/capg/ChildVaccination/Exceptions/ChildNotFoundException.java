package com.capg.ChildVaccination.Exceptions;

@SuppressWarnings("serial")
public class ChildNotFoundException extends RuntimeException{
	public ChildNotFoundException(String msg) {
	super(msg);
	}
}

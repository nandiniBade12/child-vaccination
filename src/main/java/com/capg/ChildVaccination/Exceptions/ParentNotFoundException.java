package com.capg.ChildVaccination.Exceptions;

@SuppressWarnings("serial")
public class ParentNotFoundException extends RuntimeException {
	
	public ParentNotFoundException(String msg) {
		super(msg);
	}
}

package com.capg.ChildVaccination.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capg.ChildVaccination.Dto.ErrorResponse;

@ControllerAdvice
public class MainExceptionHandler {
	
	@ExceptionHandler(AdminNotExistException.class)
	public ResponseEntity<ErrorResponse> handleException(AdminNotExistException e){
		
		ErrorResponse error = new ErrorResponse(e.getMessage());
		
		//error.setMessage(exception.getMessage()); 
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler(InValidEmailException.class)
	public ResponseEntity<ErrorResponse> handleException(InValidEmailException e){
			
			ErrorResponse error = new ErrorResponse(e.getMessage());
			
			//error.setMessage(exception.getMessage()); 
			
			return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler(HospitalNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(HospitalNotFoundException e){
		
		ErrorResponse error = new ErrorResponse(e.getMessage());
		
		//error.setMessage(exception.getMessage()); 
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler(NoSuchVaccineIdExistsException.class)
	
	public ResponseEntity<ErrorResponse> handleException(NoSuchVaccineIdExistsException e){
		
		ErrorResponse error = new ErrorResponse(e.getMessage());
		
		//error.setMessage(exception.getMessage()); 
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler(ParentNotFoundException.class)
	
	public ResponseEntity<ErrorResponse> handleException(ParentNotFoundException e){
		
		ErrorResponse error = new ErrorResponse(e.getMessage());
		
		//error.setMessage(exception.getMessage()); 
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST); 
	}
	
	
	@ExceptionHandler(BookingNotFoundException.class)
	
	public ResponseEntity<ErrorResponse> handleException(BookingNotFoundException e){
		
		ErrorResponse error = new ErrorResponse(e.getMessage());
		
		//error.setMessage(exception.getMessage()); 
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST); 
	}
	
	

}

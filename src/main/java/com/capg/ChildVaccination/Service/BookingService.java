package com.capg.ChildVaccination.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capg.ChildVaccination.Dto.BookingDto;
import com.capg.ChildVaccination.Entity.Booking;
import com.capg.ChildVaccination.Exceptions.BookingNotFoundException;
import com.capg.ChildVaccination.Exceptions.ParentNotFoundException;

public interface BookingService {

	public Booking addBooking(BookingDto booking);
	
	public Booking updateBooking(int bookingId,BookingDto booking) throws BookingNotFoundException ;
	
	public Booking getBookingById(int bookingId) throws BookingNotFoundException;

	public Booking deleteBooking(int bookingId) throws BookingNotFoundException;
	
	public List<Booking> getAllBookings();
	
	public List<Booking> getAllBookingsByHospitalId(int hospitalId) ;
	
	public List<Booking> getAllBookingsByUserId(String email);
	
	public float getBill(int bookingId) throws BookingNotFoundException;

	Page<Booking> getBookingPagination(Integer pageNumber, Integer pageSize, String sortProperty);
}

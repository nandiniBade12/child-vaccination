package com.capg.ChildVaccination.ServiceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capg.ChildVaccination.Dto.BookingDto;
import com.capg.ChildVaccination.Entity.Booking;
//import com.capg.ChildVaccination.Entity.Child;
import com.capg.ChildVaccination.Entity.Hospital;
import com.capg.ChildVaccination.Entity.Parent;
import com.capg.ChildVaccination.Entity.Vaccine;
import com.capg.ChildVaccination.Exceptions.BookingNotFoundException;
//import com.capg.ChildVaccination.Exceptions.ChildNotFoundException;
import com.capg.ChildVaccination.Exceptions.HospitalNotFoundException;
import com.capg.ChildVaccination.Exceptions.NoSuchVaccineIdExistsException;
import com.capg.ChildVaccination.Exceptions.ParentNotFoundException;
import com.capg.ChildVaccination.Repository.BookingRepository;
//import com.capg.ChildVaccination.Repository.ChildRepository;
import com.capg.ChildVaccination.Repository.HospitalRepository;
import com.capg.ChildVaccination.Repository.ParentRepository;
import com.capg.ChildVaccination.Repository.VaccineRepository;
import com.capg.ChildVaccination.Service.BookingService;


@Service
public class BookingServiceImpl implements BookingService {
	
	
	/*   
	 * Author          : Nandini Bade
	 * Creation Date   : 20-02-2023
	 * Description     : This service implementation has some business logic related to
	 * Booking a child vacccine entered by user(parent) 
	 * and adding booking information into the database 
	 */


	@Autowired
	private BookingRepository bookingRepo;
	
	@Autowired
	private HospitalRepository hospitalRepo;
	
	@Autowired
	private ParentRepository parentRepo;
	
	@Autowired
	private VaccineRepository vaccineRepo;
	
	
	public Booking addBooking(BookingDto booking) {
		
		 Booking b1 = new Booking();
		
		 Parent p1 = parentRepo.findByEmail(booking.getUserName());
		 
		 Optional<Vaccine> v2 = vaccineRepo.findById(booking.getVaccineId());
		 
		 Optional<Hospital> h2 = hospitalRepo.findById(booking.getHospitalId());
		 
		 if(v2.isEmpty()) {
			 
			 throw new NoSuchVaccineIdExistsException("Vaccine Not found");
		 }else if(h2.isEmpty()){
			 
			 throw new HospitalNotFoundException("Hospital Not Found");
		 }
		 else {
			 Vaccine v1 = v2.get();
			 b1.setVaccine(v1);
			 //b1.setHospital(v1.getHospital());
			 b1.setHospital(h2.get());
			 b1.setParent(p1);
			 b1.setBill(v1.getPrice());
			 b1.setName(p1.getUserName());
			 return bookingRepo.save(b1);
		 }
		
	}
	
	
	
	
	public Booking updateBooking(int bookingId,BookingDto booking) throws BookingNotFoundException {
		
			
		Booking b1 =bookingRepo.findById(bookingId).orElse(null);
		Hospital h1 = hospitalRepo.findById(booking.getHospitalId()).orElse(null);
		Vaccine v1 = vaccineRepo.findById(booking.getVaccineId()).orElse(null);
		Parent p1 = parentRepo.findByEmail(booking.getUserName());
		
		if(b1==null) {
			throw new BookingNotFoundException("Booking does not exist ");

		}
		else if(h1==null){
			throw new HospitalNotFoundException(" Hospital Not Found ");
		}
		else if(v1==null){
			throw new NoSuchVaccineIdExistsException("Vaccine id Not found");
		}
		else {
			 b1.setVaccine(v1);
			 //b1.setHospital(v1.getHospital());
			 b1.setHospital(h1);
			 b1.setParent(p1);
			 b1.setBill(v1.getPrice());
			 b1.setName(p1.getUserName());
			 return bookingRepo.save(b1);
		}
		
	}
	
	
	
	
	public Booking getBookingById(int bookingId) throws BookingNotFoundException {
		Optional<Booking> data =bookingRepo.findById(bookingId);
		if(data.isPresent()) {
			return data.get();
		}
		else {
			throw new BookingNotFoundException( "No such Booking found for ID: "+bookingId);
		}
	}

	public Booking deleteBooking(int bookingId) throws BookingNotFoundException  {
		
		Optional<Booking> obj =bookingRepo.findById(bookingId);
		if(obj.isPresent()) {
			Booking booking =obj.get();
			Booking deleted = booking;
			booking.setParent(null);
			booking.setHospital(null);
			booking.setVaccine(null);
			bookingRepo.save(booking);
			bookingRepo.deleteById(bookingId);
			return deleted;
			//return booking;
			 
		}
		throw new  BookingNotFoundException("No such Booking found for ID: "+bookingId);	
	}

	
	
	
	@Override
	public List<Booking> getAllBookings() {
		return bookingRepo.findAll();
	}

	public List<Booking> getAllBookingsByHospitalId(int hospitalId) {
		
		Iterable<Booking> list = bookingRepo.findAll();
		List<Booking> listOfBookings = new ArrayList<Booking>();
		for(Booking b: list) {
			if(b.getHospital().getHospitalid()==hospitalId) {
				listOfBookings.add(b);
			}
		}
		if(listOfBookings.isEmpty()) {
			throw new HospitalNotFoundException("No such hospital found");
		}
		else{
			return listOfBookings;
		}
		//return listOfBookings;	
	}
	
	
	
	
	public List<Booking> getAllBookingsByUserId(String email){
		Parent p1 = parentRepo.findByEmail(email);
		
		Iterable<Booking> list = bookingRepo.findAll();
		List<Booking> listOfBookings = new ArrayList<Booking>();
		for(Booking b: list) {
			if(b.getParent().getParentid()==p1.getParentid()) {
				listOfBookings.add(b);
				System.out.println(listOfBookings);
			}
		}
		if(listOfBookings.isEmpty()) {
			throw new ParentNotFoundException("No such user found");
		}
		else{
			return listOfBookings;
		}
	}
	
	
	
	
	@Override
	public Page<Booking> getBookingPagination(Integer pageNumber, Integer pageSize, String sortProperty) {
        Pageable pageable = null;
        if(null!=sortProperty){
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,sortProperty);
        }else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,"name");
        }
        return bookingRepo.findAll(pageable);
    }
	
	public float getBill(int bookingId){
		
		return bookingRepo.findById(bookingId).get().getBill();
		
	}

}
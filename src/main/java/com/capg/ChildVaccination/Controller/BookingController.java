package com.capg.ChildVaccination.Controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ChildVaccination.Dto.BookingDto;
import com.capg.ChildVaccination.Entity.Booking;
import com.capg.ChildVaccination.Exceptions.BookingNotFoundException;

import com.capg.ChildVaccination.Service.BookingService;

@RestController
@RequestMapping("/vaccineapp")
@CrossOrigin("http://localhost:3000")
public class BookingController {
	
	
	/*   
	 * Author          : Nandini Bade
	 * Creation Date   : 20-02-2023
	 * Module          : Booking
	 * Description     : This controller methods handles HTTP requests from client(UI)
	 * and sends response by returning valid objects and information
	 * from the database back to the UI.
	 */

	@Autowired
	private BookingService bookingService;
	
	
	/*
	 * Method: addBooking(@RequestBody Booking booking) 
	 * Description: It allows to add a vaccination booking
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 * 
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given
	 * URL expression.
	 */
	
	@PostMapping("/addBooking")
	public ResponseEntity<Booking> addBooking(@Valid @RequestBody BookingDto booking)
	{
		Booking data = bookingService.addBooking(booking);
		return new ResponseEntity<Booking>(data, HttpStatus.CREATED);
	}
	
	/*
	 * Method: updateBooking(@RequestBody Booking booking) 
	 * Description: It allows to update the Booking.
	 * 
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URL expression.
	 * 
	 * @RequestBody: It is used to bind HTTP request body with a domain object in
	 * method parameter or return type
	 */
	
	
	@PutMapping("/updateBooking/{id}")
	public ResponseEntity<Booking> updateBooking(@Valid @PathVariable int id,@RequestBody BookingDto booking)
			throws BookingNotFoundException {
		
		Booking data = bookingService.updateBooking(id,booking);
		return new ResponseEntity<Booking>(data, HttpStatus.CREATED);
	}

	
	/*
	 * Method: getBookingById(@PathVariable("bookingId") int bookingId)
	 * Description: It allows to get the booking of given ID.
	 * 
	 * @GetMapping: It is used to handle the HTTP GET requests matched with the given URI expression.
	 * 
	 * @PathVariable: It is used to handle template variables in the request URL
	 */
	
	
	@GetMapping("/getBookingById/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("bookingId") int bookingId) throws BookingNotFoundException {
        Booking booking = bookingService.getBookingById(bookingId);
        return new ResponseEntity<Booking>(booking, HttpStatus.OK);
    }

	
	 /*
	  * Method: getAllBookings() 
	  * Description: It allows to get all the Bookings.
	  * 
	  * @GetMapping: It is used to handle the HTTP GET requests matched with the given URI expression.
	  */
	
	
    @GetMapping("/getAllBookings")
    public ResponseEntity<List<Booking>> getAllBookings(){
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
    }

    
    /*
     * Method : deleteBooking(@PathVariable("bookingId") int bookingId)
     * Description: It allows to get delete the Booking based on given ID.
     * 
     * @DeleteMapping : It is used to delete the resource and for mapping HTTP DELETE requests onto 
     * specific handler methods.
     */
    
    
    @DeleteMapping("/deleteBooking/{bookingId}")
    public ResponseEntity<Booking> deleteBooking(@PathVariable("bookingId") int bookingId) {
        Booking booking = new Booking();
		try {
			booking = bookingService.deleteBooking(bookingId);
		} catch (BookingNotFoundException e) {
			e.printStackTrace();
		}
        return new ResponseEntity<Booking>(booking, HttpStatus.OK);
    }
    
    
    /*
     * Method : getAllBookingsByHospitalId(@PathVariable("hospitalId") int hospitalId)
     * Description: It allows to get fetch the Booking based on given hospitalId.
     */
    
    
    @GetMapping("/getBookingsByHospital/{hospitalId}")
    public ResponseEntity<List<Booking>> getAllBookingsByHospitalId(@PathVariable("hospitalId") int hospitalId) {
    	
        List<Booking> bookings = bookingService.getAllBookingsByHospitalId(hospitalId);
        return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
    }
  
    
    /*
     * Method : getAllBookingsByUserId(@PathVariable("email") String email)
     * Description: It allows to get fetch the Booking based on given user email.
     */
    
    
    @GetMapping("/getBookingsByUser/{email}")
    public ResponseEntity<List<Booking>> getAllBookingsByUserId(@PathVariable("email") String email) {
    	
        List<Booking> bookings = bookingService.getAllBookingsByUserId(email);
        return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
    }
    

    @GetMapping("/getBillById")
    public ResponseEntity<Float> getBill(int id) throws BookingNotFoundException{
    	
        float bill = bookingService.getBill(id);
        return new ResponseEntity<Float>(bill, HttpStatus.OK);
    }
    
    /*
     * Method : bookingPagination
     * Description: It allows to get the Bookings according pages and apply sorting on selected fields.
     */
    
    @GetMapping("/pagingAndSortingBooking/{pageNumber}/{pageSize}/{sortProperty}")
    public Page<Booking> bookingPagination(@PathVariable Integer pageNumber,
                                             @PathVariable Integer pageSize,
                                             @PathVariable String sortProperty) {
        return bookingService.getBookingPagination(pageNumber, pageSize, sortProperty);
    }
	
}
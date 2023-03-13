package com.capg.ChildVaccination;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capg.ChildVaccination.Entity.Booking;
import com.capg.ChildVaccination.Entity.Hospital;
import com.capg.ChildVaccination.Entity.Parent;
import com.capg.ChildVaccination.Entity.Vaccine;
import com.capg.ChildVaccination.Exceptions.BookingNotFoundException;
import com.capg.ChildVaccination.Exceptions.HospitalNotFoundException;
import com.capg.ChildVaccination.Exceptions.ParentNotFoundException;
import com.capg.ChildVaccination.Repository.BookingRepository;
import com.capg.ChildVaccination.Repository.HospitalRepository;
import com.capg.ChildVaccination.Repository.ParentRepository;
import com.capg.ChildVaccination.Repository.VaccineRepository;
import com.capg.ChildVaccination.ServiceImpl.BookingServiceImpl;

//@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookingServiceTest {
	
	@Mock
    private ParentRepository parentRepo;

    @Mock
    private BookingRepository bookingRepo;
    
    @Mock
    private HospitalRepository hospitalRepo;
    
    
    @Mock
    private VaccineRepository vaccineRepo;
    

    @InjectMocks
    private BookingServiceImpl bookingService;
    
    @BeforeEach
    void setUp() {
      MockitoAnnotations.openMocks(this);
    }

    @AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetBookingById() throws BookingNotFoundException {
		
		Booking booking=new Booking();
		
		booking.setBookingId(6);
		booking.setName("shriya");
		
		Mockito.when(bookingRepo.findById(6)).thenReturn(Optional.of(booking));
		
		Booking booking1= bookingService.getBookingById(6);
		assertEquals(6,booking1.getBookingId());
		assertEquals("shriya",booking1.getName());
	

		
	}
	
	@Test
    public void testGetAllBookingsByUserId() throws ParentNotFoundException {
        // Arrange
        String email = "priya@gmail.com";
        Parent p1 = new Parent();
        p1.setEmail(email);
        p1.setParentid(1);
        Mockito.when(parentRepo.findByEmail(email)).thenReturn(p1);

        List<Booking> bookings = new ArrayList<>();
        Booking b1 = new Booking();
        b1.setParent(p1);
        bookings.add(b1);
        Booking b2 = new Booking();
        b2.setParent(new Parent());
        bookings.add(b2);
        Mockito.when(bookingRepo.findAll()).thenReturn(bookings);

        // Act
        List<Booking> result = bookingService.getAllBookingsByUserId(email);

        // Assert
        assertEquals(1, result.size());
        assertSame(b1, result.get(0));
    }
	
	
	@Test
	 public void testDeleteBooking_BookingFound() throws BookingNotFoundException {
	        // Arrange
	        int bookingId = 14;
	        Booking booking = new Booking();
	        booking.setBookingId(bookingId);
	        Optional<Booking> optionalBooking = Optional.of(booking);
	        when(bookingRepo.findById(bookingId)).thenReturn(optionalBooking);

	        // Act
	        Booking result = bookingService.deleteBooking(bookingId);

	        // Assert
	        assertSame(booking, result);
	        assertNull(booking.getParent());
	        assertNull(booking.getHospital());
	        assertNull(booking.getVaccine());
	        verify(bookingRepo).save(booking);
	        verify(bookingRepo).deleteById(bookingId);
	    }

}

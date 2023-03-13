package com.capg.ChildVaccination;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capg.ChildVaccination.Entity.Hospital;
import com.capg.ChildVaccination.Repository.HospitalRepository;
import com.capg.ChildVaccination.ServiceImpl.HospitalServiceImpl;

@ExtendWith(SpringExtension.class)
class HospitalServiceMockitoTest {

	
	@InjectMocks
	HospitalServiceImpl hospitalService;
	
	@MockBean
	HospitalRepository hospitalRepo;
	
	@BeforeEach
	void init(){
		MockitoAnnotations.openMocks(this);
	}
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testgetHospitalById() {
		
		Hospital hospital=new Hospital();
		
		hospital.setHospitalid(7);
	hospital.setHospitalName("vijaya");
		
		Mockito.when(hospitalRepo.findById(7)).thenReturn(Optional.of(hospital));
		
		Hospital hospital1= hospitalService.viewHospital(7);
		assertEquals(7,hospital.getHospitalid());
		assertEquals("vijaya",hospital1.getHospitalName());
	

		
	}



}

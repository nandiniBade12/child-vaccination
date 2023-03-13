package com.capg.ChildVaccination;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


import com.capg.ChildVaccination.Entity.Vaccine;
import com.capg.ChildVaccination.Repository.VaccineRepository;
import com.capg.ChildVaccination.ServiceImpl.VaccineServiceImpl;
@ExtendWith(SpringExtension.class)
class VaccineServiceMockitoTest {

	
	@InjectMocks
	VaccineServiceImpl vaccineService;
	
	@MockBean
	VaccineRepository vaccineRepo;
	
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
	void testgetVaccineById() {
		
		Vaccine vaccine=new Vaccine();
		
		vaccine.setVaccineId(2);
		vaccine.setVaccineName("BCG");
		
		Mockito.when(vaccineRepo.findById(2)).thenReturn(Optional.of(vaccine));
		
		Vaccine vaccine1= vaccineService.getVaccinebyId(2);
		assertEquals(2,vaccine1.getVaccineId());
		assertEquals("BCG",vaccine1.getVaccineName());
			
	}



}

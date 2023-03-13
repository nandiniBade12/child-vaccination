package com.capg.ChildVaccination;


import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.ChildVaccination.Entity.Hospital;
import com.capg.ChildVaccination.Exceptions.HospitalNotFoundException;
import com.capg.ChildVaccination.ServiceImpl.HospitalServiceImpl;

@SpringBootTest
class HospitalServiceTest {
	
	@Autowired
	HospitalServiceImpl  IHospitalService;
	@Test
	void contextLoads() {
		
	}

	@Test
	void deleteHospitalTest() throws HospitalNotFoundException {
//		Hospital hospital=IHospitalService.removeHospitalById(2);
//		assertEquals("vijaya",hospital.getHospitalName());
	}
}
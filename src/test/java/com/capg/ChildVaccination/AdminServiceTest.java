package com.capg.ChildVaccination;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.ChildVaccination.Dto.AdminDto;
import com.capg.ChildVaccination.Entity.Admin;
import com.capg.ChildVaccination.Entity.Hospital;
import com.capg.ChildVaccination.Entity.Vaccine;
import com.capg.ChildVaccination.ServiceImpl.IAdminService;


@SpringBootTest
 class AdminServiceTest {
	
	@Autowired
	IAdminService  adminService;
	
	
	@Test
	void contextLoads() {
		
	}
	
	
	@Test
	void viewAllVaccineTest() {
		List<Vaccine> vaccine1 = adminService.getAllVaccine();
		assertEquals(3,vaccine1.size());
	}
	@Test
	void getAllHospitalsTest() {
		List<Hospital> hospital1 =adminService.getAllHospitals();
		assertEquals(2,hospital1.size());
	}
	
	
	


}
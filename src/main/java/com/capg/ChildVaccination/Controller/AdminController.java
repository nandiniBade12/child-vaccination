package com.capg.ChildVaccination.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ChildVaccination.Dto.AdminDto;
import com.capg.ChildVaccination.Entity.Admin;
import com.capg.ChildVaccination.Entity.Hospital;
import com.capg.ChildVaccination.Entity.Vaccine;
import com.capg.ChildVaccination.Service.AdminService;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:3000")
public class AdminController {
	
	
	/*   
	 * Author          : Sandeep Mallapareddy
	 * Creation Date   : 20-02-2023
	 * Module          : Booking
	 * Description     : This controller methods handles HTTP requests from client(UI)
	 * and sends response by returning valid objects and information
	 * from the database back to the UI.
	 */
	
	
	@Autowired
	AdminService adminService;
	
	private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/insertAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody AdminDto admin) {
		logger.info("Sending Request to add admin");
		Admin a1 = adminService.insertAdmin(admin);
		logger.info("Admin Added");
		return new ResponseEntity<>(a1,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAdmin/{id}")
	public ResponseEntity<Admin> getAdmin(@PathVariable("id")int id) {
		logger.info("Sending Request to get admin");
		Admin a1 = adminService.getAdmin(id);
		logger.info("Admin recieved");
		return new ResponseEntity<>(a1,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAdminByEmail/{email}")
	public ResponseEntity<Admin> getAdmin(@PathVariable("email")String email) {
		logger.info("Sending Request to get admin");
		Admin a1 = adminService.getAdmin(email);
		logger.info("Admin recieved");
		return new ResponseEntity<>(a1,HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/updateAdmin/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("id")int id, @RequestBody AdminDto admin) {
		logger.info("Sending request to update admin");
		Admin a1 = adminService.updateAdmin(id,admin);
		logger.info("Admin updated");
		return new ResponseEntity<>(a1,HttpStatus.OK);
	}
	
	@PutMapping("/updateAdminByEmail/{email}")
	public ResponseEntity<Admin> updateAdminByEmail(@PathVariable("email")String email, @RequestBody AdminDto admin) {
		logger.info("Sending request to update admin");
		Admin a1 = adminService.updateAdminByEmail(email,admin);
		logger.info("Admin updated");
		return new ResponseEntity<>(a1,HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/deleteAdmin/{id}")
	public ResponseEntity<Admin> deleteAdmin(@PathVariable("id")int id){
		logger.info("Sending request to delete admin");
		Admin a1 = adminService.delAdmin(id);
		logger.info("Admin deleted");
		return new ResponseEntity<>(a1,HttpStatus.OK);
	}
	
	@GetMapping("/getAllVaccines")
	public ResponseEntity<List<Vaccine>> getAllVaccines(){
		logger.info("Sending request to get all vaccines");
		List<Vaccine> l1 = adminService.getAllVaccine();
		logger.info("Vaccines received");
		return new ResponseEntity<>(l1,HttpStatus.OK);
	}
	
	@GetMapping("/getAllHospitals")
	public ResponseEntity<List<Hospital>> getAllHospitals(){
		logger.info("Sending request to get all hospitals");
		List<Hospital> l1 = adminService.getAllHospitals();
		logger.info("hospitals received");
		return new ResponseEntity<>(l1,HttpStatus.OK);
	}
	@GetMapping("/getAllVaccinesByAge")
	public ResponseEntity<List<Vaccine>> getAllVaccinesByAge(@RequestParam("age") int age){
		logger.info("Sending request to get all vaccines by age");
		List<Vaccine> l1 = adminService.getAllVaccineByAge(age);
		logger.info("Vaccines received");
		return new ResponseEntity<>(l1,HttpStatus.OK);
	}
	@GetMapping("/getAllVaccinesByPrice")
	public ResponseEntity<List<Vaccine>> getAllVaccinesByPrice(@RequestParam("price") float price ){
		logger.info("Sending request to get all vaccines by price");
		List<Vaccine> l1 = adminService.getAllVaccineByPrice(price);
		logger.info("Vaccines received");
		return new ResponseEntity<>(l1,HttpStatus.OK);
	}
	
	

}

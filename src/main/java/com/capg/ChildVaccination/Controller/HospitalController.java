package com.capg.ChildVaccination.Controller;


import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ChildVaccination.Dto.HospitalDto;
import com.capg.ChildVaccination.Entity.Child;
import com.capg.ChildVaccination.Entity.Hospital;
import com.capg.ChildVaccination.Service.HospitalService;



@RestController
@RequestMapping("/Hospital")
@CrossOrigin("http://localhost:3000")
public class HospitalController {
	
	
	/*   
	 * Author          : Mounika Alla
	 * Creation Date   : 20-02-2023
	 * Module          : Booking
	 * Description     : This controller methods handles HTTP requests from client(UI)
	 * and sends response by returning valid objects and information
	 * from the database back to the UI.
	 */
	
	
	@Autowired
	HospitalService ihospitalService;
	private static Logger logger=LogManager.getLogger();
	
	@PostMapping("/insertHospital")
	public ResponseEntity<Hospital>addHospital(@RequestBody HospitalDto hospital){
		logger.info("sending request to add Hospital");
		Hospital h1=ihospitalService.addHospital(hospital);
		logger.info("request added");
		return new ResponseEntity<>(h1,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/hospital/delete/{hospitalId}")
	ResponseEntity<Hospital> removeHospitalById(@PathVariable("hospitalId") int hospitalId)  {
		logger.info("Sending request to delete a Hospital");
		Hospital deletedHospital=ihospitalService.removeHospitalById(hospitalId);
		logger.info("Removed an Hospital from the Database");
		return new ResponseEntity<>(deletedHospital, HttpStatus.OK);
	}
	
	@GetMapping("/hospital/getAllHospital")
	ResponseEntity<List<Hospital>> getAllHospital(){
		logger.info("Sending request to get all hospitals");
		List<Hospital> allHospital=ihospitalService.getAllHospital();
		logger.info("hospitals recieved");
		return new ResponseEntity<>(allHospital, HttpStatus.OK);
	}
	@GetMapping("/hospital/view/{hospitalId}")
	ResponseEntity<Hospital> viewHospital(@PathVariable("hospitalId") int hospitalId)  {
		logger.info("Sending request to view all hospitals");
		Hospital hospital = ihospitalService.viewHospital(hospitalId);
		logger.info("view all hospitals");
		return new ResponseEntity<>(hospital, HttpStatus.OK);
		
	}
	@PutMapping("/updateHospital/{id}")
	public ResponseEntity<Hospital>updateHospitalById(@PathVariable("id") int id , @RequestBody HospitalDto hospital)  {
		logger.info("sending request to update Hospital");
		Hospital h1=ihospitalService.updateHospital(id,hospital);
		logger.info("request updated");
		return new ResponseEntity<>(h1,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllHospitalsNames")
	public Set<String> getAllHospitals(){
		return ihospitalService.getAllHospitalNames();
	}
	
	@GetMapping("/pagingAndSortingHospital/{pageNumber}/{pageSize}/{sortProperty}")
    public Page<Hospital> hospitalPagination(@PathVariable Integer pageNumber,
                                             @PathVariable Integer pageSize,
                                             @PathVariable String sortProperty) {
        return ihospitalService.getHospitalPagination(pageNumber, pageSize, sortProperty);
    }
		
}
	
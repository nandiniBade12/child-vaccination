package com.capg.ChildVaccination.Controller;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capg.ChildVaccination.Entity.Vaccine;
import com.capg.ChildVaccination.Exception.NoSuchVaccineIdExistsException;
import com.capg.ChildVaccination.Exception.VaccineIdAlreadyExistsException;

import com.capg.ChildVaccination.Service.VaccineService;
import com.capg.ChildVaccination.Service.VaccineServiceImpl;
@RestController
@RequestMapping("/vaccine")
public class VaccineController {
	@Autowired
    private VaccineServiceImpl vaccineService;
private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/addVaccine")	
	public ResponseEntity<Vaccine> addVaccine(@RequestBody Vaccine vaccine) 
	{
		logger.info("Sending request to Add vaccine");
		Vaccine v1 =  vaccineService.addVaccine(vaccine);
		logger.info("Vaccine Added");
		return new ResponseEntity<>(v1,HttpStatus.OK);
	}
	@PutMapping("/updateVaccine/{id}")
	public ResponseEntity<Vaccine> updateVaccine(@PathVariable int id,@RequestBody Vaccine vaccine) 
	{
		logger.info("Sending request to update vaccine");
		Vaccine v1 =  vaccineService.updateVaccinebyId(id,vaccine);
		logger.info("Vaccine updated");
		return new ResponseEntity<>(v1,HttpStatus.OK);
	}

	@DeleteMapping("/deleteVaccine/{id}")
	public ResponseEntity<Vaccine> deleteVaccinebyId(@PathVariable int id )
	{
		logger.info("Deleting vaccine details");
		Vaccine v1 = vaccineService.deleteVaccinebyid(id);
		logger.info("Deleting vaccine");
		return new ResponseEntity<>(v1,HttpStatus.OK);
	}
	@GetMapping("/getvaccine/{id}")
    ResponseEntity<Vaccine> getVaccinebyId(@PathVariable int id ) throws NoSuchVaccineIdExistsException  {
    logger.info("Sending request to view a Vaccine by id");
    Vaccine v1 =vaccineService.getVaccinebyId(id);
    logger.info("getting vaccine by id");
    return new ResponseEntity<>(v1,HttpStatus.OK);
    
    }
	@GetMapping("/view/all")
    public ResponseEntity<List<Vaccine>> viewVaccines(){
        logger.info("Sending request to view all Vaccines");
        List<Vaccine> i1 = vaccineService.viewAllVaccines();
        logger.info("All vaccines received");
        return new ResponseEntity<>(i1,HttpStatus.OK);
    }
	@GetMapping("/getvaccinebydose/{totaldoses}")
	public ResponseEntity<List<Vaccine>> viewVaccinebydosecount(@PathVariable int totaldoses)
	{
		logger.info("Sending request to view all vaccines with same dose count");
		List<Vaccine> allVaccines=vaccineService.viewVaccinebydose(totaldoses);
		 logger.info("Vaccines recieved");
		return new ResponseEntity<>(allVaccines, HttpStatus.OK);
	}
	@GetMapping("/getvaccinebyage/{agelimit}")
	public ResponseEntity<List<Vaccine>> viewVaccinebyage(@PathVariable int agelimit)
	{
		logger.info("Sending request to view all vaccines with same agelimit");
		List<Vaccine> allVaccines=vaccineService.viewVaccinebyage(agelimit);
		 logger.info("Vaccines recieved");
		return new ResponseEntity<>(allVaccines, HttpStatus.OK);
	}
}
	
	
	
	



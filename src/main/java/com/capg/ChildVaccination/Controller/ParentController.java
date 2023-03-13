package com.capg.ChildVaccination.Controller;

import java.util.List;

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

import com.capg.ChildVaccination.Dto.ParentDto;
import com.capg.ChildVaccination.Entity.Booking;
import com.capg.ChildVaccination.Entity.Parent;
import com.capg.ChildVaccination.Service.ParentService;

@RestController
@RequestMapping("/parent")
@CrossOrigin("http://localhost:3000")
public class ParentController {
	
	
	/*   
	 * Author          : Pooja Harika
	 * Creation Date   : 20-02-2023
	 * Module          : Booking
	 * Description     : This controller methods handles HTTP requests from client(UI)
	 * and sends response by returning valid objects and information
	 * from the database back to the UI.
	 */
	
	
	@Autowired
	ParentService parentService;
	private static Logger logger=LogManager.getLogger();
	
	@PostMapping("/addParent")
	public ResponseEntity<Parent> addParent(@RequestBody ParentDto parent) {
		logger.info("posting parent details");
		Parent p1 = parentService.addParent(parent);
		logger.info("Parent posted");
		return new ResponseEntity<>(p1,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateParent/{id}")
	public ResponseEntity<Parent> updateParent(@PathVariable("id")int id , @RequestBody ParentDto parent){
		logger.info("posting parent details");
		Parent p1 = parentService.updateParent(id,parent);
		logger.info("Parent posted");
		return new ResponseEntity<>(p1,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteParent/{id}")
	public ResponseEntity<Parent> deleteParent(@PathVariable("id")int id){
		logger.info("deleting parent details");
		Parent p1 = parentService.delParent(id);
		logger.info("Parent deleted");
		return new ResponseEntity<>(p1,HttpStatus.OK);
	}
	
	@GetMapping("/viewParent/{id}")
	public ResponseEntity<Parent> viewParent(@PathVariable("id")int id){
		logger.info("view parent details");
		Parent p1 = parentService.viewParent(id);
		logger.info("Parent details recieved");
		return new ResponseEntity<>(p1,HttpStatus.OK);
	}
	@GetMapping("/viewAllParent")
	public ResponseEntity<List<Parent>> viewAllParent(){
		logger.info("getting all parent details");
		List<Parent> p1 = parentService.viewAllParent();
		logger.info("Parent details recieved");
		return new ResponseEntity<>(p1,HttpStatus.OK);
	}
	
	
	@GetMapping("/getParentByEmail")
	public ResponseEntity<Parent> getParentByEmail(String email){
		Parent p1 = parentService.getParentByEmail(email);
		return new ResponseEntity<>(p1,HttpStatus.OK);
	}
	@PutMapping("/updateParentByEmail/{email}")
	public ResponseEntity<Parent> updateParentByEmail(@PathVariable("email")String email,@RequestBody ParentDto parent){
		Parent p1 = parentService.updateParentByEmail(email,parent);
		return new ResponseEntity<>(p1,HttpStatus.OK);
	}
	
	@GetMapping("/getParentByEmail/{email}")
	public ResponseEntity<Parent> viewParentByEmail(@PathVariable String email){
		Parent p1 = parentService.viewParentByEmail(email);
		return new ResponseEntity<>(p1,HttpStatus.OK);
	}
	
	@GetMapping("/pagingAndSortingParent/{pageNumber}/{pageSize}/{sortProperty}")
    public Page<Parent> parentPagination(@PathVariable Integer pageNumber,
                                             @PathVariable Integer pageSize,
                                             @PathVariable String sortProperty) {
        return parentService.getParentPagination(pageNumber, pageSize, sortProperty);
    }
	
	@PutMapping("/updatePassword/{email}")
	public ResponseEntity<Parent> updatePassword(@PathVariable("email")String email,@RequestParam("password")String password){
		Parent p1 = parentService.updatePasswordByEmail(email,password);
		return new ResponseEntity<>(p1,HttpStatus.OK);
	}
	

}

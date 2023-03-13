package com.capg.ChildVaccination.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capg.ChildVaccination.Dto.VaccineDto;
import com.capg.ChildVaccination.Dto.VaccineDto2;
import com.capg.ChildVaccination.Entity.Hospital;
import com.capg.ChildVaccination.Entity.Vaccine;
import com.capg.ChildVaccination.Exceptions.HospitalNotFoundException;
import com.capg.ChildVaccination.Exceptions.NoSuchVaccineIdExistsException;
import com.capg.ChildVaccination.Exceptions.VaccineIdAlreadyExistsException;
import com.capg.ChildVaccination.Repository.HospitalRepository;
import com.capg.ChildVaccination.Repository.VaccineRepository;


@Service
public class VaccineServiceImpl {
	@Autowired
	private VaccineRepository vaccineRepo;
	
	@Autowired
	private HospitalRepository hospitalRepo;
	
	 public Vaccine addVaccine(VaccineDto vaccine) {
		
		 Vaccine v1 = new Vaccine();
		 v1.setVaccineName(vaccine.getVaccineName());
		 v1.setVaccineDescription(vaccine.getVaccineDescription());
		 v1.setAgelimit(vaccine.getAgelimit());
		 v1.setTotaldoses(vaccine.getTotaldoses());
		 v1.setPrice(vaccine.getPrice());
		 Hospital h2 = hospitalRepo.findByHospitalName(vaccine.getHospitalName());
		 if(h2 != null) {
			 v1.setHospital(h2);
			 return vaccineRepo.save(v1);
		 }else {
			 throw new HospitalNotFoundException("Hospital Not Found");
		 }
	} 
	 
	 public Vaccine updateVaccinebyId(int id,VaccineDto2 vaccine) 
	 {
		Vaccine v2 = vaccineRepo.findById(id).orElse(null);
//		Hospital h1 = hospitalRepo.findById(vaccine.getHospitalId()).orElse(null);
			if(v2==null) {
				throw new NoSuchVaccineIdExistsException("Vaccine id Not found");
				
			}
//			else if(h1 == null) {
//				throw new HospitalNotFoundException("Invalid Hospital Id Given");
//			}
			else
			{
				v2.setVaccineName(vaccine.getVaccineName());
				v2.setVaccineDescription(vaccine.getVaccineDescription());
				v2.setAgelimit(vaccine.getAgelimit());
				v2.setTotaldoses(vaccine.getTotaldoses());
				v2.setPrice(vaccine.getPrice());
				v2.setHospital(v2.getHospital());
				return vaccineRepo.save(v2);
				
			}
	 }
	 public Vaccine deleteVaccinebyid(int id) 
	{
		 Vaccine v1 =vaccineRepo.findById(id).orElse(null);
		
		if(v1==null) {
			throw new NoSuchVaccineIdExistsException("Vaccine id Not found");
			
		}		
		else
		{
			vaccineRepo.delete(v1);
			return v1;
			
		}
	}
	 public Vaccine getVaccinebyId(int id)
	{
		 Optional<Vaccine> v1 = vaccineRepo.findById(id);
		 if(v1.isPresent()) {
			 Vaccine viewVaccine=v1.get();
			 vaccineRepo.findById(id);
			 return viewVaccine;  

		 }
		 else {
			 throw new NoSuchVaccineIdExistsException("Vaccine not Found with the given ID: "+id);
		 }
	}
	public List<Vaccine> viewAllVaccines() {
        return (List<Vaccine>) vaccineRepo.findAll();
    }
	public List<Vaccine>  viewVaccinebydose(int totaldoses) {
		
		Iterable<Vaccine> l1 = vaccineRepo.findAll();
		List<Vaccine> v2 = new ArrayList<>();
		for(Vaccine v : l1) {
			if(v.getTotaldoses() == totaldoses) {
				v2.add(v);
			}
		}
		return v2;
	}
	  public List<Vaccine>viewVaccinebyage(int agelimit)
	  {
		  Iterable<Vaccine> l2 = vaccineRepo.findAll();
			List<Vaccine> v3 = new ArrayList<>();
			for(Vaccine v : l2) {
				if(v.getAgelimit() == agelimit) {
					v3.add(v);
				}
			}
			return v3;	  
	  }
	  
	 
		public Page<Vaccine> getVaccinePagination(Integer pageNumber, Integer pageSize, String sortProperty) {
	        Pageable pageable = null;
	        if(null!=sortProperty){
	            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,sortProperty);
	        }else {
	            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,"vaccineName");
	        }
	        return vaccineRepo.findAll(pageable);
	    }
}

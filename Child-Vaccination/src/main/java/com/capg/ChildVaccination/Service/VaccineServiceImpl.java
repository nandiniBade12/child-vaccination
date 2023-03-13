package com.capg.ChildVaccination.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.ChildVaccination.Entity.Vaccine;
import com.capg.ChildVaccination.Exception.NoSuchVaccineIdExistsException;
import com.capg.ChildVaccination.Exception.VaccineIdAlreadyExistsException;
import com.capg.ChildVaccination.Repository.VaccineRepository;


@Service
public class VaccineServiceImpl {
	@Autowired
	private VaccineRepository vaccineRepo;
	
	 public Vaccine addVaccine(Vaccine vaccine) {
		
		Vaccine v1  = vaccineRepo.findById(vaccine.getVaccineId()).orElse(null);
		if(v1==null) {
			return vaccineRepo.save(vaccine);
				
		}
		else {
			throw new VaccineIdAlreadyExistsException("Vaccine id already exists");
		}
		
	} 
	 
	 public Vaccine updateVaccinebyId(int id,Vaccine vaccine) 
	 {
		Vaccine v2 = vaccineRepo.findById(vaccine.getVaccineId()).orElse(null);
			if(v2==null) {
				throw new NoSuchVaccineIdExistsException("Vaccine id Not found");
				
			}
			else
			{
				
				v2.setVaccineName(vaccine.getVaccineName());
				v2.setVaccineDescription(vaccine.getVaccineDescription());
				v2.setAgelimit(vaccine.getAgelimit());
				v2.setTotaldoses(vaccine.getTotaldoses());
				v2.setPrice(vaccine.getPrice());
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
			vaccineRepo.deleteById(id);
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
}
	        
		

				
				
					
			
	 
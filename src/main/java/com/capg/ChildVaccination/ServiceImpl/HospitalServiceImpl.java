package com.capg.ChildVaccination.ServiceImpl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capg.ChildVaccination.Dto.HospitalDto;
import com.capg.ChildVaccination.Entity.Hospital;
import com.capg.ChildVaccination.Entity.Parent;
import com.capg.ChildVaccination.Exceptions.HospitalNotFoundException;
import com.capg.ChildVaccination.Repository.HospitalRepository;
import com.capg.ChildVaccination.Service.HospitalService;



@Service
public class HospitalServiceImpl implements HospitalService{
	@Autowired
	HospitalRepository hospitalRepo;
	@Override
	public Hospital addHospital(HospitalDto hospital) {
		Hospital h1=new Hospital();
		
		LocalTime t1 = LocalTime.parse( hospital.getStartingTime() ) ;
		LocalTime t2 = LocalTime.parse( hospital.getEndingTime() ) ;
		h1.setHospitalName(hospital.getHospitalName());
	    h1.setHospitalAddress(hospital.getHospitalAddress());
	    h1.setStartingTime(t1);
	    h1.setEndingTime(t2);
	
		return hospitalRepo.save(h1);
	}

	@Override
	public Hospital removeHospitalById(int hospitalId)  {
		Optional<Hospital> hospitalOpt=hospitalRepo.findById(hospitalId);
		if(hospitalOpt.isPresent()) {
			hospitalRepo.deleteById(hospitalId);
			return hospitalOpt.get();
		}
		throw new HospitalNotFoundException("Hospital Not Found");
	
		
		
	}

@Override
	public List<Hospital> getAllHospital() {
		
			List<Hospital> hospital=(List<Hospital>) hospitalRepo.findAll();
			return hospital;
		}


@Override
public Hospital viewHospital(int hospitalId)  {

		Optional<Hospital> hospitalOpt = hospitalRepo.findById(hospitalId);
		if(hospitalOpt.isPresent()) {
			
		
		Hospital hospital = hospitalOpt.get();
		hospitalRepo.getById(hospitalId);
        return hospital;
		}
		else {
		       throw new HospitalNotFoundException("hospital not Found with the given ID: "+hospitalId);
		 }
}


@Override
public Hospital updateHospital(int id, HospitalDto hospital)  {
	
	Optional<Hospital> hospitalOpt=hospitalRepo.findById(id);
	if(hospitalOpt.isPresent()) {
		Hospital h1 =hospitalOpt.get();
		h1.setHospitalName(hospital.getHospitalName());
	    h1.setHospitalAddress(hospital.getHospitalAddress());
	    LocalTime t1 = LocalTime.parse( hospital.getStartingTime() ) ;
		LocalTime t2 = LocalTime.parse( hospital.getEndingTime() ) ;
	    h1.setStartingTime(t1);
	    h1.setEndingTime(t2);
	    hospitalRepo.save(h1);
	    return h1;
      }
		else {
			throw new HospitalNotFoundException("hospital not Found with the given ID:"+id);
		}
		
			
		
}

	@Override
	public Set<String> getAllHospitalNames() {
		List<Hospital> l1 = (List<Hospital>) hospitalRepo.findAll();
		List<String> l2 = new ArrayList<>();
		for(Hospital h1: l1) {
			l2.add(h1.getHospitalName());
		}
		Set<String> set =new HashSet<>(l2);
		return set;
	}
	
	@Override
	public Page<Hospital> getHospitalPagination(Integer pageNumber, Integer pageSize, String sortProperty) {
        Pageable pageable = null;
        if(null!=sortProperty){
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,sortProperty);
        }else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,"hospitalName");
        }
        return hospitalRepo.findAll(pageable);
    }
	
}

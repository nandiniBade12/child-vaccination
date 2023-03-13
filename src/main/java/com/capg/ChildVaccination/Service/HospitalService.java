package com.capg.ChildVaccination.Service;


import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;

import com.capg.ChildVaccination.Dto.HospitalDto;
import com.capg.ChildVaccination.Entity.Hospital;
import com.capg.ChildVaccination.Exceptions.HospitalNotFoundException;



public interface HospitalService  {
	Hospital addHospital(HospitalDto hospital) ;
	Hospital removeHospitalById(int hospitalId) throws HospitalNotFoundException;
	List<Hospital> getAllHospital();
	
	Hospital viewHospital(int hospitalId) throws HospitalNotFoundException;
	Hospital updateHospital(int id,HospitalDto hospital)throws  HospitalNotFoundException;
	Set<String> getAllHospitalNames();
	Page<Hospital> getHospitalPagination(Integer pageNumber, Integer pageSize, String sortProperty);
}

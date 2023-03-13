package com.capg.ChildVaccination.Repository;


import org.springframework.data.repository.PagingAndSortingRepository;



import com.capg.ChildVaccination.Entity.Hospital;

public interface HospitalRepository extends PagingAndSortingRepository<Hospital,Integer>{

	void getById(int hospitalId);
	Hospital findByHospitalName(String name);

}


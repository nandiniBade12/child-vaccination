package com.capg.ChildVaccination.Repository;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.capg.ChildVaccination.Entity.Vaccine;
@Repository
public interface VaccineRepository extends PagingAndSortingRepository<Vaccine, Integer> {

	
	 
	}

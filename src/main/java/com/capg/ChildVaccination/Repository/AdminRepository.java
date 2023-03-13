package com.capg.ChildVaccination.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.capg.ChildVaccination.Entity.Admin;

@Repository
public interface AdminRepository extends PagingAndSortingRepository<Admin , Integer>{
	
	Admin findByEmail(String email);
}

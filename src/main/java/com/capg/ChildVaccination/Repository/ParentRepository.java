package com.capg.ChildVaccination.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.capg.ChildVaccination.Entity.Parent;

public interface ParentRepository extends PagingAndSortingRepository<Parent, Integer> {
	
	Parent findByEmail(String email);

}

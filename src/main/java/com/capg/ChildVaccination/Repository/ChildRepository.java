package com.capg.ChildVaccination.Repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.capg.ChildVaccination.Entity.Child;

@Repository
public interface ChildRepository extends PagingAndSortingRepository<Child, Integer> {

}

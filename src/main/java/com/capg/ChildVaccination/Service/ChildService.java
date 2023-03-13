package com.capg.ChildVaccination.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capg.ChildVaccination.Dto.ChildDto;
import com.capg.ChildVaccination.Entity.Child;

public interface ChildService {

	Child addChild(String parentEmail, ChildDto child);

	Child updateChild(int id, ChildDto child);

	Child delChild(int id);

	Child viewChild(int id);

	List<Child> viewAllChild(String email);

	Page<Child> getChildPagination(Integer pageNumber, Integer pageSize, String sortProperty);

}

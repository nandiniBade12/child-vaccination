package com.capg.ChildVaccination.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capg.ChildVaccination.Dto.ParentDto;
import com.capg.ChildVaccination.Entity.Parent;

public interface ParentService {

	Parent addParent(ParentDto parent);

	Parent updateParent(int id , ParentDto parent);

	Parent delParent(int id);

	Parent viewParent(int id);

	List<Parent> viewAllParent();

	
	Parent getParentByEmail(String email);

	Parent updateParentByEmail(String email, ParentDto parent);

	Parent viewParentByEmail(String email);

	Parent updatePasswordByEmail(String email, String password);
	
	Page<Parent> getParentPagination(Integer pageNumber, Integer pageSize, String sortProperty);
	
	

}

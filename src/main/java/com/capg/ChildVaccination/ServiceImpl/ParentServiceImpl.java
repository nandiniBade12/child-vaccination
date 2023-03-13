package com.capg.ChildVaccination.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capg.ChildVaccination.Dto.ParentDto;
import com.capg.ChildVaccination.Entity.Booking;
import com.capg.ChildVaccination.Entity.Parent;
import com.capg.ChildVaccination.Entity.User;
import com.capg.ChildVaccination.Exceptions.ParentNotFoundException;
import com.capg.ChildVaccination.Repository.IUserRepository;
import com.capg.ChildVaccination.Repository.ParentRepository;
import com.capg.ChildVaccination.Service.ParentService;

@Service
public class ParentServiceImpl implements ParentService {
	
	@Autowired
	ParentRepository parentRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	IUserRepository userRepo;

	@Override
	public Parent addParent(ParentDto parent) {
		Parent p1 = new Parent();
		p1.setUserName(parent.getUserName());
		p1.setPassword(parent.getPassword());
		p1.setEmail(parent.getEmail());
		p1.setAddress(parent.getAddress());
		p1.setMobileNo(parent.getMobileNo());
		User u1 = new User();
		u1.setUserName(parent.getEmail());
		u1.setPassword(parent.getPassword());
		u1.setRole("customer");
		userService.userSignUp(u1);
		return parentRepo.save(p1);
	}

	@Override
	public Parent updateParent(int id, ParentDto parent) {
		Parent p1 = parentRepo.findById(id).orElse(null);
		if(p1 == null) {
			throw new ParentNotFoundException("parent not found");
		}
		p1.setUserName(parent.getUserName());
		p1.setPassword(parent.getPassword());
		p1.setEmail(parent.getEmail());
		p1.setAddress(parent.getAddress());
		p1.setMobileNo(parent.getMobileNo());
		return parentRepo.save(p1);
	}

	@Override
	public Parent delParent(int id) {
		Parent p1 = parentRepo.findById(id).orElse(null);
		if(p1 == null) {
			throw new ParentNotFoundException("parent not found");
		}
		parentRepo.deleteById(id);
		return p1;
	}

	@Override
	public Parent viewParent(int id) {
		Parent p1 = parentRepo.findById(id).orElse(null);
		if(p1 == null) {
			throw new ParentNotFoundException("parent not found");
		}
		return p1;
	}

	@Override
	public List<Parent> viewAllParent() {
		return (List<Parent>) parentRepo.findAll();
	}

	@Override
	public Parent getParentByEmail(String email) {
		return parentRepo.findByEmail(email);
	}

	@Override
	public Parent updateParentByEmail(String email,ParentDto parent) {
		Parent p1 = parentRepo.findByEmail(email);
		User u1 = userRepo.findByUserName(email);
		if(p1 == null) {
			throw new ParentNotFoundException("parent not found");
		}
		p1.setUserName(parent.getUserName());
		p1.setPassword(parent.getPassword());
		p1.setEmail(parent.getEmail());
		p1.setAddress(parent.getAddress());
		p1.setMobileNo(parent.getMobileNo());
		u1.setUserName(parent.getEmail());
		u1.setPassword(parent.getPassword());
		u1.setRole("customer");
		userRepo.save(u1);
		return parentRepo.save(p1);
	}

	@Override
	public Parent viewParentByEmail(String email) {
		Parent p1 = parentRepo.findByEmail(email);
		return p1;
	}
	
	@Override
	public Page<Parent> getParentPagination(Integer pageNumber, Integer pageSize, String sortProperty) {
        Pageable pageable = null;
        if(null!=sortProperty){
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,sortProperty);
        }else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,"userName");
        }
        return parentRepo.findAll(pageable);
    }
	
	@Override
	public Parent updatePasswordByEmail(String email, String password) {
		Parent p1 = parentRepo.findByEmail(email);
		User u1 = userRepo.findByUserName(email);
		if(p1 == null) {
			throw new ParentNotFoundException("parent not found");
		}
		p1.setPassword(password);
		u1.setPassword(password);
		userRepo.save(u1);
		return parentRepo.save(p1);
	}


}

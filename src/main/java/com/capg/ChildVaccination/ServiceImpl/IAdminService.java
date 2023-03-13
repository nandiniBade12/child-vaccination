package com.capg.ChildVaccination.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ChildVaccination.Dto.AdminDto;
import com.capg.ChildVaccination.Entity.Admin;
import com.capg.ChildVaccination.Entity.Hospital;
import com.capg.ChildVaccination.Entity.User;
import com.capg.ChildVaccination.Entity.Vaccine;
import com.capg.ChildVaccination.Exceptions.AdminNotExistException;
import com.capg.ChildVaccination.Exceptions.InValidEmailException;
import com.capg.ChildVaccination.Repository.AdminRepository;
import com.capg.ChildVaccination.Repository.HospitalRepository;
import com.capg.ChildVaccination.Repository.IUserRepository;
import com.capg.ChildVaccination.Repository.VaccineRepository;
import com.capg.ChildVaccination.Service.AdminService;

@Service
public class IAdminService implements AdminService{
	
	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	VaccineRepository vaccineRepo;
	
	@Autowired
	HospitalRepository hospitalRepo;

	
	@Autowired
	UserService userService;
	
	@Autowired
	IUserRepository userRepo;

	@Override
	public Admin insertAdmin(AdminDto admin) {
		Admin a1 = new Admin();
		a1.setAdminName(admin.getAdminName());
		a1.setPassword(admin.getPassword());
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(admin.getEmail());
		String phNo = "^[0-9]{10}$";
		Pattern ptrn = Pattern.compile(phNo);
		Matcher m2 = ptrn.matcher(admin.getMobileNumber()); 
		if(matcher.matches()==true && m2.matches()==true) {
			a1.setEmail(admin.getEmail());
			a1.setMobileNumber(admin.getMobileNumber());
			User u1 = new User();
			u1.setUserName(admin.getEmail());
			u1.setPassword(admin.getPassword());
			u1.setRole("admin");
			userService.userSignUp(u1);
			return adminRepo.save(a1);
		}else {
			throw new InValidEmailException("Invalid Email or Phone Number");
		}
	}

	@Override
	public Admin updateAdmin(int id, AdminDto admin) {
		Optional<Admin> a1 = adminRepo.findById(id);
		if(a1.isPresent()) {
			Admin a2 = a1.get();
			a2.setAdminName(admin.getAdminName());
			a2.setEmail(admin.getEmail());
			a2.setPassword(admin.getPassword());
			a2.setMobileNumber(admin.getMobileNumber());
			return adminRepo.save(a2);
		}else{
			throw new AdminNotExistException("Admin Not Found");
		}
	}

	@Override
	public Admin delAdmin(int id) {
		Optional<Admin> a1 = adminRepo.findById(id);
		if(a1.isPresent()) {
			adminRepo.deleteById(id);
			return a1.get();
		}
		throw new AdminNotExistException("Admin not Found");
	}

	@Override
	public List<Vaccine> getAllVaccine() {
		return (List<Vaccine>) vaccineRepo.findAll();
	}

	@Override
	public List<Hospital> getAllHospitals() {
		return (List<Hospital>) hospitalRepo.findAll();
	}

	@Override
	public List<Vaccine> getAllVaccineByAge(int age){
		Iterable<Vaccine> l1 = vaccineRepo.findAll();
		List<Vaccine> l2 = new ArrayList<>();
		for(Vaccine v: l1) {
			if(v.getAgelimit() == age) {
				l2.add(v);
			}
		}return l2;
	}

	@Override
	public List<Vaccine> getAllVaccineByPrice(float price) {
		Iterable<Vaccine> l1 = vaccineRepo.findAll();
		List<Vaccine> l2 = new ArrayList<>();
		for(Vaccine v: l1) {
			if(v.getPrice() == price) {
				l2.add(v);
			}
		}return l2;
	}

	@Override
	public Admin getAdmin(int id) {
		Admin a1 = adminRepo.findById(id).orElse(null);
		return a1;
	}

	@Override
	public Admin getAdmin(String email) {
		Admin a1 = adminRepo.findByEmail(email);
		return a1;
	}

	@Override
	public Admin updateAdminByEmail(String email, AdminDto admin) {
		Admin a1 = adminRepo.findByEmail(email);
		User u1 = userRepo.findByUserName(email);
		if(a1 != null) {
			a1.setAdminName(admin.getAdminName());
			a1.setEmail(admin.getEmail());
			a1.setPassword(admin.getPassword());
			a1.setMobileNumber(admin.getMobileNumber());
			u1.setUserName(admin.getEmail());
			u1.setPassword(admin.getPassword());
			u1.setRole("admin");
			userRepo.save(u1);
			return adminRepo.save(a1);
		}else{
			throw new AdminNotExistException("Admin Not Found");
		}
	}
}

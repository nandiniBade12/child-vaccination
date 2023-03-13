package com.capg.ChildVaccination.Service;


import java.util.List;

import com.capg.ChildVaccination.Dto.AdminDto;
import com.capg.ChildVaccination.Entity.Admin;
import com.capg.ChildVaccination.Entity.Hospital;
import com.capg.ChildVaccination.Entity.Vaccine;
import com.capg.ChildVaccination.Exceptions.AdminNotExistException;
import com.capg.ChildVaccination.Exceptions.InValidEmailException;


public interface AdminService {

	Admin insertAdmin(AdminDto admin) throws InValidEmailException;

	Admin updateAdmin(int id, AdminDto admin)throws AdminNotExistException;

	Admin delAdmin(int id);

	List<Vaccine> getAllVaccine();

	List<Hospital> getAllHospitals();

	List<Vaccine> getAllVaccineByAge(int age);

	List<Vaccine> getAllVaccineByPrice(float price);

	Admin getAdmin(int id);

	Admin getAdmin(String email);

	Admin updateAdminByEmail(String email, AdminDto admin);

}

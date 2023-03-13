package com.capg.ChildVaccination.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capg.ChildVaccination.Dto.VaccineDto;
import com.capg.ChildVaccination.Dto.VaccineDto2;
import com.capg.ChildVaccination.Entity.Vaccine;
import com.capg.ChildVaccination.Exceptions.NoSuchVaccineIdExistsException;
import com.capg.ChildVaccination.Exceptions.VaccineIdAlreadyExistsException;


public interface VaccineService {
	public Vaccine addVaccine (VaccineDto vaccine)throws VaccineIdAlreadyExistsException;
	public Vaccine updateVaccinebyId(int id, VaccineDto2 vaccine) throws NoSuchVaccineIdExistsException;
	public Vaccine deleteVaccinebyId(int id) throws NoSuchVaccineIdExistsException;
    public Vaccine getVaccinebyId(int id);  
    public int CountOfVaccines(int doses);
    public List<Vaccine> viewAllVaccines();
    public List<Vaccine> viewVaccinebydose(int totaldoses); 
    public List<Vaccine>viewVaccinebyage(int agelimit);
    
    public Page<Vaccine> getVaccinePagination(Integer pageNumber, Integer pageSize, String sortProperty);
}

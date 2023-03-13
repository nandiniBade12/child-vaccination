package com.capg.ChildVaccination.Service;
import java.util.List;


import com.capg.ChildVaccination.Entity.Vaccine;
import com.capg.ChildVaccination.Exception.VaccineIdAlreadyExistsException;
import com.capg.ChildVaccination.Exception.NoSuchVaccineIdExistsException;

public interface VaccineService {
	public Vaccine addVaccine (Vaccine vaccine)throws VaccineIdAlreadyExistsException;
	public Vaccine updateVaccinebyId(int id, Vaccine vaccine) throws NoSuchVaccineIdExistsException;
	public Vaccine deleteVaccinebyId(int id) throws NoSuchVaccineIdExistsException;
    public Vaccine getVaccinebyId(int id);  
    public int CountOfVaccines(int doses);
    public List<Vaccine> viewAllVaccines();
    public List<Vaccine> viewVaccinebydose(int totaldoses); 
    public List<Vaccine>viewVaccinebyage(int agelimit);
}

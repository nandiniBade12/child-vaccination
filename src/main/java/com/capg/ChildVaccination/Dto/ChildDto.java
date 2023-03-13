package com.capg.ChildVaccination.Dto;

import com.capg.ChildVaccination.Entity.Gender;

public class ChildDto {
	
	public String name;
	public float weight;
	public int age;
	public Gender gender;
	
	
	public ChildDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public ChildDto(String name, float weight, int age, Gender gender) {
		super();
		this.name = name;
		this.weight = weight;
		this.age = age;
		this.gender = gender;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public float getWeight() {
		return weight;
	}



	public void setWeight(float weight) {
		this.weight = weight;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public Gender getGender() {
		return gender;
	}



	public void setGender(Gender gender) {
		this.gender = gender;
	}



	@Override
	public String toString() {
		return "ChildDto [name=" + name + ", weight=" + weight + ", age=" + age + ", gender=" + gender + "]";
	}



	
	



	

}

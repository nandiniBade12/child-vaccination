package com.capg.ChildVaccination.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Child {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int childId;
	private String name;
	private float weight;
	private int age;
	private Gender gender;
	
	@ManyToOne
	@JoinColumn(name = "parentid")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Parent parent;

	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	



	public Child(int childId, String name, float weight, int age, Gender gender, Parent parent) {
		super();
		this.childId = childId;
		this.name = name;
		this.weight = weight;
		this.age = age;
		this.gender = gender;
		this.parent = parent;
	}


	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
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

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}







	@Override
	public String toString() {
		return "Child [childId=" + childId + ", name=" + name + ", weight=" + weight + ", age=" + age + ", gender="
				+ gender + ", parent=" + parent + "]";
	}
	
	
	

	

	
	
	
	
}

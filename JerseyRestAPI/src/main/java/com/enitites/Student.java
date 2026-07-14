package com.enitites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student_Details")
public class Student {
	
  @Id
  private int id;	
  private String name;
  private int age;
  
  public Student() {
	super();
	// TODO Auto-generated constructor stub
  }

  
  public Student(String name, int age,int id) {
	super();
	this.name = name;
	this.age = age;
	this.id = id;
}

  public String getName() {
	return name;
  }

  public void setName(String name) {
	this.name = name;
  }

  public int getAge() {
	return age;
  }

  public void setAge(int age) {
	this.age = age;
  }


  public int getId() {
	return id;
  }


  public void setId(int id) {
	this.id = id;
  }
  
  
  
  
  
}

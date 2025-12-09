package com.project.employee_management_system.entity;

import org.hibernate.annotations.GenericGenerator;

import com.project.employee_management_system.entity.config.EmpIdGenrator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name="id", type=EmpIdGenrator.class)
	String id;
	String name;
	double salary;
	String designation;
	String address;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
}

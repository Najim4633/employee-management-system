package com.project.empcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.empcrud.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, String> {

}

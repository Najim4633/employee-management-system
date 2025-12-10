package com.project.employeemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.employeemanagementsystem.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, String> {

}

package com.project.employee_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.employee_management_system.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, String> {

}

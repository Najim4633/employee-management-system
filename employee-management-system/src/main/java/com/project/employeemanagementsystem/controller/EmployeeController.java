package com.project.employeemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.employeemanagementsystem.entity.Employee;
import com.project.employeemanagementsystem.repository.EmployeeDao;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeDao empDao;
	
	@GetMapping
    public Page<Employee> getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return empDao.findAll(PageRequest.of(page, size));
    }

    // Save employee
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee e) {
        return empDao.save(e);
    }
	
}

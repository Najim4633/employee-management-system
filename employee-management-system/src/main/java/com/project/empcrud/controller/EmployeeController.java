package com.project.empcrud.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.empcrud.entity.Employee;
import com.project.empcrud.repository.EmployeeDao;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao empDao;
	
	@GetMapping("/home")
	private String home() {
		return "home";
	}
	
    @GetMapping("/emplist")
    public String emplist(Model model) {

    	int page=0;
    	int size=5;
        Page<Employee> all = empDao.findAll(PageRequest.of(page, size));
        List<Employee> list = all.getContent();
        model.addAttribute("employees",list);

        return "emplist"; // loads emplist.jsp
    }

    @GetMapping("/empform")
    public String empform() {
        return "empform"; // loads empform.jsp
    }

    @GetMapping("/deleteemp")
    private String  deleteEmp(@RequestParam String  id ) {
    	empDao.deleteById(id);
    	return "redirect:/emplist";

	}
    
    @GetMapping("/updateemp")
    private String updateEmp(@RequestParam String id, Model model) {

        Optional<Employee> id2 = empDao.findById(id);

        if(id2.isPresent()) {
            Employee employee = id2.get();
            model.addAttribute("emp", employee);   // send to JSP
        }

        return "updateemp";   // JSP page name
    }
    @PostMapping("/updatedemp")
    private String updateEmployee(@ModelAttribute Employee e) {
        empDao.save(e);   // Spring updates existing record using ID
        return "redirect:/emplist";
    }
    

    // Save employee
    @PostMapping("/saveemp")
    public String saveEmployee(@ModelAttribute Employee e) {
    	empDao.save(e);
        return "redirect:/emplist";
    }

    
	
}

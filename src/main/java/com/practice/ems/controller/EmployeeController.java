package com.practice.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.ems.entity.Employee;
import com.practice.ems.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public String getAllEmployees(Model model) {
		//employeeService.getAllEmployees();
		model.addAttribute("employees",employeeService.getAllEmployees());
		return "employees";
	}
	
	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee",emp);
		return "create-employee-form";
	}
	
	@PostMapping("/employees")
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.addEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String updateEmployeeForm(Model model, @PathVariable("id") Long id) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "update-employee-form";
	}
	
	@PostMapping("/employees/{id}")
	public String updateEmployee(@ModelAttribute("employee") Employee employee, 
			@PathVariable("id") Long id) {
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setName(employee.getName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setSalary(employee.getSalary());
		employeeService.addEmployee(existingEmployee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employees";
	}
	
}

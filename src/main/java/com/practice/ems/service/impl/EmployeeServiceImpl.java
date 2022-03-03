package com.practice.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.ems.entity.Employee;
import com.practice.ems.repository.EmployeeRepository;
import com.practice.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}
	
	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
	
}

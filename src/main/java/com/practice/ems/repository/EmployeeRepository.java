package com.practice.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

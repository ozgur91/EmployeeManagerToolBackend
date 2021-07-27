package com.ozgur.Employeemanager.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;
import com.ozgur.Employeemanager.exception.UserNotFoundException;
import com.ozgur.Employeemanager.model.Employee;
import com.ozgur.Employeemanager.repo.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	private final EmployeeRepo employeeRepo ;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public Employee addEmployee(Employee emp) {
		
		emp.setEmployeeCode(UUID.randomUUID().toString());
		
		return employeeRepo.save(emp);
	}
	
	public List<Employee> findAllEmployees(){
		
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Employee emp) {
		
		return employeeRepo.save(emp);
	}
	
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
	
	public Employee findEmployeeById(Long id) throws Throwable {
		
		return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User was not found by id - " + id));
	}

	
}

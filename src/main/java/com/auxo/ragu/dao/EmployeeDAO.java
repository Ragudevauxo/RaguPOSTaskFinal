package com.auxo.ragu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auxo.ragu.model.Employee;
import com.auxo.ragu.repository.EmployeeRepository;

@Service
public class EmployeeDAO {
	@Autowired
	EmployeeRepository emprepo;
	
	//To save an employee
	public Employee save(Employee emp) {
		return emprepo.save(emp);
	}
	
	
	//To search all employee
	public List<Employee> findAll(){
		return emprepo.findAll();
	}
	
	//To get an employee by id 
	public Employee findOne(int empid) {
		return emprepo.findById(empid).orElse(null);
	}
	
	
	//To delete an employee
	public void delete(Employee emp) {
		emprepo.delete(emp);
	}

}

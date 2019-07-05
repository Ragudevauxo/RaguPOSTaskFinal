package com.auxo.ragu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auxo.ragu.dao.EmployeeDAO;
import com.auxo.ragu.model.Employee;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	EmployeeDAO empDAO;
	
	/* To save an employee*/
	@PostMapping("/empsave")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return empDAO.save(emp);
	}
	
	/* To get all employee details*/
	
	@GetMapping("empget")
	public List<Employee> getAllEmployees(){
		return empDAO.findAll();
	}
	
	/*To get employee by employee id*/
	
	@GetMapping("/empget/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") int empid){
		Employee emp = empDAO.findOne(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	
	/*To update an employee by Employee id*/
	
	@PutMapping("/empupdate/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") int empid,@Valid @RequestBody Employee empDetails){
		
		Employee emp = empDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setEmp_name(empDetails.getEmpname());
		emp.setAge(empDetails.getAge());
		emp.setDate(empDetails.getDate());
		emp.setPhone(empDetails.getPhone());
		emp.setPlace(emp.getPlace());
		emp.setDprtid(empDetails.getDprtid());
		
		Employee updateEmployee=empDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
		
	}
	/*To Delete an employee by id*/
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") int empid){
		Employee emp = empDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		empDAO.delete(emp);
		return ResponseEntity.ok().build();
	}
	
	

}




























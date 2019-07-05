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

import com.auxo.ragu.dao.DepartmentDAO;
import com.auxo.ragu.model.Department;
@RestController
@RequestMapping("/Department")
public class DepartmentController {
	
	@Autowired
	DepartmentDAO dprtDAO;
	
	/* To save an department*/
	
	@PostMapping("/dprtsave")
	public Department createEmployee(@Valid @RequestBody Department dprt) {
		return dprtDAO.save(dprt);
	}
	
	/* To get all department details*/
	
	@GetMapping("/dprtget")
	public List<Department> getAllDepartments(){
		return dprtDAO.findAll();
	}
	
	/*To get department by department id*/
	
	@GetMapping("/dprtget/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable(value="id") int dprtid){
		Department dprt = dprtDAO.findOne(dprtid);
		
		if(dprt==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(dprt);
	}
	
	/*To update an department by department id*/
	
	@PutMapping("/dprtupdate/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable(value="id") int dprtid,@Valid @RequestBody Department dprtDetails){
		
		Department dprt = dprtDAO.findOne(dprtid);
		if(dprt==null) {
			return ResponseEntity.notFound().build();
		}
		
		dprt.setDprtid((int) dprtDetails.getDprtid());
	
		Department updateDepartment=dprtDAO.save(dprt);
		return ResponseEntity.ok().body(updateDepartment);
		
	}
	
	/*To Delete an department by department id*/
	
	@DeleteMapping("/dprtdelete/{id}")
	public ResponseEntity<Department> deleteEmployee(@PathVariable(value="id") int dprtid){
		Department dprt = dprtDAO.findOne(dprtid);
		if(dprt==null) {
			return ResponseEntity.notFound().build();
		}
		
		dprtDAO.delete(dprt);
		return ResponseEntity.ok().build();
	}
}


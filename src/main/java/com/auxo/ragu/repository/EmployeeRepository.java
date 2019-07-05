package com.auxo.ragu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.auxo.ragu.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

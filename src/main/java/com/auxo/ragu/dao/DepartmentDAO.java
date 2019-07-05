package com.auxo.ragu.dao;
import com.auxo.ragu.repository.DepartmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auxo.ragu.model.*;


@Service
public class DepartmentDAO {
	@Autowired
	DepartmentRepository dprtrepo;
	//To save a department
	public Department save(Department dprt) {
		return dprtrepo.save(dprt);
	}
	
	
	//To search all department
	public List<Department> findAll(){
		return dprtrepo.findAll();
	}
	
	//To get a department value by id
	public Department findOne(int dprtid) {
		return dprtrepo.findById(dprtid).orElse(null);
	}
	
	
	//To  delete a employee by id
	public void delete(Department dprt) {
		dprtrepo.delete(dprt);
	}

}


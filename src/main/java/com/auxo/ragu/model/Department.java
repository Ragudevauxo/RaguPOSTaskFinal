package com.auxo.ragu.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Service;
@Entity
@Table(name = "Department")
@EntityListeners(AuditingEntityListener.class)


public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "dprtid")
	
	private int dprtid;
	
	
	@Column(name="Role")
    private String Role;
    
	
	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public long getDprtid() {
		return dprtid;
	}

	public void setDprtid(int dprtid) {
		this.dprtid = dprtid;
	}


	
}

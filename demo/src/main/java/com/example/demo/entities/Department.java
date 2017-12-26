package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Department_table")

public class Department {
	@Id
	@GeneratedValue
	@Column(name = "department_id", nullable=false, unique=true)
	
	private Long departmentId;
	
	
	@Column(name = "department_name")
	private String departmentName;
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String string) {
		this.departmentId = string;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}

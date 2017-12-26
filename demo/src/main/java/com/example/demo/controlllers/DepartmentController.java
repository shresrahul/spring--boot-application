package com.example.demo.controlllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Department;
import com.example.demo.repositories.DepartmentRepository;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentRepository departmentRepository;
	@PostMapping("/departments")
	public ResponseEntity<?> saveDepartment(@RequestBody Department department) {
		departmentRepository.save(department);
		return ResponseEntity.ok("new Student saved successfullly");
	}
	
	@GetMapping("/departments")
	public ResponseEntity<?> getDepartmentList() {
 List<Department> departmentList = departmentRepository.findAll();
		return ResponseEntity.ok(departmentList);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<?> updateDepartment(@RequestParam Long departmentId, @RequestBody Department department){
		Department oldDepartment=departmentRepository.findOne(departmentId);
		oldDepartment.setDepartmentName(department.getDepartmentName());
		return ResponseEntity.ok("Departmnet updated successfully");
	}
	
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/createDepartment")
	public Department createDepartment(@RequestBody Department departments) {
	Department savedDept = departmentService.createDepartment(departments);
		
		return savedDept;
	}
	
	@GetMapping("/retreiveData/{id}")
	public ResponseEntity<Department> retreiveDepartmentById(@PathVariable("id") Long deptId){
	Department retreivedDetails	= departmentService.retreiveDepartmentById(deptId);
		
		return new ResponseEntity<Department>(retreivedDetails, HttpStatus.OK);
	}

	@PutMapping("/updateDepartment/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable("id") Long deptId, @RequestBody Department departments){
	Department updatedData = departmentService.updateDepartment(deptId, departments);
		
	return new ResponseEntity<Department>(updatedData, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteDepartment/{id}")
	public void deleteDepartment(@PathVariable("id") Long deptId){
		
		departmentService.deleteDepartment(deptId);
	}
	
	@GetMapping("/retreiveAll")
	public ResponseEntity<Department> retreiveAllData(){
	List<Department> retreiveAll	= departmentService.retreiveAllData();
		
		return new ResponseEntity<Department>(HttpStatus.OK);
	}
	
	
}

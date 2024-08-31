package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.exceptions.NoSuchDepartmentFoundException;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {
	private final static Logger logger = LoggerFactory.getLogger(DepartmentService.class);
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public Department createDepartment(Department departments) {
	Department savedDept = departmentRepository.save(departments);
	logger.info("Department Created Successfully : {} " , savedDept.getDeptId());
		
		return savedDept;
	}

	public Department retreiveDepartmentById(Long deptId) {
		logger.info("Department Details was Retreiving !");
		
	Department retreivedDetails = departmentRepository.findById(deptId).orElseThrow(() -> 
	         new NoSuchDepartmentFoundException
			("Please Check Department Details, Department Not Found !"));
	
	    logger.info("Department Details Successfully Retreived :{} ", retreivedDetails.getDeptId());	
	
		return retreivedDetails;
	}
	
	public Department updateDepartment(Long deptId, Department departments) {
		logger.info("Department Details Was Updating ");
		
	Department existingData = departmentRepository.findById(deptId).orElse(null);
	
	if(existingData != null) {
		existingData.setName(departments.getName());
		existingData.setLocation(departments.getLocation());
		existingData.setEmployees(departments.getEmployees());
		
	Department updatedData = departmentRepository.save(existingData);
	return updatedData;
	}
	
	return null;
		
	}
	
	public void deleteDepartment(Long deptId) {
		departmentRepository.deleteById(deptId);
		
		logger.info("Department Data was Deleted Successfully ... {} " , deptId);
		
	}
	
	public List<Department> retreiveAllData() {
	List<Department> retreiveAll = departmentRepository.findAll();
	logger.info("Successfully Retreived All Data : {} ");
	
		return retreiveAll;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

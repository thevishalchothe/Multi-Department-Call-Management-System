package com.multidepartment.call_management.administrationservice.controller;

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

import com.multidepartment.call_management.administrationservice.model.Department;
import com.multidepartment.call_management.administrationservice.serviceI.DepartmentServiceI;

@RestController
@RequestMapping("/Departments")
public class DepartmentController {

	@Autowired
	private DepartmentServiceI departmentServiceI;

	// Create a new department
	@PostMapping("/create")
	public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
		Department createdDepartment = departmentServiceI.createDepartment(department);
		return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
	}

	// Get a department by ID
	@GetMapping("/getdepartment/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") String id) {
		Department department = departmentServiceI.getDepartmentById(id);
		if (department != null) {
			return new ResponseEntity<>(department, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Get all departments
	@GetMapping("/getall")
	public ResponseEntity<List<Department>> getAllDepartments() {
		List<Department> departments = departmentServiceI.getAllDepartments();
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}

	// Update an existing department
	@PutMapping("/update/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable("id") String id,
			@RequestBody Department department) {
		Department updatedDepartment = departmentServiceI.updateDepartment(id, department);
		if (updatedDepartment != null) {
			return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Delete a department
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") String id) {
		departmentServiceI.deleteDepartment(id);
		return new ResponseEntity<>("Department deleted successfully", HttpStatus.OK);
	}
	

}

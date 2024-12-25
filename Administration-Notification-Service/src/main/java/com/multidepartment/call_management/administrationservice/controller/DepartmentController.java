package com.multidepartment.call_management.administrationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.multidepartment.call_management.administrationservice.model.Department;
import com.multidepartment.call_management.administrationservice.serviceI.DepartmentServiceI;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentServiceI departmentServiceI;

    // Create a new department
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department createdDepartment = departmentServiceI.createDepartment(department);
        return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
    }

    // Get a department by ID
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable String id) {
        Department department = departmentServiceI.getDepartmentById(id);
        return department != null ? 
                new ResponseEntity<>(department, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get all departments
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentServiceI.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    // Update an existing department
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable String id, @RequestBody Department department) {
        Department updatedDepartment = departmentServiceI.updateDepartment(id, department);
        return updatedDepartment != null ?
                new ResponseEntity<>(updatedDepartment, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a department
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable String id) {
        departmentServiceI.deleteDepartment(id);
        return new ResponseEntity<>("Department deleted successfully", HttpStatus.OK);
    }

    // Get department by extension number
    @GetMapping("/extension/{extensionNumber}")
    public ResponseEntity<Department> getDepartmentByExtension(@PathVariable String extensionNumber) {
        Department department = departmentServiceI.getDepartmentByExtension(extensionNumber);
        return department != null ?
                new ResponseEntity<>(department, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

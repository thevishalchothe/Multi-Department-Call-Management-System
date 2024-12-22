package com.multidepartment.call_management.administrationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.multidepartment.call_management.administrationservice.model.Department;

public interface DepartmentRepository extends MongoRepository<Department, String> {

}

package com.multidepartment.call_management.administrationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.multidepartment.call_management.administrationservice.model.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
	
    Department findByExtensionNumber(String extensionNumber);

}

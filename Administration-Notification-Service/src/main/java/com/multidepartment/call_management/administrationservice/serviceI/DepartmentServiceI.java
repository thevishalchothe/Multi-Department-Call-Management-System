package com.multidepartment.call_management.administrationservice.serviceI;

import java.util.List;

import com.multidepartment.call_management.administrationservice.model.Department;

public interface DepartmentServiceI {

	Department createDepartment(Department department);

	Department getDepartmentById(String id);

	List<Department> getAllDepartments();

	Department updateDepartment(String id, Department department);

	void deleteDepartment(String id);

	Department getDepartmentByExtension(String extensionNumber);

}

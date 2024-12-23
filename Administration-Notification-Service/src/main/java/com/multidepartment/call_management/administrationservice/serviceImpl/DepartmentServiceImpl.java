package com.multidepartment.call_management.administrationservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multidepartment.call_management.administrationservice.model.Department;
import com.multidepartment.call_management.administrationservice.repository.DepartmentRepository;
import com.multidepartment.call_management.administrationservice.serviceI.DepartmentServiceI;

@Service
public class DepartmentServiceImpl implements DepartmentServiceI {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department getDepartmentById(String id) {
		Optional<Department> department = departmentRepository.findById(id);
		return department.orElse(null); // Return null if not found
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department updateDepartment(String id, Department department) {
		if (departmentRepository.existsById(id)) {
			department.setId(id); // Update the department ID
			return departmentRepository.save(department);
		} else {
			return null; // Return null if the department doesn't exist
		}
	}

	@Override
	public void deleteDepartment(String id) {
		departmentRepository.deleteById(id);
	}

}

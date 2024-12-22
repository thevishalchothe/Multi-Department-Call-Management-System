package com.multidepartment.call_management.administrationservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multidepartment.call_management.administrationservice.repository.DepartmentRepository;
import com.multidepartment.call_management.administrationservice.serviceI.DepartmentServiceI;

@Service
public class DepartmentServiceImpl implements DepartmentServiceI {

	@Autowired
	private DepartmentRepository departmentRepository;

}

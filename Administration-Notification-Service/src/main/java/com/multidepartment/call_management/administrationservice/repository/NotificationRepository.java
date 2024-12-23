package com.multidepartment.call_management.administrationservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.multidepartment.call_management.administrationservice.model.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String> {

	// Custom query to find notifications by department ID
	List<Notification> findByDepartmentId(String departmentId);

}

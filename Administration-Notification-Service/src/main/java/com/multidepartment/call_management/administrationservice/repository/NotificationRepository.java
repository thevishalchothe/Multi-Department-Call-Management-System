package com.multidepartment.call_management.administrationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.multidepartment.call_management.administrationservice.model.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String>{
	

}

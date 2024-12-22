package com.multidepartment.call_management.comunicationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.multidepartment.call_management.comunicationservice.model.CallLog;

public interface CallLogRepository extends MongoRepository<CallLog, String> {
	

}

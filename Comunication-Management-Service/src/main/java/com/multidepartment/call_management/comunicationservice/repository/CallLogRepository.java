package com.multidepartment.call_management.comunicationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.multidepartment.call_management.comunicationservice.model.CallLog;

@Repository
public interface CallLogRepository extends MongoRepository<CallLog, String> {
	

}

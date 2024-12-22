package com.multidepartment.call_management.comunicationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.multidepartment.call_management.comunicationservice.model.CallRouting;

public interface CallRoutingRepository extends MongoRepository<CallRouting, String> {

}

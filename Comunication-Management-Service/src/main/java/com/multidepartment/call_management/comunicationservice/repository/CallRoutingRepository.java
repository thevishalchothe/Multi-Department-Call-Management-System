package com.multidepartment.call_management.comunicationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.multidepartment.call_management.comunicationservice.model.CallRouting;

@Repository
public interface CallRoutingRepository extends MongoRepository<CallRouting, String> {

}

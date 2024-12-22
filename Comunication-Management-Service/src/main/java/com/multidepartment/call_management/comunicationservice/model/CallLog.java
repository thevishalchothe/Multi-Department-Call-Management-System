package com.multidepartment.call_management.comunicationservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "call_logs") // This specifies the MongoDB collection name
@Data
public class CallLog {
	
   
}

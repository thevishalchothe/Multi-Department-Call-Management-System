package com.multidepartment.call_management.comunicationservice.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "call_logs")
public class CallLog {
	
    @Id
    private String id;
    private String sourceNumber;        // Caller number
    private String destinationNumber;   // Receiver/department
    private LocalDateTime callTime;     // Timestamp of the call
    private String callType;            // NORMAL, EMERGENCY, ROUTED
    
}


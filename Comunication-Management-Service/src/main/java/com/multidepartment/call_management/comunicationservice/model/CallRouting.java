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
@Document(collection = "call_routing")
public class CallRouting {

    @Id
    private String id;

    // Call Routing Details
    private String sourceNumber;        // Caller number (from the source, i.e., extension dialed)
    private String extension;           // Department extension dialed
    
    // Call Log Details
    private String destinationNumber;   // Receiver/department mobile number (destination number)
    private LocalDateTime callTime;     // Timestamp of the call
    private String callType;            // Type of the call (NORMAL, EMERGENCY)
    
    // Routing Status (Success/Failure)
    private String routingStatus;       // Status of call routing (e.g., "SUCCESS", "FAILED")
}

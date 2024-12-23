package com.multidepartment.call_management.administrationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "notifications")
public class Notification {

    @Id
    private String id;
    private String message;           // Notification message
    private LocalDateTime timestamp;  // Time the notification was generated
    private String type;              // Type: MISSED_CALL, EMERGENCY, INFO
    private String departmentId;      // The department that the notification is for
    
}

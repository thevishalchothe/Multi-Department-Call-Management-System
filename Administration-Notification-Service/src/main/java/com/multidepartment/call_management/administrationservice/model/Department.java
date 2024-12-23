package com.multidepartment.call_management.administrationservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "departments")
public class Department {
    
    @Id
    private String id;
    private String name;                // Department name, e.g., HR
    private String extensionNumber;     // Extension number, e.g., "1"
    private String contactEmail;        // Contact email of the department
    private String mobileNumber;        // Department mobile number (to be dialed when the extension is called)
    
}

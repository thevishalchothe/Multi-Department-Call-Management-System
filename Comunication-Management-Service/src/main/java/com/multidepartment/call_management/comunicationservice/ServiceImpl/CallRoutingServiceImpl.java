package com.multidepartment.call_management.comunicationservice.ServiceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.multidepartment.call_management.comunicationservice.ServiceI.CallRoutingServiceI;
import com.multidepartment.call_management.comunicationservice.dto.Department;
import com.multidepartment.call_management.comunicationservice.model.CallLog;
import com.multidepartment.call_management.comunicationservice.model.CallRouting;
import com.multidepartment.call_management.comunicationservice.repository.CallRoutingRepository;
import com.multidepartment.call_management.comunicationservice.repository.CallLogRepository;

@Service
public class CallRoutingServiceImpl implements CallRoutingServiceI {

    @Autowired
    private CallRoutingRepository callRoutingRepository;

    @Autowired
    private CallLogRepository callLogRepository;  // Make sure this is injected for saving logs

    @Autowired
    private RestTemplate restTemplate;  // To make HTTP calls to the administration service

    private static final String ADMINISTRATION_SERVICE_URL = "http://localhost:8082/departments/extension/";

    @Override
    public String routeCallByExtension(String extensionNumber) {
        // Set the default routing status to "FAILED"
        String routingStatus = "FAILED";

        try {
            // Fetch the department details from the administration service using RestTemplate
            String departmentUrl = ADMINISTRATION_SERVICE_URL + extensionNumber;
            Department department = restTemplate.getForObject(departmentUrl, Department.class);

            if (department != null) {
                // Retrieve department information
                String departmentName = department.getName(); // Get the department name (e.g., HR, Developer, etc.)
                String destinationNumber = department.getMobileNumber(); // Get the department's mobile number

                // Determine the call type (could be dynamically fetched from a database or config)
                String callType = "NORMAL"; // Replace with actual logic to fetch call type

                // If department is found, set routing status to SUCCESS
                routingStatus = "SUCCESS";

                // Create a new CallRouting object to store routing information
                CallRouting callRouting = new CallRouting();
                callRouting.setSourceNumber(extensionNumber); // The extension number dialed
                callRouting.setExtension(extensionNumber); // The extension number dialed (same as source number in this case)
                callRouting.setDestinationNumber(destinationNumber); // The department's mobile number
                callRouting.setCallTime(LocalDateTime.now()); // Set the current timestamp
                callRouting.setCallType(callType); // Set the call type (NORMAL or EMERGENCY)
                callRouting.setRoutingStatus(routingStatus); // Set routing status (SUCCESS)

                // Save the routing details in the database
                callRoutingRepository.save(callRouting);

                // Log the call details in the CallLog table (same as before)
                CallLog callLog = new CallLog();
                callLog.setSourceNumber(extensionNumber);
                callLog.setDestinationNumber(destinationNumber);
                callLog.setCallTime(LocalDateTime.now());
                callLog.setCallType(callType); // Save the dynamic callType in CallLog
                callLogRepository.save(callLog); // Save the call log in the database

                // Return success message
                return "Call successfully routed to " + departmentName + " at: " + destinationNumber;
            } else {
                // If the department with the given extension number is not found, log failure
                return logFailedRouting(extensionNumber, routingStatus);
            }
        } catch (Exception e) {
            // If an exception occurs, log the failure
            return logFailedRouting(extensionNumber, routingStatus, e.getMessage());
        }
    }

    private String logFailedRouting(String extensionNumber, String routingStatus) {
        return logFailedRouting(extensionNumber, routingStatus, "Invalid extension or error occurred.");
    }

    private String logFailedRouting(String extensionNumber, String routingStatus, String errorMessage) {
        // Log the failed routing attempt in the database
        CallRouting failedRouting = new CallRouting();
        failedRouting.setSourceNumber(extensionNumber);
        failedRouting.setExtension(extensionNumber);
        failedRouting.setRoutingStatus(routingStatus);
        failedRouting.setCallTime(LocalDateTime.now());
        failedRouting.setCallType("FAILED"); // Failed routing log type
        failedRouting.setDestinationNumber(null); // No valid destination number in case of failure
        // Save the failed routing log
        callRoutingRepository.save(failedRouting);

        // Return failure message
        return "Error routing call: " + errorMessage;
    }
}

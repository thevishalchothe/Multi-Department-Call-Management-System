package com.multidepartment.call_management.comunicationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multidepartment.call_management.comunicationservice.ServiceI.CallRoutingServiceI;

@RestController
@RequestMapping("/callroutes")
public class CallRoutingController {

    @Autowired
    private CallRoutingServiceI callRoutingServiceI;

    // Route the call to a department based on the extension number
    @PostMapping("/route")
    public ResponseEntity<String> routeCall(@RequestParam String extensionNumber) {
        // Call the service method to route the call and get the destination number
        String result = callRoutingServiceI.routeCallByExtension(extensionNumber);
        
        // Return the response with HTTP status CREATED if the routing was successful
        if (result != null && !result.contains("Invalid")) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}

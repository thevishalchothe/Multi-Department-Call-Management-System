package com.multidepartment.call_management.comunicationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multidepartment.call_management.comunicationservice.ServiceI.CallRoutingServiceI;
import com.multidepartment.call_management.comunicationservice.model.CallRouting;

@RestController
@RequestMapping("/api/calls/route")
public class CallRoutingController {

	 @Autowired
	    private CallRoutingServiceI callRoutingServiceI;

	 @PostMapping("/route")
	    public ResponseEntity<String> routeCall(@RequestBody CallRouting callRouting) {
	        String response = callRoutingServiceI.routeCall(callRouting);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }
}

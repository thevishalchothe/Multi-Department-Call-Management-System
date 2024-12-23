package com.multidepartment.call_management.comunicationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multidepartment.call_management.comunicationservice.ServiceI.CallRoutingServiceI;

@RestController
@RequestMapping("/api/calls/route")
public class CallRoutingController {

	 @Autowired
	    private CallRoutingServiceI callRoutingServiceI;

	   
}

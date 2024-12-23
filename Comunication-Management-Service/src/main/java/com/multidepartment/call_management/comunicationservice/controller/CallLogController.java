package com.multidepartment.call_management.comunicationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multidepartment.call_management.comunicationservice.ServiceI.CallLogServiceI;
import com.multidepartment.call_management.comunicationservice.model.CallLog;

	@RestController
	@RequestMapping("/call-logs")
	public class CallLogController {

	    @Autowired
	    private CallLogServiceI callLogServiceI;

	    // Add new CallLog
	    @PostMapping("/add")
	    public ResponseEntity<CallLog> addCallLog(@RequestBody CallLog callLog) {
	        CallLog createdCallLog = callLogServiceI.saveCallLog(callLog);
	        return new ResponseEntity<>(createdCallLog, HttpStatus.CREATED);
	    }

	    // Get all CallLogs
	    @GetMapping("/getAll")
	    public ResponseEntity<List<CallLog>> getAllCallLogs() {
	        List<CallLog> callLogs = callLogServiceI.getAllCallLogs();
	        return new ResponseEntity<>(callLogs, HttpStatus.OK);
	    }

	    // Get CallLog by ID
	    @GetMapping("/getsingle/{id}")
	    public ResponseEntity<CallLog> getCallLogById(@PathVariable String id) {
	        CallLog callLog = callLogServiceI.getCallLogById(id);
	        return new ResponseEntity<>(callLog, HttpStatus.OK);
	    }

	    // Update CallLog by ID
	    @PatchMapping("/update/{id}")
	    public ResponseEntity<CallLog> updateCallLog(@RequestBody CallLog callLog, @PathVariable String id) {
	        CallLog updatedCallLog = callLogServiceI.updateCallLog(callLog, id);
	        return new ResponseEntity<>(updatedCallLog, HttpStatus.OK);
	    }

	    // Delete CallLog by ID
	    @DeleteMapping("/deletesingle/{id}")
	    public ResponseEntity<String> deleteCallLog(@PathVariable String id) {
	        callLogServiceI.deleteCallLog(id);
	        return new ResponseEntity<>("CallLog deleted successfully", HttpStatus.NO_CONTENT);
	    }

	    // Delete all CallLogs
	    @DeleteMapping("/deleteAll")
	    public ResponseEntity<String> deleteAllCallLogs() {
	        callLogServiceI.deleteAllCallLogs();
	        return new ResponseEntity<>("All CallLogs deleted successfully", HttpStatus.NO_CONTENT);
	    }
	
}

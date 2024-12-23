package com.multidepartment.call_management.comunicationservice.model;

import lombok.Data;

@Data
public class CallRouting {

	private String sourceNumber; // Caller number
	private String extension; // Department extension dialed
}

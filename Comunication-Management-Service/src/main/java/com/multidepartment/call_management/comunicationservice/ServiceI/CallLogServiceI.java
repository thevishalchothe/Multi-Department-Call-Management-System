package com.multidepartment.call_management.comunicationservice.ServiceI;

import java.util.List;

import com.multidepartment.call_management.comunicationservice.model.CallLog;

public interface CallLogServiceI {

	CallLog saveCallLog(CallLog callLog);

	List<CallLog> getAllCallLogs();

	CallLog getCallLogById(String id);

	CallLog updateCallLog(CallLog callLog, String id);

	void deleteCallLog(String id);

	void deleteAllCallLogs();

	

}


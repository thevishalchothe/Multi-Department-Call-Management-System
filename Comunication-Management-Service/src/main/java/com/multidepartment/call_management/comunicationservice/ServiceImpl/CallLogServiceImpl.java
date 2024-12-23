package com.multidepartment.call_management.comunicationservice.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multidepartment.call_management.comunicationservice.ServiceI.CallLogServiceI;
import com.multidepartment.call_management.comunicationservice.model.CallLog;
import com.multidepartment.call_management.comunicationservice.repository.CallLogRepository;

@Service
public class CallLogServiceImpl implements CallLogServiceI {

	@Autowired
	private CallLogRepository callLogRepository;

	@Override
	public CallLog saveCallLog(CallLog callLog) {
		return callLogRepository.save(callLog);
	}

	@Override
	public List<CallLog> getAllCallLogs() {
		return callLogRepository.findAll();
	}

	@Override
	public CallLog getCallLogById(String id) {
		Optional<CallLog> callLog = callLogRepository.findById(id);
		return callLog.orElseThrow(() -> new RuntimeException("CallLog not found with id: " + id));
	}

	@Override
	public CallLog updateCallLog(CallLog callLog, String id) {
		CallLog existingCallLog = getCallLogById(id);
		existingCallLog.setSourceNumber(callLog.getSourceNumber());
		existingCallLog.setDestinationNumber(callLog.getDestinationNumber());
		existingCallLog.setCallTime(callLog.getCallTime());
		existingCallLog.setCallType(callLog.getCallType());
		return callLogRepository.save(existingCallLog);
	}

	@Override
	public void deleteCallLog(String id) {
		callLogRepository.deleteById(id);
	}

	@Override
	public void deleteAllCallLogs() {
		callLogRepository.deleteAll();
	}

}

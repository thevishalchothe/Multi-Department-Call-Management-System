package com.multidepartment.call_management.comunicationservice.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multidepartment.call_management.comunicationservice.ServiceI.CallLogServiceI;
import com.multidepartment.call_management.comunicationservice.repository.CallLogRepository;

@Service
public class CallLogServiceImpl implements CallLogServiceI {

	@Autowired
	private CallLogRepository callLogRepository;

	

}

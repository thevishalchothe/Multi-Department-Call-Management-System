package com.multidepartment.call_management.comunicationservice.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.multidepartment.call_management.comunicationservice.ServiceI.CallRoutingServiceI;
import com.multidepartment.call_management.comunicationservice.repository.CallRoutingRepository;

@Service
public class CallRoutingServiceImpl implements CallRoutingServiceI {

    @Autowired
    private CallRoutingRepository callRoutingRepository;

    @Autowired
    private RestTemplate restTemplate;

   
}

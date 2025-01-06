package com.example.demo.delegates;

import com.example.demo.controllers.ProcessController;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component("getPartInfoDelegate")
public class GetPartInfoDelegate implements JavaDelegate {

    private static final Logger logger = LoggerFactory.getLogger(GetPartInfoDelegate.class);

    @Override
    public void execute(DelegateExecution execution) {
        // Simulate fetching part info
        logger.info("Fetching part info...");
        execution.setVariable("partAvailable", true); // Example variable
    }
}


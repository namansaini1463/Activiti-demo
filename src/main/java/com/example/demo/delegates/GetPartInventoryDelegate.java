package com.example.demo.delegates;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.helpers.NOPLogger;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component("getPartInventoryDelegate")
public class GetPartInventoryDelegate implements JavaDelegate {

    private static final Logger logger = LoggerFactory.getLogger(GetPartInventoryDelegate.class);

    @Override
    public void execute(DelegateExecution execution) {
        // Fetch the process variable 'partAvailable'
        Boolean partAvailable = (Boolean) execution.getVariable("partAvailable");

        // Log the value for debugging
        logger.info("Delegate Received partAvailable = {}", partAvailable);
    }
}


package com.example.demo.delegates;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component("cancelOrderDelegate")
public class CancelOrderDelegate implements JavaDelegate {
    private static final Logger logger = LoggerFactory.getLogger(CancelOrderDelegate.class);
    @Override
    public void execute(DelegateExecution execution) {
        logger.info("Cancelling order...");
    }
}
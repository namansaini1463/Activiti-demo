package com.example.demo.controllers;

import org.springframework.ui.Model;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ProcessController {

    private static final Logger logger = LoggerFactory.getLogger(ProcessController.class);

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/form")
    public String showForm() {
        return "form"; // Renders the form.html template
    }

    // Starting the process and decide routing based on part availability.
    @GetMapping("/start-process")
    public RedirectView startProcess(@RequestParam boolean partAvailable) { // Query param for the status of the part availability
        logger.info("Received partAvailable = {}", partAvailable);

        // Start the process and set the process variable
        Map<String, Object> variables = new HashMap<>();
        variables.put("partAvailable", partAvailable);
        runtimeService.startProcessInstanceByKey("partOrderProcess", variables);
        logger.info("Process started with partAvailable = {}", partAvailable);

        // Decide redirect path based on the part availability
        String redirectPath = partAvailable ? "/success" : "/failure";
        return new RedirectView(redirectPath);
    }

    // Handle the success route when the part is available
    @GetMapping("/success")
    public String successPage(Model model) {
        logger.info("Rendering success page...");
        model.addAttribute("message", "Part is available! Proceeding with shipping.");
        return "success"; // Resolves to success.html template
    }

    // Handle the failure route when the part is not available
    @GetMapping("/failure")
    public String failurePage(Model model) {
        logger.info("Rendering failure page...");
        model.addAttribute("message", "Part is not available. Order canceled.");
        return "failure"; // Resolves to failure.html template
    }
}

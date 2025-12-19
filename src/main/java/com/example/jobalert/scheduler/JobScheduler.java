package com.example.jobalert.scheduler;

import com.example.jobalert.service.LinkedInEmailReader;
import com.example.jobalert.service.JobFilterService;
import com.example.jobalert.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobScheduler {

    @Autowired
    private LinkedInEmailReader emailReader;

    @Autowired
    private JobFilterService filter;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 */1 * * * ?") // triggers every 1 minute for testing
    public void sendJobAlerts() {
        System.out.println("Scheduler triggered!");
        System.out.println("Sending email to: viggneshreddy@gmail.com");
        // your email sending code here
    }
}


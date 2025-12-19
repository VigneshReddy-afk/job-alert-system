package com.example.jobalert.service;

import com.example.jobalert.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(List<Job> jobs) {

        if (jobs.isEmpty()) return;

        StringBuilder body = new StringBuilder("Today's Fresher IT Jobs:\n\n");

        for (Job job : jobs) {
            body.append(job.getTitle()).append("\n")
                .append(job.getLink()).append("\n\n");
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("viggneshreddy@gmail.com");
        message.setSubject("Daily Job Alerts");
        message.setText(body.toString());

        mailSender.send(message);
    }
}

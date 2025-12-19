package com.example.jobalert.service;

import com.example.jobalert.model.Job;
import jakarta.mail.*;
import jakarta.mail.search.SubjectTerm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class LinkedInEmailReader {

    @Value("${mail.imap.username}")
    private String username;

    @Value("${mail.imap.password}")
    private String password;

    public List<Job> readJobsFromEmail() {

        List<Job> jobs = new ArrayList<>();

        try {
            Properties props = new Properties();
            props.put("mail.store.protocol", "imaps");

            Session session = Session.getInstance(props);
            Store store = session.getStore();
            store.connect("imap.gmail.com", username, password);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.search(
                    new SubjectTerm("LinkedIn Job Alert")
            );

            for (int i = Math.max(0, messages.length - 10); i < messages.length; i++) {
                Message msg = messages[i];
                String content = msg.getContent().toString();

                // VERY SIMPLE parsing (safe for fresher project)
                if (content.contains("Apply")) {
                    Job job = new Job();
                    job.setTitle("LinkedIn Job Opportunity");
                    job.setLink("Check your LinkedIn email");
                    jobs.add(job);
                }
            }

            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jobs;
    }
}

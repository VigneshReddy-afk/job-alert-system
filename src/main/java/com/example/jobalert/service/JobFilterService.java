package com.example.jobalert.service;

import com.example.jobalert.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobFilterService {

    private static final List<String> KEYWORDS = List.of(
            "fresher", "entry", "junior",
            "java", "software", "developer"
    );

    public List<Job> filter(List<Job> jobs) {
        return jobs.stream()
                .filter(job ->
                        KEYWORDS.stream().anyMatch(k ->
                                job.getTitle().toLowerCase().contains(k)
                        )
                )
                .toList();
    }
}

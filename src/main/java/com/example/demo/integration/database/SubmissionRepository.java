package com.example.demo.integration.database;

import com.example.demo.domain.submission.Submission;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface SubmissionRepository extends MongoRepository<Submission, String> {
    List<Submission> findByDateCreate(LocalDate date);
}

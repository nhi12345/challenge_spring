package com.example.demo.integration.database;

import com.example.demo.domain.submission.Submission;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubmissionRepository extends MongoRepository<Submission, String> {
}

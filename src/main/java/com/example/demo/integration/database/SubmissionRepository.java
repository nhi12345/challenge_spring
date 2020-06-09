package com.example.demo.integration.database;

import com.example.demo.domain.challenge.Challenge;
import com.example.demo.domain.employee.Employee;
import com.example.demo.domain.submission.Submission;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SubmissionRepository extends MongoRepository<Submission, String> {
    List<Submission> findByDateCreated(LocalDate date);

    Optional<Submission> findByChallengeAndEmployeeAndDateCreated(Challenge challenge, Employee employee, LocalDate date);

    List<Submission> findByChallengeAndEmployee(Challenge challenge, Employee employee);
}

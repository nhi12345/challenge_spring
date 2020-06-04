package com.example.demo.domain.submission;

import com.example.demo.domain.challenge.Challenge;
import com.example.demo.domain.challenge.ChallengeService;
import com.example.demo.domain.employee.Employee;
import com.example.demo.domain.file.exception.BadRequestException;
import com.example.demo.integration.database.SubmissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private ChallengeService challengeService;

    public List<Submission> getSubmissionByDate(String time){
        long duration = Long.parseLong(time);
        LocalDate date = Instant.ofEpochSecond(duration).atZone(ZoneId.systemDefault()).toLocalDate();
        return submissionRepository.findByDateCreated(date);
    }

    public Submission addSubmission(final String currentEmployeeEmail, Submission submission){
        Challenge currentChallenge = challengeService.getCurrentChallenge();
        Employee currentEmployee = Employee.builder().email(currentEmployeeEmail).build();
        Optional<Submission> submissionFilter = submissionRepository.findByChallengeAndEmployeeAndDateCreated(currentChallenge, currentEmployee, LocalDate.now());
        if(submissionFilter.isPresent()){
            throw new BadRequestException("existed");
        }
        submission.setChallenge(currentChallenge);
        submission.setEmployee(currentEmployee);
        submission.setDateCreated(LocalDate.now());
        return submissionRepository.save(submission);
    }

}

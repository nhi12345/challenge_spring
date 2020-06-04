package com.example.demo.domain.submission;

import com.example.demo.integration.database.SubmissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    public List<Submission> getSubmissionByDate(Timestamp timeStamp){
        LocalDate dateRequest = timeStamp.toLocalDateTime().toLocalDate();
        return submissionRepository.findByDateCreate(dateRequest);
    }
}

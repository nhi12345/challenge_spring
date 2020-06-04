package com.example.demo.rest.submission;

import com.example.demo.domain.submission.Submission;
import com.example.demo.domain.submission.SubmissionService;
import com.example.demo.rest.submission.vm.SubmissionDto;
import com.example.demo.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/scoreboards")
public class SubmissionResource {

    @Autowired
    private SubmissionService service;

    @Autowired
    private SubmissionMapper submissionMapper;

    @GetMapping
    public List<SubmissionDto> getSubmissionByDate(@RequestParam("date")String time){
        return submissionMapper.toSubmissionDtos(service.getSubmissionByDate(time));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubmissionDto addSubmission(@RequestBody @Valid SubmissionDto submissionDto){
        final String emailCurrent = SecurityUtils.getCurrentUserEmail();
        final Submission submission= service.addSubmission(emailCurrent,submissionMapper.toSubmission(submissionDto));
        return submissionMapper.toSubmissionDto(submission);
    }
}

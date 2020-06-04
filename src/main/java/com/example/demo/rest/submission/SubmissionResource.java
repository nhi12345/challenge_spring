package com.example.demo.rest.submission;

import com.example.demo.domain.submission.SubmissionService;
import com.example.demo.rest.submission.vm.SubmissionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

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
}

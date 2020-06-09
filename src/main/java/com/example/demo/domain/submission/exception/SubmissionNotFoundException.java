package com.example.demo.domain.submission.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SubmissionNotFoundException extends RuntimeException {
    public SubmissionNotFoundException(String submissionId) {
        super(String.format("Submission with id '%s' not found", submissionId));
    }
}

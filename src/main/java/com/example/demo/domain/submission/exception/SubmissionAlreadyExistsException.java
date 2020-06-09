package com.example.demo.domain.submission.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SubmissionAlreadyExistsException extends RuntimeException{
    public SubmissionAlreadyExistsException(){
        super("Submission this day already exist");
    }
}

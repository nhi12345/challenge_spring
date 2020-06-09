package com.example.demo.domain.file.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FileInvalidException extends RuntimeException{
    public FileInvalidException(String exception) {
        super(exception);
    }
}

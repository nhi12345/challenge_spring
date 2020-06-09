package com.example.demo.domain.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ChallengeExpiredException extends RuntimeException{
    public ChallengeExpiredException(){
        super("Challenge is expired");
    }
}

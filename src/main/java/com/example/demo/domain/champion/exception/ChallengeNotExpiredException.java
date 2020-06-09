package com.example.demo.domain.champion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ChallengeNotExpiredException extends RuntimeException {
    public ChallengeNotExpiredException(){
        super("Challenge not expired");
    }
}

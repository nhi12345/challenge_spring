package com.example.demo.domain.champion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ChampionAlreadyExistsException extends RuntimeException{

    public ChampionAlreadyExistsException(String challengeId) {
        super(String.format("Champion of challenge with id '%s' already exists.", challengeId));
    }
}

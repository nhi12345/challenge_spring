package com.example.demo.domain.champion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ChampionNotFoundException extends RuntimeException{

    public ChampionNotFoundException(String challengeId) {
        super(String.format("Champion of challenge with id '%s' not found", challengeId));
    }
}

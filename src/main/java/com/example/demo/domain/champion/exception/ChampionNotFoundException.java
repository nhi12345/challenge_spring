package com.example.demo.domain.champion.exception;

public class ChampionNotFoundException extends RuntimeException{

    public ChampionNotFoundException(String challengeId) {
        super(String.format("Champion of challenge with id '%s' not found", challengeId));
    }
}

package com.example.demo.domain.champion.exception;

public class ChampionNotFoundException extends RuntimeException{

    public ChampionNotFoundException(String championId) {
        super(String.format("Activity with id '%s' not found", championId));
    }
}

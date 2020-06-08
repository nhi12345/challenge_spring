package com.example.demo.integration.database;

import com.example.demo.domain.challenge.Challenge;
import com.example.demo.domain.champion.Champion;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ChampionRepository extends MongoRepository<Champion,String> {
    Optional<Champion> findByChallenge(Challenge challenge);
}

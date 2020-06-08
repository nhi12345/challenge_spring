package com.example.demo.integration.database;

import com.example.demo.domain.challenge.Challenge;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ChallengeRepository extends MongoRepository<Challenge, String> {
    Optional<Challenge> findByTitle(String title);
}

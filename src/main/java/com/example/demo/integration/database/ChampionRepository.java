package com.example.demo.integration.database;

import com.example.demo.domain.champion.Champion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChampionRepository extends MongoRepository<Champion,String> {
}

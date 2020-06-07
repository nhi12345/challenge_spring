package com.example.demo.domain.challenge;

import com.example.demo.integration.database.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    public Challenge getCurrentChallenge(){
        return challengeRepository.findByTitle("Push up").get();
    }

}

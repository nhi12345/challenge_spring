package com.example.demo.domain.challenge;

import com.example.demo.domain.challenge.exception.ChallengeNotExpiredException;
import com.example.demo.integration.database.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    public Challenge getCurrentChallenge(){
        return challengeRepository.findByTitle("Push up").get();
    }

    public Challenge saveChallenge(Challenge challenge){
        return challengeRepository.save(challenge);
    }

    public boolean challengeIsExpired(Challenge challenge){
        if (LocalDate.now().isBefore(challenge.getStartDate()) || LocalDate.now().isAfter(challenge.getEndDate())) {
            throw new ChallengeNotExpiredException();
        }
        return false;
    }

}

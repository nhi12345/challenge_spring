package com.example.demo.rest.challenge;

import com.example.demo.domain.challenge.ChallengeService;
import com.example.demo.rest.challenge.vm.ChallengeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/challenge")
public class ChallengeResource {

    @Autowired
    private ChallengeService service;

    @Autowired
    private ChallengeMapper challengeMapper;

    @GetMapping
    public ChallengeDto getChallenge(){
        return challengeMapper.toChallengeDto(service.getCurrentChallenge());
    }
}

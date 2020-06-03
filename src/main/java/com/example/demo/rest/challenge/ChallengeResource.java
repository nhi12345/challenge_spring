package com.example.demo.rest.challenge;

import com.example.demo.domain.challenge.Challenge;
import com.example.demo.domain.challenge.ChallengeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping
    public Challenge getChallenge(){
        return service.findOne();
    }
}

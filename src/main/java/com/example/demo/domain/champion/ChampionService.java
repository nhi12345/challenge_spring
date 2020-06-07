package com.example.demo.domain.champion;

import com.example.demo.domain.challenge.Challenge;
import com.example.demo.domain.challenge.ChallengeService;
import com.example.demo.domain.file.exception.BadRequestException;
import com.example.demo.domain.file.exception.NotFoundException;
import com.example.demo.domain.submission.Submission;
import com.example.demo.domain.submission.SubmissionService;
import com.example.demo.integration.database.ChampionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChampionService {
    @Autowired
    private ChampionRepository championRepository;

    @Autowired
    private ChallengeService challengeService;

    @Autowired
    private SubmissionService submissionService;

    private Champion addChampion (Champion champion, String submissionId){
        Challenge currentChallenge = challengeService.getCurrentChallenge();
        if(LocalDate.now().isBefore(currentChallenge.getStartDate()) || LocalDate.now().isAfter(currentChallenge.getEndDate())){
            throw new BadRequestException("BadRequest");
        }
        Optional<Submission> submission = submissionService.getSubmissionById(submissionId);
        if(!submission.isPresent()){
            throw new NotFoundException("not found");
        }
        champion.setChallenge(Challenge.builder().id(currentChallenge.getId()).build());
        champion.setSubmission(Submission.builder().id(submissionId).build());
        return championRepository.save(champion);
    }
}

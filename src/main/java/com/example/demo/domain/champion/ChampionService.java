package com.example.demo.domain.champion;

import com.example.demo.domain.challenge.Challenge;
import com.example.demo.domain.challenge.ChallengeService;
import com.example.demo.domain.employee.Employee;
import com.example.demo.domain.file.exception.BadRequestException;
import com.example.demo.domain.file.exception.NotFoundException;
import com.example.demo.domain.submission.Submission;
import com.example.demo.domain.submission.SubmissionService;
import com.example.demo.integration.database.ChampionRepository;
import com.example.demo.integration.database.EmployeeRepository;
import com.example.demo.integration.database.SubmissionRepository;
import com.example.demo.rest.champion.ChampionMapper;
import com.example.demo.rest.champion.vm.ChampionResponse;
import com.example.demo.rest.submission.SubmissionMapper;
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

    @Autowired
    private ChampionMapper championMapper;

    @Autowired
    private SubmissionMapper submissionMapper;

    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Champion addChampion (Champion champion, String submissionId){
        Challenge currentChallenge = challengeService.getCurrentChallenge();
        Optional<Champion> championOptional =championRepository.findByChallenge(Challenge.builder().id(currentChallenge.getId()).build());
        if(championOptional.isPresent()){
            throw new BadRequestException("Champion is existed!");
        }
        if(LocalDate.now().isBefore(currentChallenge.getStartDate()) || LocalDate.now().isAfter(currentChallenge.getEndDate())){
            throw new BadRequestException("Challenge is not expired");
        }
        Optional<Submission> submission = submissionService.getSubmissionById(submissionId);
        if(!submission.isPresent()){
            throw new NotFoundException("not found");
        }
        champion.setChallenge(Challenge.builder().id(currentChallenge.getId()).build());
        champion.setSubmission(Submission.builder().id(submissionId).build());
        return championRepository.save(champion);
    }

    public ChampionResponse getChampion(){
        Challenge currentChallenge = challengeService.getCurrentChallenge();
        Optional<Champion> champion =championRepository.findByChallenge(Challenge.builder().id(currentChallenge.getId()).build());
        if(!champion.isPresent()){
            throw new BadRequestException("Champion not found!");
        }
        ChampionResponse championResponse = new ChampionResponse();
        Submission submission = submissionRepository.findById(champion.get().getSubmission().getId()).get();
        championResponse.setPerson(submissionMapper.mapPeople(employeeRepository.findByEmail(submission.getEmployee().getEmail()).get()));
        championResponse.setChampion(championMapper.toChampionDto(champion.get()));
        championResponse.setVideo(submissionMapper.toSubmissionDto(submission));
        return championResponse;
    }
}

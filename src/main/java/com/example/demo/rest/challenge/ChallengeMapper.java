package com.example.demo.rest.challenge;

import com.example.demo.domain.challenge.Challenge;
import com.example.demo.domain.champion.Champion;
import com.example.demo.domain.employee.Employee;
import com.example.demo.domain.submission.SubmissionService;
import com.example.demo.integration.database.ChampionRepository;
import com.example.demo.rest.challenge.vm.ChallengeDto;
import com.example.demo.rest.challenge.vm.ChallengeResponse;
import com.example.demo.rest.champion.ChampionMapper;
import com.example.demo.rest.submission.SubmissionMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class ChallengeMapper {

    @Autowired
    private ChampionMapper championMapper;

    @Autowired
    private ChampionRepository championRepository;

    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private SubmissionMapper submissionMapper;

    @Mapping(source = "employees", target = "peopleJoining", qualifiedByName = "mapPeopleJoining")
    public abstract ChallengeDto toChallengeDto(Challenge challenge);

    @Named("mapPeopleJoining")
    public int mapPeopleJoining(List<Employee> employees) {
        return employees.size();
    }

    public ChallengeResponse toChallengeResponse(Challenge challenge, String currentEmail) {
        ChallengeResponse challengeResponse = new ChallengeResponse();
        challengeResponse.setChallenge(toChallengeDto(challenge));
        Optional<Champion> champion = championRepository.findByChallenge(Challenge.builder().id(challenge.getId()).build());
        if (champion.isPresent()) {
            challengeResponse.setChampionData(championMapper.mapToChampionResponse(champion.get()));
        }
        challengeResponse.setJoined(submissionMapper.toSubmissionDto(submissionService.getSubmissionOfCurrentEmployeeThisDay(currentEmail)));
        return challengeResponse;
    }

}

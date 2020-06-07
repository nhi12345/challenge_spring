package com.example.demo.rest.champion;

import com.example.demo.domain.challenge.Challenge;
import com.example.demo.domain.champion.Champion;
import com.example.demo.domain.submission.Submission;
import com.example.demo.rest.challenge.vm.ChallengeDto;
import com.example.demo.rest.champion.vm.ChampionDto;
import com.example.demo.rest.submission.vm.SubmissionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ChampionMapper {
    public abstract ChampionDto toChampionDto(Champion champion);

    public abstract Champion toChampion(ChampionDto championDto);
}

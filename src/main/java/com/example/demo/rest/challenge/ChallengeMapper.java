package com.example.demo.rest.challenge;

import com.example.demo.domain.challenge.Challenge;
import com.example.demo.rest.challenge.vm.ChallengeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ChallengeMapper {
    public abstract ChallengeDto toGroupDto(Challenge challenge);
}

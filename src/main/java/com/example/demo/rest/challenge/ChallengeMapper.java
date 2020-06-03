package com.example.demo.rest.challenge;

import com.example.demo.domain.challenge.Challenge;
import com.example.demo.domain.employee.Employee;
import com.example.demo.rest.challenge.vm.ChallengeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ChallengeMapper {
    public abstract ChallengeDto toGroupDto(Challenge challenge);
    @Named("mapPeopleJoining")
    public int mapPeopleJoining(List<Employee> employees) {
        return employees.size();
    }
}

package com.example.demo.rest.champion;

import com.example.demo.domain.champion.Champion;
import com.example.demo.domain.submission.Submission;
import com.example.demo.domain.submission.SubmissionService;
import com.example.demo.integration.database.EmployeeRepository;
import com.example.demo.integration.database.SubmissionRepository;
import com.example.demo.rest.champion.vm.ChampionDto;
import com.example.demo.rest.champion.vm.ChampionResponse;
import com.example.demo.rest.employee.EmployeeMapper;
import com.example.demo.rest.submission.SubmissionMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ChampionMapper {

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

    @Autowired
    private EmployeeMapper employeeMapper;

    public abstract ChampionDto toChampionDto(Champion champion);

    public abstract Champion toChampion(ChampionDto championDto);

    public ChampionResponse mapToChampionResponse(Champion champion){
        ChampionResponse championResponse = new ChampionResponse();
        Submission submission = submissionRepository.findById(champion.getSubmission().getId()).get();
        championResponse.setPerson(employeeMapper.mapPeople(employeeRepository.findByEmail(submission.getEmployee().getEmail()).get()));
        championResponse.setChampion(championMapper.toChampionDto(champion));
        championResponse.setVideo(submissionMapper.toSubmissionDto(submission));
        return championResponse;
    }
}

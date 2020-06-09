package com.example.demo.rest.submission;

import com.example.demo.domain.employee.Employee;
import com.example.demo.domain.employee.EmployeeService;
import com.example.demo.domain.submission.Submission;
import com.example.demo.rest.champion.vm.ChampionResponse;
import com.example.demo.rest.employee.EmployeeMapper;
import com.example.demo.rest.employee.vm.EmployeeDto;
import com.example.demo.rest.submission.vm.SubmissionDto;
import com.example.demo.rest.submission.vm.SubmissionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class SubmissionMapper {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Mapping(source = "dateCreated", target = "dateCreated")
    public abstract SubmissionDto toSubmissionDto(Submission submission);

    public List<SubmissionDto> toSubmissionDtos(List<Submission> submissions) {
        return submissions.parallelStream().map(this::toSubmissionDto).collect(Collectors.toList());
    }

    public abstract Submission toSubmission(SubmissionDto submissionDto);

    public SubmissionResponse toSubmissionResponse(Submission submission) {
        SubmissionResponse submissionResponse = new SubmissionResponse();
        submissionResponse.setVideo(toSubmissionDto(submission));
        submissionResponse.setPeople(employeeMapper.mapPeople(submission.getEmployee()));
        return submissionResponse;
    }

    public List<SubmissionResponse> toSubmissionResponses(List<Submission> submissions) {
        return submissions.parallelStream().map(this::toSubmissionResponse).collect(Collectors.toList());
    }
}

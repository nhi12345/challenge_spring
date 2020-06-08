package com.example.demo.rest.submission;

import com.example.demo.domain.employee.Employee;
import com.example.demo.domain.employee.EmployeeService;
import com.example.demo.domain.submission.Submission;
import com.example.demo.rest.employee.EmployeeMapper;
import com.example.demo.rest.employee.vm.EmployeeDto;
import com.example.demo.rest.submission.vm.SubmissionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class SubmissionMapper {

    @Mapping(source = "dateCreated", target = "dateCreated")
    public abstract SubmissionDto toSubmissionDto(Submission submission);

    public List<SubmissionDto> toSubmissionDtos(List<Submission> submissions) {
        return submissions.parallelStream().map(this::toSubmissionDto).collect(Collectors.toList());
    }

    public abstract Submission toSubmission(SubmissionDto submissionDto);
}

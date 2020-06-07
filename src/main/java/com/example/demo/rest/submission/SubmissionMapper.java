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

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeService employeeService;

    @Mapping(source = "dateCreated", target = "dateCreated")
    @Mapping(source = "employee", target = "people", qualifiedByName = "mapPeople")
    public abstract SubmissionDto toSubmissionDto(Submission submission);

    public List<SubmissionDto> toSubmissionDtos(List<Submission> submissions) {
        return submissions.parallelStream().map(this::toSubmissionDto).collect(Collectors.toList());
    }

    @Named("mapPeople")
    public EmployeeDto mapPeople(final Employee employee) {
        return employeeMapper.toEmployeeDto(employeeService.findEmployeeByEmail(employee.getEmail()));
    }

    public abstract Submission toSubmission(SubmissionDto submissionDto);
}

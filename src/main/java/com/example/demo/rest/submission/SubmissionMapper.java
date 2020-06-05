package com.example.demo.rest.submission;

import com.example.demo.domain.submission.Submission;
import com.example.demo.rest.submission.vm.SubmissionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class SubmissionMapper {
    @Mapping(source = "dateCreated", target = "dateCreated")
    @Mapping(source = "employee", target = "people", qualifiedByName = "toEmployeeDto")
    public abstract SubmissionDto toSubmissionDto(Submission submission);

    public List<SubmissionDto> toSubmissionDtos(List<Submission> submissions) {
        return submissions.parallelStream().map(this::toSubmissionDto).collect(Collectors.toList());
    }

    public abstract Submission toSubmission(SubmissionDto submissionDto);
}

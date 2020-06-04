package com.example.demo.rest.submission;

import com.example.demo.domain.submission.Submission;
import com.example.demo.rest.submission.vm.SubmissionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class SubmissionMapper {
    public abstract SubmissionDto toGroupDto(Submission submission);
}

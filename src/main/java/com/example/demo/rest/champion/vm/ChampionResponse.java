package com.example.demo.rest.champion.vm;

import com.example.demo.domain.submission.Submission;
import com.example.demo.rest.employee.vm.EmployeeDto;
import com.example.demo.rest.submission.vm.SubmissionDto;
import lombok.*;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChampionResponse {

    private ChampionDto champion;

    private EmployeeDto person;

    private SubmissionDto video;

}

package com.example.demo.rest.submission.vm;

import com.example.demo.rest.employee.vm.EmployeeDto;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionResponse {

    private SubmissionDto video;

    private EmployeeDto people;

}

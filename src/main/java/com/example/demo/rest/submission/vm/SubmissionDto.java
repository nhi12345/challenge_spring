package com.example.demo.rest.submission.vm;

import com.example.demo.rest.employee.vm.EmployeeDto;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionDto {
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    private String videoUrl;

    @NotBlank
    private String thumbnailUrl;

    @NonNull
    private long duration;

    private EmployeeDto people;

}

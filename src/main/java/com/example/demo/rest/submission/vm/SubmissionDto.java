package com.example.demo.rest.submission.vm;

import lombok.*;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionDto {
    private String id;

    private String title;

    private String videoUrl;

    private String thumbnailUrl;

    private long duration;

}

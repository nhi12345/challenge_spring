package com.example.demo.rest.challenge.vm;

import lombok.*;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeDto {
    private String id;
    private String title;
    private String pictureUrl;
    private String content;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isExpired;
    private int peopleJoining;
}

package com.example.demo.rest.challenge.vm;

import com.example.demo.rest.champion.vm.ChampionResponse;
import com.example.demo.rest.submission.vm.SubmissionDto;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeResponse {

    private ChallengeDto challenge;

    private ChampionResponse championData;

    private SubmissionDto joined;
}

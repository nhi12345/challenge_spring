package com.example.demo.domain.champion;

import com.example.demo.domain.challenge.Challenge;
import com.example.demo.domain.submission.Submission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Champion {
    private String title;
    private String content;
    private Challenge challenge;
    private Submission submission;
}

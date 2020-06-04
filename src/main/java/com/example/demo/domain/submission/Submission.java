package com.example.demo.domain.submission;

import com.example.demo.domain.challenge.Challenge;
import com.example.demo.domain.employee.Employee;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "submissions")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@CompoundIndex(def = "{'employee':1, 'challenge':1, 'dateCreate':1}", unique = true)
public class Submission {
    @Id
    private String id;

    private String title;

    private String videoUrl;

    private String thumbnailUrl;

    private long duration;

    private LocalDate dateCreated;

    private Employee employee;

    private Challenge challenge;
}

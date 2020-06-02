package com.example.demo.domain.challenge;

import com.example.demo.domain.employee.Employee;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "challenges")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Challenge {
    @Id
    private String id;

    @Indexed(unique = true)
    private String title;

    private String pictureUrl;

    private LocalDate startDate;

    private LocalDate endDate;

    @DBRef(lazy = true)
    private List<Employee> users = new ArrayList<>();
}

package com.example.demo.domain.challenge;

import com.example.demo.domain.employee.Employee;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
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

    private String title;

    private String pictureUrl;

    private Date startDate;

    private Date endDate;

    @DBRef(lazy = true)
    private List<Employee> users = new ArrayList<>();
}

package com.example.demo.rest.employee.vm;

import com.example.demo.domain.employee.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Set;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String id;
    private String trigram;
    private String familyName;
    private String fullName;
    private String givenName;
    private String nickname;
    private String email;
    private String title;
    private String location;
    private String locationCode;
    private Set<Employee.Phone> phones;
    private Set<Employee.Address> addresses;
    @JsonProperty("isFavorite")
    private boolean isFavorite;
    private String pictureUrl;
}

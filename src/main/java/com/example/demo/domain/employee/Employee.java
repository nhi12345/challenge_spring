package com.example.demo.domain.employee;

import com.example.demo.domain.challenge.Challenge;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Employee {
    //GD id
    @Id
    private String id;

    //GD Custom schemas
    @Indexed
    private String trigram;

    //GD name.familyName
    @Indexed
    private String familyName;

    //GD name.fullName
    @Indexed
    private String fullName;

    //GD name.givenName
    private String givenName;

    //GD Custom schemas
    @Indexed
    private String nickname;

    //GD primaryEmail
    @Indexed
    private String email;

    private String pictureUrl;

    //GD organizations.title
    private String title;

    //GD organizations.department
    private String location;

    //Projector ex.location_dsp
    private String locationCode;

    //GD phones
    private Set<Phone> phones;

    //GD addresses
    private Set<Address> addresses;

    @Transient
    private boolean isFavorite;

    @DBRef(lazy = true)
    private List<Challenge> challenges;

    @Getter
    @EqualsAndHashCode(of = "value")
    @ToString
    public static class Phone {
        private final String type;
        private final String value;

        public Phone(final String type, final String value) {
            this.type = type;
            this.value = value;
        }
    }

    @Getter
    @EqualsAndHashCode
    @ToString
    public static class Address {
        private final String type;
        private final String value;

        public Address(final String type, final String value) {
            this.type = type;
            this.value = value;
        }
    }
}

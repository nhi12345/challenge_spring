package com.example.demo.rest.champion.vm;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChampionDto {
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;
}

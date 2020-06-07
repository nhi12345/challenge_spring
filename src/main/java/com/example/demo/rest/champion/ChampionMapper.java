package com.example.demo.rest.champion;

import com.example.demo.domain.champion.Champion;
import com.example.demo.rest.champion.vm.ChampionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ChampionMapper {
    public abstract ChampionDto toChampionDto(Champion champion);

    public abstract Champion toChampion(ChampionDto championDto);
}

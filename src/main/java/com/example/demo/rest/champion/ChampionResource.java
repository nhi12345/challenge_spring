package com.example.demo.rest.champion;

import com.example.demo.domain.champion.Champion;
import com.example.demo.domain.champion.ChampionService;
import com.example.demo.rest.champion.vm.ChampionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/approve")
public class ChampionResource {

    @Autowired
    private ChampionService service;

    @Autowired
    private ChampionMapper championMapper;

    @PostMapping
    public ChampionDto addChampion(@RequestBody @Valid ChampionDto championDto,@RequestParam(value = "submission_id") String submissionId){
        Champion champion = service.addChampion(championMapper.toChampion(championDto), submissionId);
        return championMapper.toChampionDto(champion);
    }
}

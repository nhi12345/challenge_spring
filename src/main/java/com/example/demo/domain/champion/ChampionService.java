package com.example.demo.domain.champion;

import com.example.demo.integration.database.ChampionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChampionService {
    @Autowired
    private ChampionRepository championRepository;

    private Champion addChampion (){
        return null;
    }
}

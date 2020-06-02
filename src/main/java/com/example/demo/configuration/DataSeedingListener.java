package com.example.demo.configuration;

import com.example.demo.domain.challenge.Challenge;
import com.example.demo.integration.database.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Component
@Configuration
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ChallengeRepository challengeRepository;

    private void addChallengeIfMissing(String title, String pictureUrl, LocalDate startDate, LocalDate endDate) {
        if (!challengeRepository.findByTitle(title).isPresent()) {
            Challenge challenge = new Challenge();
            challenge.setTitle(title);
            challenge.setPictureUrl(pictureUrl);
            challenge.setStartDate(startDate);
            challenge.setEndDate(endDate);
            challengeRepository.save(challenge);
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        addChallengeIfMissing("Push up",
                "https://res.cloudinary.com/dmt5d71gv/image/upload/v1589528451/tnsqjh9rsojqmiht5hlh.jpg",
                LocalDate.of(2020, 6, 1),
                LocalDate.of(2020, 6, 15));
    }
}

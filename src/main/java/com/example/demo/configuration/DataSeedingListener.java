package com.example.demo.configuration;

import com.example.demo.domain.challenge.Challenge;
import com.example.demo.domain.employee.Employee;
import com.example.demo.integration.database.ChallengeRepository;
import com.example.demo.integration.database.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Configuration
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ChallengeRepository challengeRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private void addChallengeIfMissing(String title, String content, String pictureUrl, LocalDate startDate, LocalDate endDate) {
        if (!challengeRepository.findByTitle(title).isPresent()) {
            Challenge challenge = new Challenge();
            challenge.setTitle(title);
            challenge.setContent(content);
            challenge.setPictureUrl(pictureUrl);
            challenge.setStartDate(startDate);
            challenge.setEndDate(endDate);
            challengeRepository.save(challenge);
        }
    }

    private void addUserIfMissing(String trigram, String familyName, String fullName, String givenName,
                                  String nickname, String email, String pictureUrl, String title, String location,
                                  String locationCode) {
        if (!employeeRepository.findByEmail(email).isPresent()) {
            Employee.Phone phone = new Employee.Phone("Office", "(264)-140-8724");
            Employee.Address address = new Employee.Address("Office", "3 Place de la Mairie, Lyon, France");
            Employee employee = new Employee(trigram, familyName, fullName, givenName, nickname, email, pictureUrl, title, location, locationCode, true);
            employee.getPhones().add(phone);
            employee.getAddresses().add(address);
            employeeRepository.save(employee);
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        addChallengeIfMissing("Push up",
                "A push-up (or press-up if the hands are wider than shoulders placing more emphasis \n" +
                        "                on the pectoral muscles) is a common calisthenics exercise beginning from the prone \n" +
                        "                position. By raising and lowering the body using the arms, push-ups exercise the pectoral \n" +
                        "                muscles, triceps, and anterior deltoids, with ancillary benefits to the rest of the deltoids,\n" +
                        "                 serratus anterior, coracobrachialis and the midsection as a whole",
                "https://res.cloudinary.com/dmt5d71gv/image/upload/v1589528451/tnsqjh9rsojqmiht5hlh.jpg",
                LocalDate.of(2020, 6, 1),
                LocalDate.of(2020, 6, 15));


        addUserIfMissing("0HW",
                "Coffey",
                "Jacqueline Coffey",
                "Jacqueline",
                "Renwick",
                "marsha.edwards79@example.com",
                "https://res.cloudinary.com/dmt5d71gv/image/upload/v1589344342/z81vcsaizmxyghfl1ktd.jpg",
                "Senior Developer",
                "Geneva",
                "GVA"
        );
    }
}

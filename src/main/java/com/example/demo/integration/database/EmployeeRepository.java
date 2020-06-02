package com.example.demo.integration.database;

import com.example.demo.domain.employee.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
    Optional<Employee> findByEmail(String email);
}

package com.example.demo.integration.database;

import com.example.demo.domain.employee.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
}

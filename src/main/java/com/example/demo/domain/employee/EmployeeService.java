package com.example.demo.domain.employee;

import com.example.demo.domain.file.exception.NotFoundException;
import com.example.demo.integration.database.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getCurrentEmployee(String email){
        Optional <Employee> employee = employeeRepository.findByEmail(email);
        if(!employee.isPresent()){
            throw new NotFoundException("Employee not found");
        }
        return employee.get();
    }
}

package com.example.demo.rest.employee;

import com.example.demo.domain.employee.Employee;
import com.example.demo.rest.employee.vm.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class EmployeeMapper {
    @Named("toEmployeeDto")
    public abstract EmployeeDto toEmployeeDto(Employee employee);

    public List<EmployeeDto> toEmployeeDtos(List<Employee> employees) {
        return employees.parallelStream().map(this::toEmployeeDto).collect(Collectors.toList());
    }
}

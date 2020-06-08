package com.example.demo.configuration;

import com.example.demo.domain.employee.Employee;
import com.example.demo.integration.database.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component("userDetail")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Employee> employee = employeeRepository.findByEmail(email);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if(employee.isPresent()){
            return new org.springframework.security.core.userdetails.User(
                    email,email, grantedAuthorities);
        }
        return null;
        }
}
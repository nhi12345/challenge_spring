package com.example.demo.configuration;

import com.example.demo.domain.employee.Employee;
import com.example.demo.integration.database.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String email = req.getHeader("Authorization");
        int a=0;
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            Optional<Employee> employee = employeeRepository.findByEmail(email);

            if (employee.isPresent()) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(employee.get(),email);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }else{
            System.out.println("error");
        }
        chain.doFilter(req, res);
    }
}
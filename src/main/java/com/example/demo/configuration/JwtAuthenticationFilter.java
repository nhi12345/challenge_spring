package com.example.demo.configuration;

import com.example.demo.integration.database.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String email = req.getHeader("Authorization");
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            if (userDetails != null) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails,null,
                        AuthorityUtils.createAuthorityList("ROLE_EMPLOYEES"));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }else{
            System.out.println("User not found!");
        }
        chain.doFilter(req, res);
    }
}
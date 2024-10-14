package com.interactive.consumer.service;

import com.interactive.consumer.model.Employee;
import com.interactive.consumer.model.PageResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final RestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/api/employees"; // Change port if necessary

    @Autowired
    public EmployeeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // public List<Employee> getAllEmployees() {
    // ResponseEntity<Employee[]> responseEntity =
    // restTemplate.getForEntity(BASE_URL, Employee[].class);
    // Employee[] employees = responseEntity.getBody(); // This should not cause an
    // issue if the JSON matches
    // return List.of(employees);
    // }

    public Optional<Employee> getEmployeeById(Long id) {
        String url = String.format(BASE_URL+"/%d", id);
        ResponseEntity<Employee> responseEntity = restTemplate.getForEntity(url, Employee.class);
        return Optional.of(responseEntity.getBody());
    }

    public PageResponse<Employee> getAllEmployees(int page, int size) {
        String url = String.format("%s?page=%d&size=%d", BASE_URL, page, size);
        // return restTemplate.getForObject(url, PageResponse.class);
        ResponseEntity<PageResponse<Employee>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<PageResponse<Employee>>() {
                });
        return responseEntity.getBody();
    }

    public Employee createEmployee(Employee employee) {
        return restTemplate.postForObject(BASE_URL, employee, Employee.class);
    }
}
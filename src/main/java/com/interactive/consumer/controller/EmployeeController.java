package com.interactive.consumer.controller;

import com.interactive.consumer.model.Employee;
import com.interactive.consumer.model.PageResponse;
import com.interactive.consumer.service.EmployeeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id).get();
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public PageResponse<Employee> listEmployees(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return employeeService.getAllEmployees(page, size);
    }

    @PostMapping
    public Employee createEmployee(Employee employee) {
        return employeeService.createEmployee(employee);
    }
}
package com.interactive.consumer.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    
    private Long id;
    private String name;
    private String email;
    private String position;
    private Double salary;
    private Long departmentId; // Assuming you only want the ID of the department

    // Getters and Setters
}
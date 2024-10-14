package com.interactive.consumer.model;

import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private Long id;
    private String name;
    private List<Employee> employees;
}
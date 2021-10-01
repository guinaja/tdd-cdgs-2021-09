package com.example.day02.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;


    // Demo of Path Variable
    @GetMapping("/employee/{id}")
    public EmployeeResponse getById(@PathVariable int id) {
        return service.getEmployee(id);
    }
}

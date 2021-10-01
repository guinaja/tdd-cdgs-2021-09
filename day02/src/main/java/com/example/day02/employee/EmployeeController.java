package com.example.day02.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    // Demo of Path Variable
    @GetMapping("/employee/{id}")
    public EmployeeResponse getById(@PathVariable int id) {
        EmployeeResponse response = new EmployeeResponse(id, "Demo", 40);
        return response;
    }
}

package com.example.day02.employee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


    public EmployeeResponse getEmployee(int id) {
        EmployeeResponse result = new EmployeeResponse(id, "Demo", 40);
        return result;
    }
}

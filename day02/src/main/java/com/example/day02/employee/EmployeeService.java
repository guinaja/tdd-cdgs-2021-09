package com.example.day02.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public EmployeeResponse getEmployee(int id) {
        Optional<Employee> employee = repository.findById(id);
        if (employee.isPresent()){
            EmployeeResponse result = new EmployeeResponse(employee.get().getId(), employee.get().getName(),employee.get().getAge());
            return result;
        }else {
            throw new RuntimeException("Employee ont found for id : " + id);
        }
    }
}

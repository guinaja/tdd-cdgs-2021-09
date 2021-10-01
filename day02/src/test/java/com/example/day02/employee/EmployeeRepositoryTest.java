package com.example.day02.employee;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository  repository;

    @Test
    public void case01(){
        log.info("case01");
        Employee employee = new Employee(null,"prayoon" ,20);
        repository.save(employee);
        Optional<Employee> result = repository.findById(1);

        assertEquals(result.isPresent() , true);
        assertEquals(result.get().getId()   , 1);
    }
    @Test
    public void case02(){
        log.info("case02");
        Optional<Employee> result = repository.findById(1);
        assertEquals(result.isPresent() , false);
    }
}
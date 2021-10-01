package com.example.day02.employee;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {
    // start service ทั้งหมด เพื่อ ทดสอบ
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    EmployeeRepository  repository;

    @AfterAll
    public static void clear() {
        log.info("clear data");
    }

    @Test
    @Order(1)
    public void getById(){
        Employee employee = new Employee(null,"prayoon" ,20);
        repository.save(employee);

        Integer id = 1;
        EmployeeResponse  response =  restTemplate.getForObject("/employee/" + id, EmployeeResponse.class);
        log.info(response.getName());
        assertEquals(id,response.getId());

    }
    @Test
    @Order(2)
    public void getByIdWithOutInsert(){
        Integer id = 1;
        EmployeeResponse  response =  restTemplate.getForObject("/employee/" + id, EmployeeResponse.class);
        log.info(response.getName());
        assertEquals(id,response.getId());

    }
}

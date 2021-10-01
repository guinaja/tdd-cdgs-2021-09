package com.example.day02.employee;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {
    // start service ทั้งหมด เพื่อ ทดสอบ
    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void getById(){
        Integer id = 1;
        EmployeeResponse  response =  restTemplate.getForObject("/employee/" + id, EmployeeResponse.class);
        log.info(response.getName());
        assertEquals(id,response.getId());

    }
}

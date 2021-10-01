package com.example.day02.employee;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerWithMockBeanTest {
    // start service ทั้งหมด เพื่อ ทดสอบ
    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    EmployeeRepository  repository;

    @AfterAll
    public static void clear() {
        log.info("clear data");
    }

    @Test
    @Order(1)
    public void getById(){
        Integer id = 1;
        Employee  mockResult = new Employee(id, "prayoon", 40);
        // arrange
        when(repository.findById(id)).thenReturn(Optional.of(mockResult));

        EmployeeResponse  response =  restTemplate.getForObject("/employee/" + id, EmployeeResponse.class);
        log.info(response.getName());
        assertEquals(id,response.getId());

    }
    @Test
    @Order(2)
    public void getById2(){
        Integer id = 2;
        Employee  mockResult = new Employee(id, "prayoon", 40);
        // arrange
        when(repository.findById(id)).thenReturn(Optional.of(mockResult));
        EmployeeResponse  response =  restTemplate.getForObject("/employee/" + id, EmployeeResponse.class);
        log.info(response.getName());
        assertEquals(id,response.getId());

    }
}

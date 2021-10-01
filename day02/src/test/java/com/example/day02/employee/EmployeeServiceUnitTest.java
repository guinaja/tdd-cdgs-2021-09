package com.example.day02.employee;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceUnitTest {

    @Mock
    EmployeeRepository repository;


    @Test
    public void  get(){
        Integer id = 99;
        Employee  mockResult = new Employee(id, "unit test service", 40);
        when(repository.findById(id)).thenReturn(Optional.of(mockResult));


        EmployeeService service = new EmployeeService(repository);

        EmployeeResponse result = service.getEmployee(id);

        assertEquals(id , result.getId());
        assertEquals("unit test service" , result.getName());
    }

}
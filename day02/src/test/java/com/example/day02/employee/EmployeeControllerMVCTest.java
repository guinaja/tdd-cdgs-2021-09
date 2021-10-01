package com.example.day02.employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerMVCTest {
    // start service controller ตามที่ต้องการเท่านั้น
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void getById() throws Exception {
        Integer id = 1;
        EmployeeResponse mockResult = new EmployeeResponse(id, "Demo", 40);
        // arrange
        when(employeeService.getEmployee(id)).thenReturn(mockResult);

        // act
        ObjectMapper mapper = new ObjectMapper();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/employee/{id}", id).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) .andReturn();
        String json = result.getResponse().getContentAsString();
        EmployeeResponse response =  mapper.readValue(json , EmployeeResponse.class);

        // assert
        assertEquals(id,response.getId());
    }
}

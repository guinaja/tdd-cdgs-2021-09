package com.example.day02.employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerMVCTest {
    // start service controller ตามที่ต้องการเท่านั้น
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getById() throws Exception {
        Integer id = 1;
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/employee/{id}", id).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) .andReturn();
        String json = result.getResponse().getContentAsString();
        EmployeeResponse response =  mapper.readValue(json , EmployeeResponse.class);
        assertEquals(id,response.getId());
    }
}

package com.example.restdocs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Author: Rustambekov Avazbek
 * Date: 05/05/2020
 * Time: 13:08
 */

@SpringBootTest
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
public class PersonControllerJunit5Test {

    @Autowired
    private ObjectMapper objectMapper;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext,
                      RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }

    @Test
    public void getAllShouldReturnOk() throws Exception {
        this.mockMvc.perform(
                RestDocumentationRequestBuilders.get("/people"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andDo(document("people/get-all"));
    }

    @Test
    public void getPersonByIdShouldReturnOk() throws Exception {
        this.mockMvc.perform(
                RestDocumentationRequestBuilders.get("/people/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andDo(document("people/get-by-id"));
    }

    @Test
    public void createPersonShouldReturnOk() throws Exception {

        Map<String, Object> content = new HashMap<>();
        content.put("id", 2L);
        content.put("fullName", "John Doe");

        this.mockMvc.perform(RestDocumentationRequestBuilders
                .post("/people")
                .content(this.objectMapper.writeValueAsString(content))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andDo(document("people/create"));
    }

}

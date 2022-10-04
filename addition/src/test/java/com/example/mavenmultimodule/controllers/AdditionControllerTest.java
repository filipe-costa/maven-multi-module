package com.example.mavenmultimodule.controllers;

import com.example.mavenmultimodule.models.SumModel;
import com.example.mavenmultimodule.services.SumService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AdditionController.class)
@ContextConfiguration(classes = AdditionController.class)
class AdditionControllerTest {
    ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    private SumService sumService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn5() throws Exception {
        Double expectedValue = 5.0;
        SumModel s = new SumModel();
        s.setN1(2.0);
        s.setN2(3.0);

        String json = objectMapper.writeValueAsString(s);

        given(this.sumService.sum(any())).willReturn(expectedValue);

        this.mockMvc.perform(
                post("/sum")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(json)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(expectedValue.toString()));
    }
}

package com.example.mavenmultimodule.controllers;

import com.example.mavenmultimodule.models.SumModel;
import com.example.mavenmultimodule.services.SumService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = AdditionController.class)
@AutoConfigureMockMvc
class AdditionControllerTest {

    @Mock
    private SumService sumService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn5() throws Exception {
        SumModel s = new SumModel();
        s.setN1(2.0);
        s.setN2(3.0);
        Gson gson = new Gson();
        String json = gson.toJson(s);

        when(sumService.sum(s)).thenReturn(5.0);

        MvcResult result = this.mockMvc.perform(
                post("/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(5, result.getResponse());
    }

}
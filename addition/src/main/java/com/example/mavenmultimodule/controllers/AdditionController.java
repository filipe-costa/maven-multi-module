package com.example.mavenmultimodule.controllers;

import com.example.mavenmultimodule.models.SumModel;
import com.example.mavenmultimodule.services.SumService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
class AdditionController {

    private final SumService sumService;

    AdditionController(SumService sumService) {
        this.sumService = sumService;
    }

    @PostMapping(value = "/sum", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Double sum(@RequestBody SumModel s) {
        return sumService.sum(s);
    }
}

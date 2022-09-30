package com.example.mavenmultimodule.controllers;

import com.example.mavenmultimodule.models.SumModel;
import com.example.mavenmultimodule.services.SumService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AdditionController {

    private final SumService sumService;

    AdditionController(SumService sumService) {
        this.sumService = sumService;
    }

    @PostMapping("/sum")
    Double sum(@RequestBody SumModel s) {
        return sumService.sum(s);
    }
}

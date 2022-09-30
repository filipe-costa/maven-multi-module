package com.example.mavenmultimodule.controllers;

import com.example.mavenmultimodule.models.SubModel;
import com.example.mavenmultimodule.services.SubService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SubtractionController {

    private final SubService subService;

    SubtractionController(SubService subService) {
        this.subService = subService;
    }

    @PostMapping("/sub")
    Double sub(@RequestBody SubModel s) {
        return subService.sub(s);
    }
}

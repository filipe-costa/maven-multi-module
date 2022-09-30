package com.example.mavenmultimodule.services;

import com.example.mavenmultimodule.models.SubModel;
import org.springframework.stereotype.Service;

@Service
public class SubService {

    public Double sub(SubModel s) {
        return s.getN1() - s.getN2();
    }
}

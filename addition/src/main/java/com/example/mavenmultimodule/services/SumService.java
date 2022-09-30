package com.example.mavenmultimodule.services;

import com.example.mavenmultimodule.models.SumModel;
import org.springframework.stereotype.Service;

@Service
public class SumService {
    public Double sum(SumModel s) {
        return s.getN1() + s.getN2();
    }
}

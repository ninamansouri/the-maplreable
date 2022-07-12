package com.example.themaplreable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/maplrErableHome")
    public String runIndex(){
        return "maplrErableHome";
    }
}

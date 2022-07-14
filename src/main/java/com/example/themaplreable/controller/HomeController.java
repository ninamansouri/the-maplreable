package com.example.themaplreable.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Cart Controller.
 */
@Controller
@RequestMapping("/")
public class HomeController {


    public HomeController() {
    }

    /**
     * Return the home page of the website
     *
     * @return String
     */
    @GetMapping("/")
    public String getCartLines() {
        return "maplrErableHome";
    }

}

package com.example.ram.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class HelloController {

    @GetMapping("/name")
    public String getName() {
        return "Hello World!";
    }

}

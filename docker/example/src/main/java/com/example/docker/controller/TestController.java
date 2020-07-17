package com.example.docker.controller;


import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class TestController {


    @RequestMapping(value = "/test")
    public String test(){
        
        return "Test";

    }

}

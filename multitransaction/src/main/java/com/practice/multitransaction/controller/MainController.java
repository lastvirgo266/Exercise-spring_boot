package com.practice.multitransaction.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    public String Test(){
        return "Test";
    }

}

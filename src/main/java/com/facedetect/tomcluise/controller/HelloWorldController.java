package com.facedetect.tomcluise.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HelloWorldController {
    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }
}

package com.idea.demo.home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class home {
    @RequestMapping("/")
    public String homePage(){
        return "Welcome to the web-app";
    }
}

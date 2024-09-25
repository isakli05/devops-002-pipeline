package com.mimaraslan.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


//  http://localhost:8080
@RestController
@RequestMapping
public class DevOpsController {

    //  http://localhost:8080
    @GetMapping
    System.out.println("DevOps Hello : " + LocalDateTime.now());
    public String devopsHello() {

        System.out.println("DevOps Hello : " + LocalDateTime.now());
        return "DevOps Hello : " + LocalDateTime.now();

    }

    //  http://localhost:8080/info
    @GetMapping("/info")
            System.out.println("DevOps Info : " + LocalDateTime.now());
    public String info() {

        System.out.println("DevOps Info : " + LocalDateTime.now());
        return "DEVOPS INFO : " + LocalDateTime.now();
    }
}

package com.springpractice.spring_web_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/initial")
    public String initial(@RequestParam (name = "firstname") String firstname,
                          @RequestParam (name = "lastname",required = false) String lastname) {
        return "Starting SpringBoot Theory with " + firstname + " " + lastname;
    }



}
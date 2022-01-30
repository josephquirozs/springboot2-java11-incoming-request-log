package com.example.incomingrequestlog;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @PostMapping("/greetings")
    public String post(@RequestBody Greeting resource) {
        final String template = "Hello, %s from %s";
        return String.format(template, resource.getToPerson(), resource.getFromPlace());
    }
}

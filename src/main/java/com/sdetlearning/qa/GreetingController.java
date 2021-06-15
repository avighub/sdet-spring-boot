package com.sdetlearning.qa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private static final String template2 = "Bye, %s!";
    private static final String template_thank = "Thank you, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "Fname", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/bye")

    public Bye bye(@RequestParam(value = "name", defaultValue = "and See you soon!!!") String name) {

        return new Bye(counter.incrementAndGet(), String.format(template2, name));
    }

    @GetMapping("/thank")
    public Thank thank(@RequestParam(value = "Lname", defaultValue = "LastName") String name) {
        return new Thank(counter.incrementAndGet(), String.format(template_thank, name));
    }


}


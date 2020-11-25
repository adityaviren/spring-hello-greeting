package com.cg.hello.controller;

import com.cg.hello.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @GetMapping("/param/{name}")
    public Greeting greetingParam(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public Greeting greetingQuery(@RequestParam(value="name") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @PostMapping("/post")
    public Greeting sayHello(@RequestBody Greeting greetingObj) {
        return greetingObj;
    }

    @PutMapping("/put/{name}")
    public Greeting sayHello(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
package com.cg.hello.controller;

import com.cg.hello.model.Greeting;
import com.cg.hello.model.User;
import com.cg.hello.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService greetingService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        User user = new User();
        user.setFname(name);
        return greetingService.addGreeting(user);
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
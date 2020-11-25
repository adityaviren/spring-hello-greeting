package com.cg.hello.controller;

import com.cg.hello.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/hello")
public class Hello {

    @RequestMapping(value = {"", "/", "/home"})
    public String sayHello() {
        return "HelloWorld";
    }

    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    //@GetMapping("/query")
    public String sayHello(@RequestParam(value = "name") String name, @RequestParam(value = "lname") String lname) {
        return "Hello " + name + " " + lname;
    }

    @GetMapping("/param/{name}")
    public String sayHello(@PathVariable String name) {
        return "Good Morning " + name;
    }

    @PostMapping("/post")
    public String sayHello(@RequestBody User user) {
        return "hello " + user.getFname() + " " + user.getLname();
    }

    @PutMapping("/put/{fname}")
    public String hello(@PathVariable String fname, @RequestParam(value = "lname") String lname) {
        return "Good Morning" + fname + " " + lname;
    }
}

    @RestController
    class GreetingController {
        private static final String template = "Hello, %s!";
        private final AtomicLong counter = new AtomicLong();

        @GetMapping("/greeting")
        public Greeting gretting (@RequestParam(value = "name", defaultValue = "World") String name){
            return new Greeting(counter.incrementAndGet(),
                    String.format(template, name));
        }

    /*@PutMapping("/put/{firstName}")
    public String Hello(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName){
        return "Hello " +firstName + " " + lastName + "!";
    }*/
}

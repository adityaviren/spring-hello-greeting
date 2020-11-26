package com.cg.hello.service;

import com.cg.hello.model.Greeting;
import com.cg.hello.model.User;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getGreetingById(long id);
}

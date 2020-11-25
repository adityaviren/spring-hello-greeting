package com.cg.hello.model;

public class Greeting {
    long counter;
    String message;

    public Greeting(long counter, String message) {
        this.counter = counter;
        this.message = message;
    }

    public long getCounter() {
        return counter;
    }

    public String getMessage() {
        return message;
    }
}

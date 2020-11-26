package com.cg.hello.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GREETINGS")
public class Greeting {

    @Id
    long counter;
    String message;

    public Greeting(long counter, String message) {
        this.counter = counter;
        this.message = message;
    }

    public Greeting() {
        counter=0;
        message="";
    }

    public long getCounter() {
        return counter;
    }

    public String getMessage() {
        return message;
    }
}

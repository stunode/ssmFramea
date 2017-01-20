package com.webService;

import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("helloWorld")
public class HelloWorldImpl implements HelloWorld {

    public User getUserInfo(int id) {
        System.out.println("service is start");
        if (id == 1) {
            return new User("aiwei",1);
        }
        return null;
    }
}

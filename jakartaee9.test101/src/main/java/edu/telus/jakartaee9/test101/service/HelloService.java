package edu.telus.jakartaee9.test101.service;

import jakarta.ejb.Stateless;

/**
 *
 * @author Mario Batres
 */
@Stateless
public class HelloService {

    public String sayHello() {
        return "Hello world";
    }
}

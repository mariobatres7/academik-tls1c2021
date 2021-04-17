package edu.telus.primer.jakarta9.controllers;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author Mario Batres
 */
@Named
@ViewScoped
public class IndexController implements Serializable {

    private String name;

    private String message;

    public void init() {
        this.name = "";
        this.message = "";
    }

    public void sayHello() {
        this.message = "Hello " + this.name;
        this.name = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

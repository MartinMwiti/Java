package com.shadowJava.Springboot.l1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @Component is an annotation that allows Spring to automatically detect our custom beans. @Controller has @Component

@RestController // It's a controller and component that returns a responseBody
public class HelloController {
//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String helloWorld(){
        return "Welcome to Shadow";
    }
}

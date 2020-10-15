package com.stacksimplify.restservices.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/helloworld")
    //@RequestMapping(method = RequestMethod.GET,path = "/helloworld")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/getUser")
    public UserDetails returnBean()
    {
        return new UserDetails("Mithun","Jaisingh","Chennai");
    }
}

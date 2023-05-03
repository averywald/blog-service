package me.averywald.blogservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam(name="name", required=false, defaultValue="world") String name) {
        String body = "hello, " + name;
        return body;
    }
}

package com.spring.professional.exam.tutorial.module07.question05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"/", "/index", "/home"})
    public String index() {
        return "index";
    }
}

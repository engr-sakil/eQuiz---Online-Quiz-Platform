package com.equiz.com.eQuiz.MainController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String homepage(){
        return "index.html";
    }
}

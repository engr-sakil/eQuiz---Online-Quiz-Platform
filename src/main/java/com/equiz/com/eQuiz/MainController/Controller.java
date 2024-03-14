package com.equiz.com.eQuiz.MainController;

import org.springframework.web.bind.annotation.RequestMapping;

public class Controller {
    @RequestMapping("/")
    public String homepage(){
        return "index.html";
    }
}

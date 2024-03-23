package com.equiz.com.eQuiz.MainController;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@org.springframework.stereotype.Controller
public class Controller {


    @GetMapping("/")
    public String homepage(){
        return "index.html";
    }
    @PostMapping("/quiz")
    public String quiz(@RequestParam String username, Model m, RedirectAttributes ra){
        if(username.equals("")){
            ra.addFlashAttribute("warning","You must enter your username");
            return "redirect:/";
        }
        return "quiz.html";
    }
}

package com.equiz.com.eQuiz.MainController;

import com.equiz.com.eQuiz.model.Question;
import com.equiz.com.eQuiz.model.QuestionForm;
import com.equiz.com.eQuiz.model.Result;
import com.equiz.com.eQuiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    Result result;

    @Autowired
    QuizService qService;
    Boolean submitted = false;

    @ModelAttribute("result")
    public Result getResult(){
        return result;
    }
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
        submitted = false;
        result.setUsername(username);

        QuestionForm qForm = qService.getQuestions();
        m.addAttribute("qForm", qForm);
        return "quiz.html";
    }

    @GetMapping("/quiz")
    public String quizhome(){
        return "index.html";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute QuestionForm qForm,Model m){
        if(!submitted){
            result.setTotalCorrect(qService.getResult(qForm));
            qService.saveScore(result);
            submitted = true;
        }
        return "result.html";
    }

    @GetMapping("/score")
    public String score(Model m){
        List<Result> sList = qService.getTopScore();
        m.addAttribute("sList", sList);

        return "scoreboard.html";
    }
}

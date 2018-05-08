package pl.oskarpolak.firstApp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormController {


    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String registerPost(@RequestParam("login") String login,
                               @RequestParam("password") String password){
        return "Pomyślnie zarejestrowano " + login;
    }

}

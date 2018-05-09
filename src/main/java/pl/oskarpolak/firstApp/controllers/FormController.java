package pl.oskarpolak.firstApp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.oskarpolak.firstApp.models.LoginForm;

import javax.validation.Valid;

@Controller
public class FormController {


    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@RequestParam("login") String login,
                               @RequestParam("password") String password,
                               Model model){
        String message;
        if(login.isEmpty() || password.isEmpty()){
            message = "Rejestracja niepomyślna";
        }else{
            message = "Rejestracja się powiodła";
        }
        model.addAttribute("info", message);
        return "register";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute @Valid LoginForm loginForm,
                            BindingResult bindingResult,
                            Model model){


        boolean isLoginCorrect  = loginForm.getLogin().equals("admin") && loginForm.getPassword().equals("admin");
        model.addAttribute("isLoginCorrect", isLoginCorrect);
        return "login";
    }

}

package pl.oskarpolak.firstApp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

}

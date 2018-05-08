package pl.oskarpolak.firstApp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Oskar");
        model.addAttribute("lastname", "Polak");
        return "index";
    }

    @GetMapping("/can/i/{age}/{name}")
    @ResponseBody
    public String canI(@PathVariable("age") int age,
                       @PathVariable("name") String name){
        return age >= 18 ? name + ", możesz wejść do klubu" : name + ", no niestety";
    }

    @GetMapping("/club/{age}")
    public String club(@PathVariable("age") int age,
                       Model model){
        model.addAttribute("age", age);
        return "club";
    }
}

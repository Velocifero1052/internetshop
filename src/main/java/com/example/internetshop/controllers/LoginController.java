package com.example.internetshop.controllers;


import com.example.internetshop.User;
import com.example.internetshop.forms.UsernameAndPassword;
import com.example.internetshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserRepository userRepository;
    @GetMapping
    public String loginPage(Model model){
        model.addAttribute("loginForm", new UsernameAndPassword());
        return "login";
    }
    @PostMapping
    public @ResponseBody UsernameAndPassword process(@ModelAttribute UsernameAndPassword loginForm){
        User user = userRepository.findByUsername(loginForm.getUsername());

        return loginForm;
    }
}

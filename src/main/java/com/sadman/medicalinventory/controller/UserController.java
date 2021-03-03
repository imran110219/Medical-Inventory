package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.model.User;
import com.sadman.medicalinventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping(value={"/login"})
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/users")
    public String getAllUsers(Model model) {
        List<User> list = service.getAllUsers();
        model.addAttribute("users", list);
//        return "user-list";
        return "users";
    }

    @GetMapping(value="/dashboard")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("dashboard");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}

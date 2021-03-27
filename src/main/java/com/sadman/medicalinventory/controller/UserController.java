package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.User;
import com.sadman.medicalinventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        model.addAttribute("user", new User());
        model.addAttribute("users", list);
        return "user-list";
    }

    @PostMapping(value="/users/add")
    public ResponseEntity<String> addUser(User user){
        service.createUser(user);
        return new ResponseEntity<>("User is added successfully", HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
            throws RecordNotFoundException {
        User user = service.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/users/edit/{id}")
    public ResponseEntity<String> editUserById(@RequestBody User newUser, @PathVariable(value = "id") Long userId) {
        service.updateUser(newUser, userId);
        return new ResponseEntity<>("User is Edited Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/users/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteUserById(@PathVariable(value = "id") Long userId){
        service.deleteUserById(userId);
        return new ResponseEntity<>("User is Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping(value="/dashboard")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("dashboard");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}

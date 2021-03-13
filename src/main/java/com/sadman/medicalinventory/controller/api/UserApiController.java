package com.sadman.medicalinventory.controller.api;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.User;
import com.sadman.medicalinventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api")
public class UserApiController {
    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<User> getAllUsers(Model model) {
        return service.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
            throws RecordNotFoundException {
        User user = service.getUserById(userId);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return service.createUser(user);
    }

    @PutMapping("/users/edit/{id}")
    public User editUserById(@RequestBody User newUser, @PathVariable(value = "id") Long userId) {
        return service.updateUser(newUser, userId);
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteUserById(@PathVariable(value = "id") Long userId){
        service.deleteUserById(userId);
    }
}

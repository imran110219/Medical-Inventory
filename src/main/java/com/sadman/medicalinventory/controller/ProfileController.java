package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.dto.ChangePasswordDTO;
import com.sadman.medicalinventory.iservice.UserService;
import com.sadman.medicalinventory.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sadman
 */
@Controller
public class ProfileController {

    @Autowired
    UserService service;

    @GetMapping(value="/profile")
    public ModelAndView profile(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = service.findUserByUserName(userName);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("profile");
        return modelAndView;
    }

    @PutMapping("/profile/edit")
    public ResponseEntity<String> editProfile(@RequestBody User newUser) {
        service.updateProfile(newUser);
        return new ResponseEntity<>("User is Edited Successfully", HttpStatus.OK);
    }

    @PutMapping("profile/changepassword")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
        service.changePassword(changePasswordDTO);
        return new ResponseEntity<>("Password is Changed Successfully", HttpStatus.OK);
    }
}

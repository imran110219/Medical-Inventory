package com.sadman.medicalinventory.exception;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author Sadman
 */
@ControllerAdvice
public class CurrentUserControllerAdvice {
//    @ModelAttribute("currentUser")
//    public UserDetails getCurrentUser(Authentication authentication) {
//        return (authentication == null) ? null : (UserDetails) authentication.getPrincipal();
//    }
}

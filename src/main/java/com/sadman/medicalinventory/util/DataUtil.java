package com.sadman.medicalinventory.util;

import com.sadman.medicalinventory.model.User;
import com.sadman.medicalinventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;

/**
 * @author Sadman
 */
public class DataUtil {

    public static String getFullName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        return "First Last";
    }
}
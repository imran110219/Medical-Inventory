package com.sadman.medicalinventory.util;

import com.sadman.medicalinventory.model.User;
import com.sadman.medicalinventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author Sadman
 */
public class DataUtil {

    @Autowired
    UserRepository userRepository;

    public static String getFullName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        String role = getUserRole();
//        For Postgres
//        role = role.substring(1, role.length() - 1);

        switch (role) {
            case "SUPER_ADMIN":
                role = "Developer";
                break;
            case "ADMIN":
                role = "Owner";
                break;
            case "USER":
                role = "Staff";
                break;
            default:
                role = "Unknown";
        }
        return role + " : " + userName;
    }

    public static String getUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        return userName;
    }

    public static String getUserRole(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String role = authentication.getAuthorities().toString();
        role = role.substring(1, role.length() - 1);
        return role;
    }

    public static Map<String, Double> convertMapToMap(List<Map<String, Long>> mapList) {
        Map<String, Double> map = new HashMap<>();
        for (int i = 0; i < mapList.size(); i++) {
            Collection<Long> mapValue = mapList.get(i).values();
            String medicine = null;
            Double number = null;
            Iterator itr = mapValue.iterator();
            while (itr.hasNext()) {
                medicine = itr.next().toString();
                number = (Double) itr.next();
            }
            map.put(medicine, number);
        }
        return map;
    }
}

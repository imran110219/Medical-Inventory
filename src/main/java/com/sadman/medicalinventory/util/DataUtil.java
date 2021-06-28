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

//    public DataUtil() {
//        loadFullName();
//    }

    private static String NAME_STATIC;

    // https://www.baeldung.com/spring-inject-static-field

//    @EventListener(ApplicationReadyEvent.class)
//    public void loadFullName() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String userName = authentication.getName();
//        User user = userRepository.findByUserName(userName);
//        NAME_STATIC = user.getFirstName() + " " + user.getLastName();
//    }

    public static String getFullName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        String role = authentication.getAuthorities().toString();
        role = role.substring(1, role.length() - 1);
        return role + " : " + userName;
//        return NAME_STATIC;
    }

    public static Map<String, Double> convertMapToMap(List<Map<String, Long>> mapList){
        Map<String, Double> map = new HashMap<>();
        for (int i = 0; i < mapList.size(); i++) {
            Collection<Long> mapValue = mapList.get(i).values();
            String medicine = null;
            Double number = null;
            Iterator itr=mapValue.iterator();
            while(itr.hasNext()){
                medicine = itr.next().toString();
                number = (Double) itr.next();
            }
            map.put(medicine, number);
        }
        return map;
    }
}

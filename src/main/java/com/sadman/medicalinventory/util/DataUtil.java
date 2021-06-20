package com.sadman.medicalinventory.util;

import com.sadman.medicalinventory.model.User;
import com.sadman.medicalinventory.repository.UserRepository;
import com.sadman.medicalinventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sadman
 */
public class DataUtil {

    public static String getFullName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        String role = authentication.getAuthorities().toString();
        role = role.substring(1, role.length() - 1);
        return role + " : " + userName;
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

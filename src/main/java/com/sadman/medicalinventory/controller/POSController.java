package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.model.User;
import com.sadman.medicalinventory.service.BrandService;
import com.sadman.medicalinventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Sadman
 */
@Controller
public class POSController {

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/pos")
    public String getPOS(Model model) {

        return "pos";
    }
}

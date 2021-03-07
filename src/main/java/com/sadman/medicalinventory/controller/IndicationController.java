package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndicationController {

    @RequestMapping(value = "/indications")
    public String getAllIndications(Model model) {
        return "indication-list";
    }
}

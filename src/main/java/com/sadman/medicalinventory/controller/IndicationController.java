package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.model.Indication;
import com.sadman.medicalinventory.model.User;
import com.sadman.medicalinventory.service.IndicationService;
import com.sadman.medicalinventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndicationController {
    @Autowired
    private IndicationService service;

    @RequestMapping(value = "/indications")
    public String getAllIndications(Model model) {
        List<Indication> list = service.getAllIndications();
        model.addAttribute("indications", list);
        return "indication-list";
    }
}

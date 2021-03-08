package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.model.DosageForm;
import com.sadman.medicalinventory.service.DosageFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DosageFormController {
    @Autowired
    private DosageFormService service;


    @RequestMapping(value = "/dosageforms")
    public String getAllUsers(Model model) {
        List<DosageForm> list = service.getAllDosageForms();
        model.addAttribute("dosageforms", list);
        return "dosageform-list";
    }

}

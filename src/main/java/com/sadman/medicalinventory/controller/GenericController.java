package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.model.Generic;
import com.sadman.medicalinventory.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GenericController {
    @Autowired
    private GenericService service;


    @RequestMapping(value = "/generics")
    public String getAllUsers(Model model) {
        List<Generic> list = service.getAllGenerics();
        model.addAttribute("generics", list);
        return "generic-list";
    }

}

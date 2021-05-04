package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.dto.InvoiceDTO;
import com.sadman.medicalinventory.dto.MedicineDTO;
import com.sadman.medicalinventory.model.Brand;
import com.sadman.medicalinventory.model.Return;
import com.sadman.medicalinventory.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sadman
 */
@Controller
public class ReturnController {
    @Autowired
    private ReturnService service;

    @RequestMapping(value = "/returns")
    public String getAllReturns(Model model) {
        List<Return> list = service.getAllReturns();
        model.addAttribute("returns", list);
        return "return-list";
    }

    @RequestMapping(value = "/returns/add")
    public String addReturn(Model model) {
        List<Brand> brandList = brandService.getAllBrands();
        List<MedicineDTO> medicineDTOList = new ArrayList<>();
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setMedicineDTOList(medicineDTOList);
        model.addAttribute("medicinedto", new MedicineDTO());
        model.addAttribute("invoicedto", invoiceDTO);
        model.addAttribute("brands", brandList);
        return "return/add-return";
    }
}

package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.iservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sadman
 */
@Controller
public class DashboardContoller {
    @Autowired
    UserService service;

    @Autowired
    RoleService roleService;

    @Autowired
    BrandService brandService;

    @Autowired
    StockService stockService;

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    SaleService saleService;

    @GetMapping(value="/dashboard")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("countBrand", brandService.countAllBrand());
        modelAndView.addObject("countExpired", stockService.getExpiredStock().size());
        modelAndView.addObject("countOutOfStock", stockService.getOutOfStock().size());
        modelAndView.addObject("totalPurchaseAmount", purchaseService.getTotalPurchaseAmount());
        modelAndView.addObject("totalSaleAmount", saleService.getTotalSaleAmount());
        modelAndView.addObject("highestSales", saleService.getHighestSale());
        modelAndView.addObject("lowestSales", saleService.getLowestSale());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}

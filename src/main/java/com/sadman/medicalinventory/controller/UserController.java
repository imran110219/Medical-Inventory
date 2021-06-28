package com.sadman.medicalinventory.controller;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.UserService;
import com.sadman.medicalinventory.model.Role;
import com.sadman.medicalinventory.model.User;
import com.sadman.medicalinventory.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private StockService stockService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private SaleService saleService;

    @GetMapping(value={"/login"})
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/users")
    public String getAllUsers(Model model) {
        List<User> list = service.getAllUsers();
        List<Role> roleList = roleService.getAllRoles();
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleList);
        model.addAttribute("users", list);
        return "user-list";
    }

    @PostMapping(value="/users/checkEmail")
    public ResponseEntity<Boolean> checkEmail(String email){
        boolean isEmail = !service.existsByEmail(email);
        return new ResponseEntity<>(isEmail, HttpStatus.OK);
    }

    @PostMapping(value="/users/checkUsername")
    public ResponseEntity<Boolean> checkUsername(String username){
        boolean isUsername = !service.existsByUserName(username);
        return new ResponseEntity<>(isUsername, HttpStatus.OK);
    }

    @PostMapping(value="/users/add")
    public ResponseEntity<String> addUser(User user){
        service.createUser(user);
        return new ResponseEntity<>("User is added successfully", HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
            throws RecordNotFoundException {
        User user = service.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/users/edit/{id}")
    public ResponseEntity<String> editUserById(@RequestBody User newUser, @PathVariable(value = "id") Long userId) {
        service.updateUser(newUser, userId);
        return new ResponseEntity<>("User is Edited Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/users/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteUserById(@PathVariable(value = "id") Long userId){
        service.deleteUserById(userId);
        return new ResponseEntity<>("User is Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping(value="/dashboard")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("countBrand", brandService.countAllBrand());
        modelAndView.addObject("countExpired", stockService.countExpiredStock());
        modelAndView.addObject("countOutOfStock", stockService.getOutOfStock().size());
         modelAndView.addObject("totalPurchaseAmount", purchaseService.getTotalPurchaseAmount());
        modelAndView.addObject("totalSaleAmount", saleService.getTotalSaleAmount());
        modelAndView.addObject("highestSales", saleService.getHighestSale());
        modelAndView.addObject("lowestSales", saleService.getLowestSale());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value="/dashboard1")
    public String home1(){
        return "dashboard";
    }
}

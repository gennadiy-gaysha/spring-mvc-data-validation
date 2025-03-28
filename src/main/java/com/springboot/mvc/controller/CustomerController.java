package com.springboot.mvc.controller;

import com.springboot.mvc.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @GetMapping("/customer-form")
    public String showCustomerForm(Model theModel){
        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/processed-customer-form")
    public String processCustomerForm(@ModelAttribute("customer") Customer theCustomer){
        System.out.println(theCustomer);
        return "processed-customer-form";
    }

}

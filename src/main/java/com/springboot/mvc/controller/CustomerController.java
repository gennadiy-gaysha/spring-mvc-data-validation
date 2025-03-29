package com.springboot.mvc.controller;

import com.springboot.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @GetMapping("/customer-form")
    public String showCustomerForm(Model theModel) {
        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/processed-customer-form")
    // @Valid corresponds to validation rules in the Customer class and tells
    // Spring MVC to perform validation
    // theBindingResult holds the validation result
    public String processCustomerForm(@Valid @ModelAttribute("customer") Customer theCustomer,
                                      BindingResult theBindingResult) {
        System.out.println(theCustomer);
        System.out.println(theBindingResult);

        if(theBindingResult.hasErrors()){
            return "customer-form";
        }else{
            return "processed-customer-form";
        }

    }

}

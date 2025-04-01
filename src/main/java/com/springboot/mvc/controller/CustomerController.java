package com.springboot.mvc.controller;

import com.springboot.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    // Pre-processing each web-request to the controller by:
    // removing leading and trailing white space
    // if String only has white spaces trims it to null
    // Add support for @InitBinder and StringTrimmerEditor
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


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
        // debug whitespaces in the lastName
        System.out.println("Last name: |" + theCustomer.getLastName() + "|");

        if (theBindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "processed-customer-form";
        }

    }

}

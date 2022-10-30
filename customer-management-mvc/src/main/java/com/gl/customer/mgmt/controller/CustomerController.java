package com.gl.customer.mgmt.controller;

import com.gl.customer.mgmt.dao.CustomerDAO;
import com.gl.customer.mgmt.entity.Customer;
import com.gl.customer.mgmt.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        List<Customer> customersList = customerService.getCustomers();
        theModel.addAttribute("customers", customersList);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer",theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer")Customer theCustomer){
        customerService.saveCustomer(theCustomer);
        //return "list-customers";
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId")int custId, Model theModel){

        Customer customer = customerService.getCustomer(custId);
        theModel.addAttribute(customer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int custId){
        customerService.deleteCustomer(custId);
        return "redirect:/customer/list";
    }
}

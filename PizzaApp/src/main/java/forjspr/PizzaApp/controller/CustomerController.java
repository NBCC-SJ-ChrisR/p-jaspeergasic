/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forjspr.PizzaApp.controller;

import forjspr.PizzaApp.entities.Customer;
import forjspr.PizzaApp.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author forjspr
 */
@RestController
@RequestMapping("api/Customer")
public class CustomerController {
    @Autowired
    private CustomerService cusService;

    @GetMapping
    public List<Customer> getCustomers() {
        return cusService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable(value="id") Integer id) {
        return cusService.getCustomer(id);
    }
}

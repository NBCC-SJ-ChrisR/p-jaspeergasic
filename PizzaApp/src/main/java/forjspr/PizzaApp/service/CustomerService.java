/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forjspr.PizzaApp.service;

import forjspr.PizzaApp.entities.Customer;
import forjspr.PizzaApp.repository.CustomerRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author forjspr
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepo cusRepo;

    public List<Customer> getCustomers() {
        return cusRepo.findAll();
    };
    
    public Customer getCustomer(Integer id) {
        return cusRepo.findById(id).get();
    };
}

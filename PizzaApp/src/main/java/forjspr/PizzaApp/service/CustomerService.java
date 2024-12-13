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
    }

    ;
    
    public Customer getCustomer(Integer id) {
        return cusRepo.findById(id).get();
    }

    ;
    
    public Customer addCustomer(Customer customer) {
        return cusRepo.save(customer);
    }

    public Customer updateCustomer(Customer c) {
        Customer cust = cusRepo.findById(c.getId()).get();

        cust.setFirstName(c.getFirstName());
        cust.setLastName(c.getLastName());
        cust.setPhoneNumber(c.getPhoneNumber());
        cust.setEmail(c.getEmail());
        cust.setHouseNumber(c.getHouseNumber());
        cust.setPassword(c.getPassword());
        cust.setProvince(c.getProvince());
        cust.setPostalCode(c.getPostalCode());
        cust.setStreet(c.getStreet());

        return cusRepo.save(cust);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forjspr.PizzaApp.service;

import forjspr.PizzaApp.entities.Customer;
import forjspr.PizzaApp.entities.Order;
import forjspr.PizzaApp.repository.CustomerRepo;
import forjspr.PizzaApp.repository.OrderRepo;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author forjspr
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private CustomerRepo cusRepo;

    public List<Order> getOrders() {
        return orderRepo.findAll();
    }

    public Order getOrder(Integer id) {
        return orderRepo.findById(id).get();
    }

    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    public Order updateOrder(Order o) {
        Order order = orderRepo.findById(o.getId()).get();

        order.setDeliveryDate(order.getDeliveryDate());
        order.setOrderStatus(o.getOrderStatus());

        return orderRepo.save(order);
    }
}

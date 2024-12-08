/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forjspr.PizzaApp.controller;

import forjspr.PizzaApp.entities.Order;
import forjspr.PizzaApp.service.OrderService;
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
@RequestMapping("api/Order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    @GetMapping
    public List<Order> getOrders(){
        return orderService.getOrders();
    }
    
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable(value="id") Integer id){
        return orderService.getOrder(id);
    }
}

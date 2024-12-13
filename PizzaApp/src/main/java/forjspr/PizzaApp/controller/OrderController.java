/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forjspr.PizzaApp.controller;

import forjspr.PizzaApp.entities.Customer;
import forjspr.PizzaApp.entities.Order;
import forjspr.PizzaApp.service.CustomerService;
import forjspr.PizzaApp.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author forjspr
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    private CustomerService csService;

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> o = orderService.getOrders();
        return ResponseEntity.ok(o);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable(value = "id") Integer id) {
        Order o = orderService.getOrder(id);
        return ResponseEntity.ok(o);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order o = orderService.createOrder(order);
        return ResponseEntity.status(201).body(o);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        Order o = orderService.updateOrder(order);
        return ResponseEntity.ok(o);
    }
}

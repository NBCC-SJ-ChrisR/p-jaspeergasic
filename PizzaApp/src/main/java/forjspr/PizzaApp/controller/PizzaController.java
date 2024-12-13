/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forjspr.PizzaApp.controller;

import forjspr.PizzaApp.entities.Pizza;
import forjspr.PizzaApp.service.PizzaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author forjspr
 */
@RestController
@RequestMapping("/pizza")
public class PizzaController {
    @Autowired
    private PizzaService pizzaService;
    
    @GetMapping
    public ResponseEntity<List<Pizza>> getPizzas(){
        List<Pizza> p = pizzaService.getPizzas();
        return ResponseEntity.ok(p);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getPizza(@PathVariable(value="id") Integer id){
        Pizza p = pizzaService.getPizza(id);
        return ResponseEntity.ok(p);
    }
    
    @PostMapping
    public ResponseEntity<Pizza> createPizza(@RequestBody Pizza pizza){
        Pizza p = pizzaService.addPizza(pizza);
        return ResponseEntity.status(201).body(p);
    }
}

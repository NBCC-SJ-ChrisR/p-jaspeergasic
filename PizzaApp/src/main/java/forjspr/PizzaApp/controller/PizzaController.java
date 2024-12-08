/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forjspr.PizzaApp.controller;

import forjspr.PizzaApp.entities.Pizza;
import forjspr.PizzaApp.service.PizzaService;
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
@RequestMapping("api/Pizza")
public class PizzaController {
    @Autowired
    private PizzaService pizzaService;
    
    @GetMapping
    public List<Pizza> getPizzas(){
        return pizzaService.getPizzas();
    }
    
    @GetMapping("/{id}")
    public Pizza getPizza(@PathVariable(value="id") Integer id){
        return pizzaService.getPizza(id);
    }
}

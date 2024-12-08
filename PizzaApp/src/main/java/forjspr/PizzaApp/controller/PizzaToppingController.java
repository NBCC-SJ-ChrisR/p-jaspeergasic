/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forjspr.PizzaApp.controller;

import forjspr.PizzaApp.entities.PizzaTopping;
import forjspr.PizzaApp.service.PizzaToppingService;
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
@RequestMapping("api/PizzaTopping")
public class PizzaToppingController {
    @Autowired
    private PizzaToppingService ptService;
    
    @GetMapping
    public List<PizzaTopping> getToppings(){
        return ptService.getToppings();
    }
    
    @GetMapping("/{id}")
    public PizzaTopping getTopping(@PathVariable(value="id") Integer id){
        return ptService.getTopping(id);
    }
}

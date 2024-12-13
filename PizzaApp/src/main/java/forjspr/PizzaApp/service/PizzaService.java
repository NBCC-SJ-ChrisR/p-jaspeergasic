/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forjspr.PizzaApp.service;

import forjspr.PizzaApp.entities.Pizza;
import forjspr.PizzaApp.repository.PizzaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author forjspr
 */
@Service
public class PizzaService {
    @Autowired
    private PizzaRepo pizzaRepo;
    
    public List<Pizza> getPizzas(){
        return pizzaRepo.findAll();
    }
    
    public Pizza getPizza(Integer id){
        return pizzaRepo.findById(id).get();
    }
    
    //POST
    public Pizza addPizza(Pizza pizza) {
        return pizzaRepo.save(pizza);
    }
}

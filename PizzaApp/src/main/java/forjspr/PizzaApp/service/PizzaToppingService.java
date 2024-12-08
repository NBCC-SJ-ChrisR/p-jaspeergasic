/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forjspr.PizzaApp.service;

import forjspr.PizzaApp.entities.PizzaTopping;
import forjspr.PizzaApp.repository.PizzaToppingRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author forjspr
 */
@Service
public class PizzaToppingService {

    @Autowired
    private PizzaToppingRepo ptRepo;

    public List<PizzaTopping> getToppings() {
        return ptRepo.findAll();
    }

    public PizzaTopping getTopping(Integer id) {
        return ptRepo.findById(id).get();
    }
}

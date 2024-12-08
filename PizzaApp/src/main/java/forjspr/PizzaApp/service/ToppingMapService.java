/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forjspr.PizzaApp.service;

import forjspr.PizzaApp.entities.ToppingMap;
import forjspr.PizzaApp.repository.ToppingMapRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author forjspr
 */
@Service
public class ToppingMapService {
    @Autowired
    private ToppingMapRepo tmRepo;
    
    public List<ToppingMap> getAll(){
        return tmRepo.findAll();
    }
   
}

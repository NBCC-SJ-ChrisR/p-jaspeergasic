/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forjspr.PizzaApp.controller;

import forjspr.PizzaApp.entities.ToppingMap;
import forjspr.PizzaApp.service.ToppingMapService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author forjspr
 */
@RestController
@RequestMapping("api/ToppingMap")
public class ToppingMapController {
    @Autowired
    private ToppingMapService tmService;
    
    @GetMapping
    public List<ToppingMap> getAll(){
        return tmService.getAll();
    }
 
}

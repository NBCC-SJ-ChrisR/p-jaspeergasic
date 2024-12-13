/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forjspr.PizzaApp.controller;

import forjspr.PizzaApp.entities.ToppingMap;
import forjspr.PizzaApp.service.ToppingMapService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author forjspr
 */
@RestController
@RequestMapping("/toppingmap")
public class ToppingMapController {
    @Autowired
    private ToppingMapService tmService;
    
    @GetMapping
    public ResponseEntity<List<ToppingMap>> getAll(){
        List<ToppingMap> tm = tmService.getAll();
        return ResponseEntity.ok(tm);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ToppingMap> getTopping(@PathVariable(value = "id") Integer id) {
        ToppingMap tm = tmService.getTopping(id);
        return ResponseEntity.ok(tm);
    }

    @PostMapping
    public ResponseEntity<ToppingMap> createTopping(@RequestBody ToppingMap topping) {
        ToppingMap tm = tmService.addTopping(topping);
        return ResponseEntity.status(201).body(tm);
    }
 
}

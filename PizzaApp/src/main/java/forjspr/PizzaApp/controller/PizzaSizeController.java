/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forjspr.PizzaApp.controller;

import forjspr.PizzaApp.entities.PizzaSize;
import forjspr.PizzaApp.service.PizzaSizeService;
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
@RequestMapping("api/PizzaSize")
public class PizzaSizeController {

    @Autowired
    private PizzaSizeService psService;

    @GetMapping
    public List<PizzaSize> getSizes() {
        return psService.getSizes();
    }

    @GetMapping("/{id}")
    public PizzaSize getSize(@PathVariable(value = "id") Integer id) {
        return psService.getSize(id);
    }
}

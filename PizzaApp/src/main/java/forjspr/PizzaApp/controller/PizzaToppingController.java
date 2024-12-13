package forjspr.PizzaApp.controller;

import forjspr.PizzaApp.entities.PizzaTopping;
import forjspr.PizzaApp.service.PizzaToppingService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author forjspr
 */
@RestController
@RequestMapping("/pizzatopping")
public class PizzaToppingController {

    @Autowired
    private PizzaToppingService ptService;

    @GetMapping
    public ResponseEntity<List<PizzaTopping>> getToppings() {
        List<PizzaTopping> toppings = ptService.getToppings();
        return ResponseEntity.ok(toppings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaTopping> getTopping(@PathVariable(value = "id") Integer id) {
        PizzaTopping topping = ptService.getTopping(id);
        return ResponseEntity.ok(topping);
    }
    
    @GetMapping("/customer")
    public ResponseEntity<List<PizzaTopping>> getActive(){
        List<PizzaTopping> topping = ptService.getActive();
        return ResponseEntity.ok(topping);
    }

    @PostMapping
    public ResponseEntity<PizzaTopping> createTopping(@RequestBody PizzaTopping topping) {
        System.out.println(topping);
        PizzaTopping tp = ptService.addTopping(topping);
        return ResponseEntity.status(201).body(tp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PizzaTopping> updateTopping(@RequestBody PizzaTopping topping) {
        PizzaTopping tp = ptService.updateTopping(topping);
        return ResponseEntity.ok(tp);
    }

    @DeleteMapping("/{id}")
    public void deleteTopping(@PathVariable(value = "id") Integer id) {
        ptService.deleteTopping(id);
    }
}

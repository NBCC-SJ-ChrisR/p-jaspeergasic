package forjspr.PizzaApp.controller;

import forjspr.PizzaApp.entities.PizzaSize;
import forjspr.PizzaApp.service.PizzaSizeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author forjspr
 */
@RestController
@RequestMapping("/pizzasize")
public class PizzaSizeController {

    @Autowired
    private PizzaSizeService psService;

    @GetMapping
    public ResponseEntity<List<PizzaSize>> getSizes() {
        List<PizzaSize> sizes = psService.getSizes();
        return ResponseEntity.ok(sizes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaSize> getSize(@PathVariable(value = "id") Integer id) {
        PizzaSize size = psService.getSize(id);
        System.out.println(size);
        return  ResponseEntity.ok(size);
    }
}

package forjspr.PizzaApp.controller;

import forjspr.PizzaApp.entities.PizzaCrust;
import forjspr.PizzaApp.service.PizzaCrustService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author forjspr
 */
@RestController
@RequestMapping("/pizzacrust")
public class PizzaCrustController {

    @Autowired
    private PizzaCrustService pcService;

    @GetMapping
    public List<PizzaCrust> getAll() {
        return pcService.getAll();
    }

    @GetMapping("/{id}")
    public PizzaCrust getById(@PathVariable(value = "id") Integer id) {
        return pcService.getById(id);
    }
}

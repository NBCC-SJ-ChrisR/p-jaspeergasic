package forjspr.PizzaApp.controller;

import forjspr.PizzaApp.entities.Employee;
import forjspr.PizzaApp.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author forjspr
 */
@RestController
@RequestMapping("api/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @GetMapping
    public List<Employee> getEmployees() {
        return empService.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable(value="id") Integer id) {
        return empService.getEmployee(id);
    }

}

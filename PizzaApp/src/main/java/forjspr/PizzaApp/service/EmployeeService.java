
package forjspr.PizzaApp.service;

import forjspr.PizzaApp.entities.Employee;
import forjspr.PizzaApp.repository.EmployeeRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author forjspr
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo empRepo;
    
    public List<Employee> getEmployees(){
      return empRepo.findAll();
    };
    
    public Employee getEmployee(Integer id){
        return empRepo.findById(id).get();
    };
}

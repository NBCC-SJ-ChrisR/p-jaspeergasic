
package forjspr.PizzaApp.repository;

import forjspr.PizzaApp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author forjspr
 */
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}

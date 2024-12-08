
package forjspr.PizzaApp.repository;
import forjspr.PizzaApp.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author forjspr
 */
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    
}

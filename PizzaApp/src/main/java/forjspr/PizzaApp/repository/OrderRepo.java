package forjspr.PizzaApp.repository;

import forjspr.PizzaApp.entities.Customer;
import forjspr.PizzaApp.entities.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author forjspr
 */
public interface OrderRepo extends JpaRepository<Order, Integer> {

}

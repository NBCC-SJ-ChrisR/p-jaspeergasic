package forjspr.PizzaApp.repository;

import forjspr.PizzaApp.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author forjspr
 */
public interface PizzaRepo extends JpaRepository<Pizza, Integer> {

}
